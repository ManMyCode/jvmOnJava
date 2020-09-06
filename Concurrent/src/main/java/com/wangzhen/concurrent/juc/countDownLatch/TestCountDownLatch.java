package com.wangzhen.concurrent.juc.countDownLatch;

import com.wangzhen.concurrent.util.SleepUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {
    Logger logger = LoggerFactory.getLogger(TestCountDownLatch.class);
    @Test
    public void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                logger.debug("开始干活");
                SleepUtils.second(1);

                logger.debug("干活结束");
                latch.countDown();
            }).start();
        }
        logger.debug("start");
        latch.await();
        logger.debug("end");
    }


}
