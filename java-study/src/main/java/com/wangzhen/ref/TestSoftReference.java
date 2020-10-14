package com.wangzhen.ref;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.util.Arrays;

// 软引用
// 只有当gc 时 java 虚拟机空间不足时 才会回收
public class TestSoftReference {
    @Test
    public void test1() throws InterruptedException {
        SoftReference<byte[]> softReference = new SoftReference(new byte[1024*1024*10]);
        System.out.println(softReference.get());
        System.gc();
        Thread.sleep(500);
        System.out.println(softReference.get());
        byte[] bytes = new byte[1024 * 1024 * 10];
        //-Xmx20m
        System.out.println(softReference.get());
    }


    public void printUser(SoftReference<User> ref){
        User user = ref.get();
        if(user==null){
            System.out.println("userRef为空对象");
        }else {
            System.out.println(user.toString());
        }
    }


    @Test
    public void test2() throws InterruptedException {
        User user = new User("wangzhen",18);
       // Thread.sleep(100000);
        SoftReference<User> userRef = new SoftReference<>(user);
        // 弱引用可以直接获取
        printUser(userRef);
        user = null;
        printUser(userRef);
        // 调用gc 后如果内存还是足够的话 那么还是可以拿到引用对象
        System.gc();
        printUser(userRef);
        // 新建一个10m 的对象 注意虚拟机启动参数要加上 -Xmx100m
        byte [] bytes =new byte[60*1024*1024];
        // 由于这时候虚拟机参数总共为100m 新建了 60m对象 加上 user中的40m 对象 还有虚拟机中其他信息肯定也要消耗内存
        // 所以这时候 对象肯定会被弱引用回收掉。
        printUser(userRef);

    }

    public static class User{
        byte [] data = new byte[40*1024*1024];
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "data=" + data.toString() +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
