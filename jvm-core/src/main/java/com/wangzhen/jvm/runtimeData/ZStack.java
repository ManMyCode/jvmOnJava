package com.wangzhen.jvm.runtimeData;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ZStack {
    // 虚拟机栈中包含的最大的栈帧的容量
    int maxSize;

    // 使用ArrayList 存放栈帧比较简单
    private List<ZFrame> zFrames = new ArrayList<ZFrame>();

    public ZStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public static void main(String[] args) {
        List list = new ArrayList(10);
        System.out.println(list.size());
    }
    public void push(ZFrame zFrame){

        if(zFrames.size()>maxSize){
            throw new StackOverflowError("栈溢出异常");
        }
        zFrames.add(zFrame);

    }
    public ZFrame pop(){
        if(zFrames.size()==0){
            throw new EmptyStackException();
        }
        ZFrame popjFrame = zFrames.remove(zFrames.size());
        return popjFrame;
    }
    public ZFrame top(){
        if(zFrames.size()==0){
            throw new EmptyStackException();
        }
        return zFrames.get(zFrames.size());
    }


}
