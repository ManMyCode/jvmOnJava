package com.wangzhen.concurrent.thread.threadLocal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;



/**
 * 虚引用： 只要垃圾回收 不管jvm 空间够够不够 都会 回收虚引用
 * 用的很少，直接回答 用来管理直接内存的就可以了.
 * 比如 netty 里面使用 直接内存 来做 io 操作可以减少复制，加快复制速度
 */
public class TestPhantomReference {
    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);
        new Thread(()->{
            while (true){
                // -Xmx10m
                LIST.add(new byte[1024*1024]);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(phantomReference.get());
            }
        }).start();
        new Thread(()->{
            while (true){
                Reference<? extends M> poll = QUEUE.poll();
                if(poll!=null){
                    System.out.println("虚引用被回收掉了"+poll);
                }

            }
        }).start();

    }
}
