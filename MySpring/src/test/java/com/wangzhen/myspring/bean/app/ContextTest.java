package com.wangzhen.myspring.bean.app;

import com.wangzhen.myspring.context.app.ApplicationContext;
import com.wangzhen.myspring.context.app.impl.XmlApplicationContext;
import org.junit.Test;

/**
 * Description:
 * Datetime:    2020/11/2   14:51
 * Author:   王震
 */
public class ContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new XmlApplicationContext("classpath:spring.xml");
        applicationContext.getBean("user");
    }
}