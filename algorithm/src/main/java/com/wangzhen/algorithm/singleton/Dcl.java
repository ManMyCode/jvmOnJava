package com.wangzhen.algorithm.singleton;

public class Dcl {
    private Dcl(){
    }
    private static volatile Dcl instance;
    public static Dcl getInstance(){
         if(instance == null){
             synchronized (Dcl.class){
                 if(instance==null){
                     instance = new Dcl();
                 }
             }
         }
         return instance;
    }
}
