package com.wangzhen.threadLocal;

import java.lang.ref.SoftReference;

// 软引用
// 只有当gc 时 java 虚拟机空间不足时 才会回收
public class TestSoftReference {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<byte[]> softReference = new SoftReference(new byte[1024*1024*10]);
        System.out.println(softReference.get());
        System.gc();
        Thread.sleep(500);
        System.out.println(softReference.get());
        byte[] bytes = new byte[1024 * 1024 * 10];
        //-Xmx20m
        System.out.println(softReference.get());
    }
}
