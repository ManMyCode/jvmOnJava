package com.wangzhen.heap.test;

import java.util.ArrayList;
import java.util.Random;

public class HeapInstance {
    byte [] bytes=new byte[new Random().nextInt(1024*2000)];
    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapInstance> list=new ArrayList();
        while (true){
            HeapInstance instance = new HeapInstance();
            list.add(instance);
           // Thread.sleep(new Random().nextInt(1000));
        }
    }
}
