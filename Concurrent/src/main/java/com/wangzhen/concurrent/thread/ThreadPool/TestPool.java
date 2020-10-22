package com.wangzhen.concurrent.thread.ThreadPool;

import com.wangzhen.concurrent.util.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Datetime:    2020/10/21   9:12 下午
 * Author:   王震
 */
public class TestPool {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2, 2000, TimeUnit.MILLISECONDS, 10);
        for (int i = 0; i < 15; i++) {
            int j = i;
            threadPool.execute(()->{
                SleepUtils.second(2);
                System.out.println(j);
            });
        }
    }
}
