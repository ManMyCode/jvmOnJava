package com.wangzhen.concurrent.test;

import org.junit.Test;

import java.util.ArrayList;

public class test5 {
    volatile int a=0;

    public synchronized void add (){
        for(int i=0;i<1000;i++){
            a++;
        }

    }
    @Test
    public void test() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i =0;i<100;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    add();
                }
            });
            threads.add(thread);
        }
        for (Thread thread : threads){
            thread.start();
        }
//        for (Thread thread : threads){
//            thread.join();
//        }
        System.out.println(a);
    }
}
