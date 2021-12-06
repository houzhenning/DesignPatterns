package com.hzn.sigleton.type2;

public class Demo2 {

}


/**
 * 懒汉式 不可用 多线程不安全
 * 问题出现在 if（instance == null) ,多线程环境下，可能有多个线程同时拿到instance的值为null
 * 是否懒加载： 是
 */
class IdlerSingleton {
    private static IdlerSingleton instance = null;
    private IdlerSingleton() {

    }

    private static IdlerSingleton getInstance() {
        if (instance == null) {
            instance = new IdlerSingleton();
        }
        return instance;
    }

}

/**
 * 懒汉式 + 同步方法
 * 不推荐使用 性能差
 * 懒加载
 * synchronized修饰方法，使得多线程执行退化为串行执行，性能差
 *
 */
class IdlerSynSingleton {
    private static IdlerSynSingleton instance = null;

    private IdlerSynSingleton() {};

    private static synchronized IdlerSynSingleton getInstance() {
        if (instance == null) {
            instance = new IdlerSynSingleton();
        }
        return instance;
    }
}

/**
 * 懒汉式 + 同步代码块
 * 不推荐使用线程不安全
 */

class IdlerSyncSingleton {
    private static IdlerSyncSingleton instance;

    private IdlerSyncSingleton() {};

    private static IdlerSyncSingleton getInstance() {
        if (instance == null) {
            synchronized (IdlerSyncSingleton.class) {
                instance = new IdlerSyncSingleton();
            }
        }
        return instance;
    }
}

/**
 * DCL单例模式+Volatile【可用】
 * 为了解决上个方法的线程不安全问题，引入双重锁（Double Check Locking) 同时引入volatile关键字修饰对象，这是为了避免因JVM指令
 * 重排序可能导致的空指针异常。因为线程执行到第一个if（null == instace）时，代码可能读取到instance不为null，但此时instance
 * 引用的对象可能还没有初始化完成。
 */

class DCLSingleton {
    private static volatile DCLSingleton instance = null;

    private DCLSingleton() {};

    private static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                instance = new DCLSingleton();
            }
        }
        return instance;
    }
}

