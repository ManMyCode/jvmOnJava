package com.wangzhen.jvm;


import com.sun.corba.se.spi.ior.ObjectKey;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wangzhen.jvm.runtimeData.helap.StringPool;
import com.wangzhen.jvm.test.IApp;
import com.wangzhen.jvm.test.Person;
import com.wangzhen.jvm.test.Son;

import java.util.ArrayList;
import java.util.List;


public class App  {
//    public static final boolean FLAG = true;
//    public static final byte BYTE = 123;
//    public static final char X = 'X';
//    public static final short SHORT = 12345;
//    public static final int INT = 123456789;
//    public static final long LONG = 12345678901L;
//    public static final float PI = 3.14f;
//    public static final double E = 2.71828;
//    public static int i =1;
     public int j = 1;
      public static byte i=-1;

    public static void main(String[] args) throws RuntimeException {
//        String a="wang";
//        String b="zhen";
//        String c="wang"+"zhen";
//        String d="wangzhen";
//        boolean flag = c.intern() ==d;
//        StringBuilder s=new StringBuilder();
//        boolean flag = true;
//        boolean flag2 = false;
//        System.out.println(flag);
       // String name =new String("wangzhen");
        // List<App> appList=new ArrayList<>();
        Class class1 = App.class;
        Class class2 = new App().getClass();
        Class class3 = new App().getClass();



    }
    public void fn(int n){
        synchronized (this){
            n++;
        }
    }





//    @Override
//    public void say(String name) {
//        System.out.println(name);
//    }
}
