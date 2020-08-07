package com.wangzhen.concurrent.thread.createThread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    public Integer call() throws Exception {
        return 100;
    }
}
