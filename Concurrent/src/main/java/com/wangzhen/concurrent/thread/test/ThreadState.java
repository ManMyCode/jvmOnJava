package com.wangzhen.concurrent.thread.test;

import com.wangzhen.concurrent.util.SleepUtils;

public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"timeWaiting").start();
        new Thread(new Waiting(),"Waiting").start();
        new Thread(new Blocked(),"blocked-1").start();
        new Thread(new Blocked(),"blocked-2").start();
    }

    static class TimeWaiting implements Runnable{

        @Override
        public void run() {
            while (true){
              SleepUtils.second(100);
            }
        }
    }

    static class Waiting implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized (Blocked.class){
                SleepUtils.second(100);
            }

        }
    }
}
