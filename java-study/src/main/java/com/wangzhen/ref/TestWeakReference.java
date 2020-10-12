package com.wangzhen.ref;

import org.junit.Test;

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



    // 对于对象在弱引用中 ，gc 会直接回收掉
    @Test
    public void test01(){
        WeakReference<byte[]> ref = new WeakReference(new byte[10]);
        System.out.println(ref.get());
        System.gc();
        System.out.println(ref.get());
    }

    // 字符串在弱 引用中，gc 后不会回收掉
    // 这个可能与 字符串的 StringTable 有关，这个还有待研究
    @Test
    public void test02(){
        WeakReference<String> ref = new WeakReference("wangzhen");
        System.out.println(ref.get());
        System.gc();
        System.out.println(ref.get());
    }
}
