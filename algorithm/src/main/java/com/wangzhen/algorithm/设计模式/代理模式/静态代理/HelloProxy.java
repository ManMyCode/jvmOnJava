package com.wangzhen.algorithm.设计模式.代理模式.静态代理;

import com.wangzhen.algorithm.设计模式.代理模式.动态代理.Hello;
import com.wangzhen.algorithm.设计模式.代理模式.动态代理.HelloImpl;

/**
 * Description:
 * Datetime:    2020/10/26   8:26 下午
 * Author:   王震
 */
public class HelloProxy implements Hello {
    Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }

    @Override
    public void say() {
        System.out.println("before");
        hello.say();
        System.out.println("after");
    }

    public static void main(String[] args) {
        Hello hello = new HelloProxy();
        hello.say();
    }


}
