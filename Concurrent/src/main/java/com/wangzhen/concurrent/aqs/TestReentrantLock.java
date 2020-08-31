package com.wangzhen.concurrent.aqs;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class TestReentrantLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    }
}
