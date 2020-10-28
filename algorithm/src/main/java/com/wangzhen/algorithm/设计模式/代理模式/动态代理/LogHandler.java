package com.wangzhen.algorithm.设计模式.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 * Datetime:    2020/10/27   2:46 下午
 * Author:   王震
 */
public class LogHandler implements InvocationHandler {
    Object target;  // 被代理的对象，实际的方法执行者

    public LogHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target,args);
        after();
        return result ;
    }

    public void before(){
        System.out.println("日志打印之前的操作");
    }

    public void after(){
        System.out.println("日志打印之后的操作");
    }


}
