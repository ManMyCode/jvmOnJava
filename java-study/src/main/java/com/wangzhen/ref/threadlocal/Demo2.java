package com.wangzhen.ref.threadlocal;

import org.junit.Test;

/**
 * Description: 使用ThreadLocal 可以解决多线程情况下的数据同步问题
 * Datetime:    2020/10/12   9:58 上午
 * Author:   王震
 */
public class Demo2 {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public String getData() {
      return  threadLocal.get();
    }

    public void setData(String data) {
        // 设置对应的值
        threadLocal.set(data);
    }

    @Test
    public void test01(){
        Demo2 demo = new Demo2();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                demo.setData(Thread.currentThread().getName()+"的数据");
                System.out.println(Thread.currentThread().getName()+"-->"+demo.getData());
                System.out.println("---------------------");
            }).start();
        }
    }

}
