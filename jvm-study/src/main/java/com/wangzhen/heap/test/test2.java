package com.wangzhen.heap.test;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

public class test2 {
    test2 test;
    public void  sayName(){
        System.out.println("name");
    }
    public static void main(String[] args) {
        //String
        test2 test = new test2();
        try{
            test.sayHello();
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
    public  void  sayHello()throws Exception{
       test.sayName();

    }
}
