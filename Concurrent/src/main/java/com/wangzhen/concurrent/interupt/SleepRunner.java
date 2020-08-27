package com.wangzhen.concurrent.interupt;

import com.wangzhen.concurrent.util.SleepUtils;

public class SleepRunner implements Runnable{
    @Override
    public void run() {
        while (true){
            SleepUtils.second(10);

        }
    }
}
