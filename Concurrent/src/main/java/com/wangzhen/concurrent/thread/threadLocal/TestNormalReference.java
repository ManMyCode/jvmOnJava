package com.wangzhen.concurrent.thread.threadLocal;

import java.io.IOException;

/**
 *  强软弱虚终  五种常用引用
 * 强引用：正常 new 出来的引用都是强 引用
 */
public class TestNormalReference {
    public static void main(String[] args) throws IOException {
        M m =new M();
        m = null;
        System.gc();
      //  System.out.println(m);
        //System.in.read();
    }
}
