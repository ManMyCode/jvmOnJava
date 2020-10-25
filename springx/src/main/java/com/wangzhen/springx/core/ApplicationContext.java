package com.wangzhen.springx.core;

import com.wangzhen.springx.core.annotation.ComponentScan;
import com.wangzhen.springx.core.impl.DefaultClassScanner;
import com.wangzhen.springx.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 * Datetime:    2020/10/24   9:38 下午
 * Author:   王震
 */
public class ApplicationContext {

    // 存放所有扫描到的类
    public static Map<String,Class<?>> beanMap = new ConcurrentHashMap<>();
    // 存放我们需要的标注了注解的注解类
    public static Map<Class<?>,Object> beanFactory = new ConcurrentHashMap<>();
    ClassScanner scanner;
    public ApplicationContext(Class ...configClzs) {
        scanner = new DefaultClassScanner();
        refresh(configClzs);
    }


    public static void main(String[] args) {

    }

    public void getBean(String Name){

    }


    public void refresh(Class ...configClzs){
        // 扫描所有的类 beanMap中
        scanClass(configClzs);
    }

    public void scanClass(Class ...configClzs){
        for (Class clz : configClzs){
            // 这里以类的绝对名称作为key ，考虑到双亲委托机制，理论上不会产生冲突
            beanMap.put(clz.getName(),clz);
            // 如果该配置类上有这个注解的话，那么需要扫描该注解标示的包中的所有内容。
            if (clz.isAnnotationPresent(ComponentScan.class)) {
                ComponentScan annotation = (ComponentScan) clz.getAnnotation(ComponentScan.class);
                String[] basePackages = annotation.value();
                for (String basePackage : basePackages) {
                    List<Class<?>> beans = scanner.getClassListByPackage(basePackage);
                    for (int i = 0; i < beans.size(); i++) {
                        Class<?> bean = beans.get(i);
                        beanMap.put(bean.getName(),bean);
                    }
                }

            }
        }
    }
}
