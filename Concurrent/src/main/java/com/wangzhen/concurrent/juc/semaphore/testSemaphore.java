package com.wangzhen.concurrent.juc.semaphore;

import com.wangzhen.concurrent.util.SleepUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class testSemaphore {
    static Logger logger = LoggerFactory.getLogger(testSemaphore.class);


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);


        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                try {
                    // 获得许可
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    logger.debug("running....");
                    SleepUtils.second(1);
                    logger.debug("ending....");
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
