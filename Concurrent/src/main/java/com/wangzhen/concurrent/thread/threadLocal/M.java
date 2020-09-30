package com.wangzhen.concurrent.thread.threadLocal;

public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
