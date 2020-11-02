package com.wangzhen.myspring.context.app.impl;

import java.util.Map;

/**
 * Description:
 * Datetime:    2020/11/2   16:29
 * Author:   王震
 */
public class AnnotationConfigApplicationContext extends AbstractApplicationContext {


//    public AnnotationConfigApplicationContext(Class<?>... ) {
//    }

    @Override
    public String[] getBeanNameForType(Class<?> tClass) {
        return new String[0];
    }

    @Override
    public Map<String, Object> getBeansForType(Class<?> clazz) {
        return null;
    }

    @Override
    public Class getType(String beanName) {
        return null;
    }
}