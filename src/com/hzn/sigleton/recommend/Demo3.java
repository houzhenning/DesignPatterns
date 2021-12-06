package com.hzn.sigleton.recommend;

public class Demo3 {

}

/**
 * 静态内部类方式：当外部类被访问时，并不会加载内部类，所以只要不访问SingletonHolder 这个内部类，Singleton
 * 就不会实例化，这就相当于实现了懒加载的效果，只有当SingletonHolder.singleton 被调用时访问内部类的属性，此时才会将
 * 对象实例化，这样既解决了饿汉模式下可能造成的资源浪费问题，也避免了懒汉模式下的并发问题
 */
class Singleton {
    private static Singleton instance = null;
    private Singleton() {};

    private Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder {
        private static Singleton singleton = new Singleton();
    }
}

/**
 * 枚举类实现单例模式
 * 像常规类一样编写enum类，为其添加变量和方法，访问方式也更简单，使用EnumSingleton.INSTANCE进行访问，这样也就避免
 * 调用getInstance方法，更重要的是使用枚举单例的写法，我们完全不用考虑序列化和反射的问题。
 */

enum EnumSingleton {
    INSTANCE;

}
