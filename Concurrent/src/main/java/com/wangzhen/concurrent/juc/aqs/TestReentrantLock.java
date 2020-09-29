package com.wangzhen.concurrent.juc.aqs;

import java.util.concurrent.locks.*;

public class TestReentrantLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    }
}
