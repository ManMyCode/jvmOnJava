package com.wangzhen.concurrent.thread.createThread;


import org.junit.Test;

public class App {
    public static void main(String[] args) {

    }

    @Test
    public void testRunnable(){
        MyRunnable instance = new MyRunnable();
        Thread thread = new Thread(instance);
        thread.start();
    }

    @Test
    public void testCallable(){
        MyCallable myCallable = new MyCallable();

    }
    @Test
    public void testThread(){
        MyThread myThread=new MyThread();
        myThread.start();
    }

}
