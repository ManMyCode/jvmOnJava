package com.wangzhen.algorithm.设计模式.代理模式.动态代理;

import java.lang.reflect.Proxy;

/**
 * Description:
 * Datetime:    2020/10/28   5:24 下午
 * Author:   王震
 */
public class App {
    public static void main(String[] args) {
        HelloImpl helloImpl = new HelloImpl();
        ClassLoader classLoader = helloImpl.getClass().getClassLoader();
        Class<?>[] interfaces = helloImpl.getClass().getInterfaces();
        LogHandler logHandler = new LogHandler(helloImpl);
        Hello hello = (Hello) Proxy.newProxyInstance(classLoader, interfaces, logHandler);
        hello.say();


    }
}
