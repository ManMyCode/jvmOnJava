package com.wangzhen.ref.threadlocal;

import org.junit.Test;

/**
 * Description:
 * Datetime:    2020/10/12   9:58 上午
 * Author:   王震
 */
public class Demo {
    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Test
    public void test01(){
        Demo demo = new Demo();
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
