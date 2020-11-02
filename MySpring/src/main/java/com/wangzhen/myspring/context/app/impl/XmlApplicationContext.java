package com.wangzhen.myspring.context.app.impl;

import com.wangzhen.myspring.bean.postprocessor.AopPostProcessor;
import com.wangzhen.myspring.context.app.ApplicationContext;

import java.util.Map;

/**
 * Description:
 * Datetime:    2020/11/2   11:06
 * Author:   王震
 */
public class XmlApplicationContext implements ApplicationContext {
    @Override
    public Object getBean(String beanName) throws Exception {
        return null;
    }

    @Override
    public void registerBeanPostProcessor(AopPostProcessor processor) {

    }

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