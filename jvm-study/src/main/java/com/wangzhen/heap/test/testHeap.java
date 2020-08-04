package com.wangzhen.heap.test;

public class testHeap {
    public testHeap(int id) {
        this.id = id;
    }

    public  int id;
    public void sayId(){
        System.out.println(id);
    }
    public static void main(String[] args) throws InterruptedException {
       testHeap t1= new testHeap(1);
       testHeap t2=new testHeap(2);
       Thread.sleep(10*6000);
    }
}
