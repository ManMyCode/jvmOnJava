package com.wangzhen.concurrent.test;

public class Singleton {
    private Singleton(){
    }
    private static volatile Singleton singleton=null;
    public static  Singleton getSingleton(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

}
