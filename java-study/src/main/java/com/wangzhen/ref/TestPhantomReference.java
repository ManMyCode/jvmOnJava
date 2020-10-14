package com.wangzhen.ref;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

// 虚引用
// 用的很少，直接回答 用来管理直接内存的就可以了
public class TestPhantomReference {
    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    // 需要设置虚拟机参数 -Xmx100m
    @Test
    public void test01() throws InterruptedException {
        /*
            1.虚引用 的构造方法需要传入引用对象和引用队列
            2.无法通过虚引用获取到目标引用对象
            3.虚引用的引用对象被垃圾回收的时候会将这个弱引用放入到 队列中

         */
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);
        Thread t1 = new Thread(() -> {
            while (true) {
                // -Xmx10m

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(phantomReference.get());
                LIST.add(new byte[10*1024 * 1024]);
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("虚引用被回收掉了" + poll);
                }

            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

    public static class M{

    }
}
