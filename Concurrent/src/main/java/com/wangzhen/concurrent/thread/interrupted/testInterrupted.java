package com.wangzhen.concurrent.thread.interrupted;

public class testInterrupted {
    public static class MyThread extends Thread{
        public void run(){
            try {
                Thread.sleep(2000);
                System.out.println("myThread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
        myThread.interrupt();
        System.out.println("Main run");
    }
}
