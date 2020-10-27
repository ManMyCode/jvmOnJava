package com.wangzhen.algorithm.设计模式.代理模式.动态代理;

/**
 * Description:
 * Datetime:    2020/10/26   8:25 下午
 * Author:   王震
 */
public class HelloImpl implements Hello{
    @Override
    public void say() {
        System.out.println("hello world");
    }
}
