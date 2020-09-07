package com.wangzhen.threadLocal;

public class TestThreadLocal {
    static ThreadLocal<Person> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(2000);
                System.out.println(threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new Person());
        }).start();

    }

}

class Person{
    String name ="zhangshan";
}