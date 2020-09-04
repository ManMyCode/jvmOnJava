package com.wangzhen.concurrent.juc.park;

import com.wangzhen.concurrent.util.SleepUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.LockSupport;

public class testPark {
    static  Logger logger = LoggerFactory.getLogger(testPark.class);
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            logger.debug("start...");
            SleepUtils.second(2);
            logger.debug("park....");
            LockSupport.park();
            logger.debug("resume");
        });
        t1.start();
        SleepUtils.second(1);
        logger.debug("unpark....");
        LockSupport.unpark(t1);
    }
}
