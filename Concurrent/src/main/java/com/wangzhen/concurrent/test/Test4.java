package com.wangzhen.concurrent.test;

import org.junit.Test;

public class Test4 {
    int a =0,i=0;
    boolean flag = false;
    public static void main(String[] args) {

    }

    @Test
    public void testVolatie() throws InterruptedException {
        while (true){

           Thread t1= new Thread(new Runnable() {
                @Override
                public void run() {
                    write();
                }
            }) ;
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    read();
                }
            });
            t1.start();
            t2.start();
            t2.join();
            t1.join();

            if(i==0){
                System.out.println(i);
            }
            i=0;

        }



    }
    public void write(){
        a=1;
        flag=true;
    }
    public void read(){
        if(flag){
            i =a;
        }else {

        }

    }
}
