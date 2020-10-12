package com.wangzhen.ref.threadlocal;

import org.junit.Test;

/**
 * Description:
 * Datetime:    2020/10/12   11:24 下午
 * Author:   王震
 */
public class Demo3 {


    @Test
    public void test01(){
        ThreadLocal<byte[]> threadLocal = new ThreadLocal();
        // 8m 设置key8m
        threadLocal.set(new byte[8*1024*1024]);
        System.out.println(threadLocal.get());
        System.gc();
        System.out.println(threadLocal.get());
    }
}
