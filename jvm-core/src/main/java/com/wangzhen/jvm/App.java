package com.wangzhen.jvm;


import com.wangzhen.jvm.test.IApp;
import com.wangzhen.jvm.test.Person;
import com.wangzhen.jvm.test.Son;

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
//    public int j = 2;
      public int n;



    public static void main(String[] args) throws RuntimeException {
//         int a= 1;
//         int b =2;
//         int c = a+b;
       // System.out.println(c);
        Person person = new Son();
        person.sayName();

    }

//    @Override
//    public void say(String name) {
//        System.out.println(name);
//    }
}
