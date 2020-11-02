package com.wangzhen.myspring.context.app.impl;

import com.wangzhen.myspring.bean.factory.BeanFactory;
import com.wangzhen.myspring.bean.factory.impl.DefaultBeanFactory;
import com.wangzhen.myspring.bean.postprocessor.AopPostProcessor;
import com.wangzhen.myspring.context.app.ApplicationContext;
import com.wangzhen.myspring.context.resource.Resource;
import com.wangzhen.myspring.context.resource.ResourceFactory;

/**
 * Description:
 * Datetime:    2020/11/2   11:07
 * Author:   王震
 */
public abstract class AbstractApplicationContext  implements ApplicationContext , ResourceFactory {

    protected BeanFactory beanFactory;

    public AbstractApplicationContext() {
        this.beanFactory = new DefaultBeanFactory();
    }


    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanPostProcessor(AopPostProcessor processor) {
        this.beanFactory.registerBeanPostProcessor(processor);
    }

    /**
     * 根据前缀返回不同的解析对象
     * @param localtions
     * @return
     * @throws Exception
     */
    @Override
    public Resource getResource(String localtions) throws Exception {
        return null;
    }
}