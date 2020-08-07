package com.wangzhen.concurrent.thread.frames;

public class testFrames {
    public static void main(String[] args) {
         Thread t1 = new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println();
                 method1(100);

             }
         });
         t1.setName("t1");
         t1.start();

         method1(200);
    }

    public static void method1(int x){
        System.out.println(x);
        System.out.println(x);
        System.out.println(x);
        System.out.println(x);

    }
}
