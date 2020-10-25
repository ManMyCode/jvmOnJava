package com.wangzhen.springx.ioc;

import com.wangzhen.springx.core.ApplicationContext;
import com.wangzhen.springx.ioc.annotation.Autowired;
import com.wangzhen.springx.ioc.annotation.Component;
import com.wangzhen.springx.util.ArrayUtil;
import com.wangzhen.springx.util.CollectionUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * Datetime:    2020/10/25   4:45 下午
 * Author:   王震
 */
public class IocHelper {
    public static void inject(){
        Map<String, Class<?>> scanBeanMap = ApplicationContext.scanBeanMap;
        Map<Class<?>, Object> beanFactory = ApplicationContext.beanFactory;
        Set<String> strings = scanBeanMap.keySet();
        for (String string : strings) {
            Class<?> clz = scanBeanMap.get(string);
            // @Service 和 @Contoller 等注解 其实作用和 Component 的注解作用类似，这里只实现
            // 最常用的 @Component
            if(clz.isAnnotationPresent(Component.class)){
                try {
                    Object isntance = clz.newInstance();
                    // 将bean 对象实例化 存入到 beanFactory 中
                    beanFactory.put(clz,isntance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // 得到所有类上带了注解的对象，表明其需要被spring 容器所管理
        for (Map.Entry<Class<?>, Object> classObjectEntry : beanFactory.entrySet()) {
            Class<?> clz = classObjectEntry.getKey();
            Object obj = classObjectEntry.getValue();
            // 得到该类的所有属性
            Field[] fields = clz.getDeclaredFields();
            if (ArrayUtil.isNotEmpty(fields)) {
                for (Field field : fields) {
                    // 该类上是否有 Autowired 注解
                    if (field.isAnnotationPresent(Autowired.class)) {
                        // 获得该对象对应的类（在spring中 一般是接口，因为是面向接口编程）
                        Class<?> interfaceClz = field.getType();
                        // 查找实现该接口的所有子类
                        List<Class<?>> implList = searchImpl(interfaceClz);
                        // 如果存在实现的接口类
                        if(CollectionUtil.isNotEmpty(implList)){
                             Class<?>  implClz = implList.get(0);
                             Object implObj = beanFactory.get(implClz);
                             if(implObj!=null){
                                 field.setAccessible(true); // 将字段设置为 public 字段
                                 try {
                                     field.set(obj,implObj);
                                 } catch (IllegalAccessException e) {
                                     e.printStackTrace();
                                 }
                             }else{
                                 throw new Error("依赖注入失败！类名：" + clz.getSimpleName() + "，字段名：" + implClz.getSimpleName());

                             }
                        }
                    }
                }
            }

        }


    }

    public static List<Class<?>> searchImpl(Class<?> interfaceClz){
        Class<?> impl = interfaceClz;
        List<Class<?>> result = new ArrayList<>();
        Map<String, Class<?>> scanBeanMap = ApplicationContext.scanBeanMap;
        for (Map.Entry<String, Class<?>> stringClassEntry : scanBeanMap.entrySet()) {
            Class sonClass = stringClassEntry.getValue();
            // 是他的子类且不是同一个类，否则会把当前接口也加入其中。
            if(interfaceClz.isAssignableFrom(sonClass)&&(!interfaceClz.equals(sonClass))){
                result.add(sonClass);
            }
        }
        return result;

    }
}
