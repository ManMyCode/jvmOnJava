package com.wangzhen.jvm;


import javafx.beans.binding.StringBinding;


public class App  {
    static final int A =10;
    static final int B =Short.MAX_VALUE+1;

     final int a =10;
     final int b =Short.MAX_VALUE+1;


}

class TestFinal{
    public static void main(String[] args) {
        System.out.println(App.A);
        System.out.println(App.B);
        System.out.println(new App().a);
        System.out.println(new App().b);
    }
}