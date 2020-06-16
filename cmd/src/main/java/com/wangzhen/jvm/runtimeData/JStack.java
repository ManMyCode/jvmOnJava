package com.wangzhen.jvm.runtimeData;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class JStack {
    // 虚拟机栈中包含的最大的栈帧的容量
    int maxSize;

    // 使用ArrayList 存放栈帧比较简单
    private List<JFrame> jFrames = new ArrayList<JFrame>();

    public JStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public static void main(String[] args) {
        List list = new ArrayList(10);
        System.out.println(list.size());
    }
    public void push(JFrame jFrame){

        if(jFrames.size()>maxSize){
            throw new StackOverflowError("栈溢出异常");
        }
        jFrames.add(jFrame);

    }
    public JFrame pop(){
        if(jFrames.size()==0){
            throw new EmptyStackException();
        }
        JFrame popjFrame = jFrames.remove(jFrames.size());
        return popjFrame;
    }
    public JFrame top(){
        if(jFrames.size()==0){
            throw new EmptyStackException();
        }
        return jFrames.get(jFrames.size());
    }


}
