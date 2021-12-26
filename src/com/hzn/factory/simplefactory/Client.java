package com.hzn.factory.simplefactory;


public class Client {
    public static void main(String[] args) {
        // 在客户端代码中，通过调用工厂类的工厂方法即可得到产品对象。
        Product productA = SimpleFactory.getProduct("A");

    }
}
