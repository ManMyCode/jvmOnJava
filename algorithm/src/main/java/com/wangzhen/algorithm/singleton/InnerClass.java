package com.wangzhen.algorithm.singleton;

public class InnerClass {
    private  InnerClass(){

    }
    private static class InstanceHolder {
        public static InnerClass innerClass = new InnerClass();
    }
    public static InnerClass getInstance(){
        return InstanceHolder.innerClass;
    }
}
