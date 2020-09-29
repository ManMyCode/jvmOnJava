package com.wangzhen.concurrent.JUCX.locks;



public interface ReadWriteLock {
     Lock readLock();

     Lock writeLock();
}
