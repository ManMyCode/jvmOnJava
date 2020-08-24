package com.wangzhen.concurrent.test;

import com.wangzhen.concurrent.util.SleepUtils;

public class Test3 {
    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                while (!Thread.interrupted()){
                    System.out.println("线程正在运行"+i++);
                }
                System.out.println("线程被打断了");
            }
        });
        t1.start();
        SleepUtils.second(1);
        t1.interrupt();
    }

    public void f1(int a){

    }
}
