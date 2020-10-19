package com.wangzhen.ref.threadlocal;


import org.junit.Test;

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
            threadLocal.set(new Person("p1"));
        }).start();

    }

    /**
     同一个线程去操作的时候会覆盖之前设置的值 因为他是以 threadlocal 为key
     */
    @Test
    public void test02(){
        ThreadLocal<Person> person = new ThreadLocal<>();
        person.set(new Person("p1"));
        person.set(new Person("p2"));
        System.out.println(person.get().toString());
    }

    static class Person{
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}

