package com.wangzhen.concurrent.test;

import com.wangzhen.concurrent.util.SleepUtils;

public class test6 {
    static volatile boolean  flag = true;
    public static  void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag){

                }
                System.out.println("end");
            }
        }).start();


        flag=false;
        SleepUtils.second(1);
    }
}
