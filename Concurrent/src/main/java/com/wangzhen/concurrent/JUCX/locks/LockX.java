package com.wangzhen.concurrent.JUCX.locks;

import com.sun.istack.NotNull;



public interface LockX {
    void lock();
    void lockInterruptibly() throws InterruptedException;
    boolean tryLock();
    void unlock();
    @NotNull
    ConditionX newCondition();
}
