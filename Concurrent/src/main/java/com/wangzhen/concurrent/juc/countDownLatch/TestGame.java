package com.wangzhen.concurrent.juc.countDownLatch;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestGame {
    public static void main(String[] args) throws InterruptedException {


        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService service = Executors.newFixedThreadPool(10);
        String [] arrays = new String[10];
        for (int j = 0; j < 10; j++) {
            int k =j;
            service.submit(()->{
                for (int i = 0; i <= 100; i++) {
                    arrays[k] = i+"%";
                    try {
                        Thread.sleep(new Random().nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("\r"+ Arrays.toString(arrays));
                }
                latch.countDown();
            });

        }
        latch.await();
        System.out.println();
        System.out.println("游戏开始");
        service.shutdown();
    }
}
