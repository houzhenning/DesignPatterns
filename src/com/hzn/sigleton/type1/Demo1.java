package com.hzn.sigleton.type1;

/**
 * @author houzhenning
 * @date 2021/12/4
 */
public class Demo1 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1 == instance);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());

        Singleton2 instance2 = Singleton2.getInstance2();
        Singleton2 instance21 = Singleton2.getInstance2();
        System.out.println(instance2 == instance21);
        System.out.println(instance2.hashCode());
        System.out.println(instance21.hashCode());
    }
}

/**
 * 饿汉式(静态方法）
 * 优缺点：
 *      优点：写法简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 *      缺点：在类装载的时候就完成了实例化，没有达到Lazy Loading的效果。如果从始至终未使用该实例，会造成内存的浪费。
 */
class Singleton {
    //1. 构造器私有化 外部不能new
    private Singleton() {}

    //2. 本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    //3. 对外开放一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
}
    /**
     * 饿汉式(静态代码块)
     * 优缺点同上 也是在类装载的时候创建
     */
class Singleton2 {

    private Singleton2 () {}

    private static Singleton2 instance2;

    static {
        instance2 = new Singleton2();
    }

    public static Singleton2 getInstance2() {
        return instance2;
    }
}

