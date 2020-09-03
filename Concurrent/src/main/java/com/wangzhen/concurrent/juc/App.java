package com.wangzhen.concurrent.juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    int a;
    int b;
    public static void main(String[] args) {
//        ConcurrentHashMap hashMap = new ConcurrentHashMap();
//        App app =new App();
//        app.a =1;
//        App app2 = app;
//        System.out.println(app2.a);
//        ReentrantLock lock = new ReentrantLock();
//        lock.lock();
//        LockSupport.park();
        System.out.println(8<<1);
    }
}
