package com.hzn.factory.simplefactory;

/**
 * 简单工厂模式（Simple Factory Pattern): 定义一个工厂类，它可以根据参数的不同返回不同的实例，被创建的实例通常都具有共同的类。
 * 因为在简单工厂模式中用于创建实例的方法是静态方法，因此简单工厂模式又称为静态工厂方法（Static Factory Method）模式，它属于
 * 类创建型模式
 */
public class SimpleFactory {
    // 静态工厂方法
    public static Product getProduct(String arg) {
        if ("A".equalsIgnoreCase(arg)) {
            return new ConcreteProductA();
        } else if ("B".equalsIgnoreCase(arg)) {
            return new ConcreteProductB();
        } else {
            return null;
        }
    }
}
