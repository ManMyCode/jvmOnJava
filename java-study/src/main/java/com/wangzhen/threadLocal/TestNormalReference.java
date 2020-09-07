package com.wangzhen.threadLocal;

import java.io.IOException;

// 强引用
public class TestNormalReference {
    public static void main(String[] args) throws IOException {
        M m =new M();
        m = null;
        System.gc();
      //  System.out.println(m);
        //System.in.read();
    }
}
