package com.wangzhen.concurrent.threadLocal;

import java.lang.ref.WeakReference;

// 弱引用
// 只要gc 就会回收的引用
public class TestWeakReference {
    public static void main(String[] args) {
        WeakReference<M> weakReference = new WeakReference<>(new M());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }
}
