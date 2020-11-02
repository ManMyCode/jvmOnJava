package com.wangzhen.myspring.bean.app;

import com.wangzhen.myspring.bean.User;
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
        ApplicationContext applicationContext = new XmlApplicationContext("file:D:\\workspace\\java\\router-cloud\\MySpring\\src\\test\\resources\\spring.xml");
        User user  = (User) applicationContext.getBean("user");
        user.sayName();

    }
}