package com.wangzhen.concurrent.thread.Synchronized;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {
    public void fun(){
        synchronized (this){
            for (int i=0;i<10;i++){
                System.out.println(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        SynchronizedExample e=new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->e.fun());
        executorService.execute(()->e.fun());
    }
}
