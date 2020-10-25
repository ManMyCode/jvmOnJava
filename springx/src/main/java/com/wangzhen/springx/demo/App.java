package com.wangzhen.springx.demo;


import com.wangzhen.springx.core.ApplicationContext;
import com.wangzhen.springx.demo.config.Config;


/**
 * Description:
 * Datetime:    2020/10/25   4:14 下午
 * Author:   王震
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext(Config.class);
        System.out.println(applicationContext.beanMap);
    }
}
