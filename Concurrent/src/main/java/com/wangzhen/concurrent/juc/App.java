package com.wangzhen.concurrent.juc;

public class App {
    int a;
    int b;
    public static void main(String[] args) {
        App app =new App();
        app.a =1;
        App app2 = app;
        System.out.println(app2.a);
    }
}
