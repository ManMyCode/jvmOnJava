package com.wangzhen.concurrent.thread.createThread;

import java.util.Random;

public class MyRunnable implements Runnable{
    public void run() {
        System.out.println(new Random().nextInt(1000));
    }
}
