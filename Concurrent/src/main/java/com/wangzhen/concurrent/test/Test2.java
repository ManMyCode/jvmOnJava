package com.wangzhen.concurrent.test;

import java.lang.management.ThreadInfo;

public class Test2 {
    static  int x=0,y=0,a=0,b=0,i;
    //static volatile int x=0,y=0,a=0,b=0,i;
    public static void main(String[] args) throws InterruptedException {

        while (true){
            x=y=a=b=0;
            Thread t1=new Thread(new Runnable() {
                @Override
                public void run() {
                    a=1;
                    y=b;
                }
            });
            Thread t2=new Thread(new Runnable() {
                @Override
                public void run() {
                    b=1;
                    x=a;
                }
            },"t1");
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if(x==0&&y==0){
                //System.out.println(x+"="+y+"+"+a+"="+"="+b);
                System.out.println(i++);
                break;
            }else {
                i++;
               // System.out.println(x+"="+y+"+"+a+"="+"="+b);

            }
        }

    }


}
