package com.wangzhen.algorithm.设计模式.代理模式.cglib.beanCopy;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;
import org.junit.Test;
import sun.misc.Unsafe;

/**
 * Description:
 * Datetime:    2020/10/31   5:43 下午
 * Author:   王震
 */
public class App {


    // 对象的copy 复制，cglib 号称是现在最快的
    @Test
    public void test01(){
        Student stu = new Student("wangzhen", 18, "137000000000");
        User user = new User();
        BeanCopier beanCopier = BeanCopier.create(Student.class, User.class, false);
        beanCopier.copy(stu,user,null);
        System.out.println(user.toString());
    }

    @Test
    public void test02(){
        Student stu = new Student("wangzhen", 18, "137000000000");
        Person person = new Person();
        BeanCopier beanCopier = BeanCopier.create(Student.class, Person.class, true);
        beanCopier.copy(stu,person, new Converter() {
            @Override
            public Object convert(Object o, Class aClass, Object o1) {
                //if(o1.toString().equals("setName"));
                System.out.println(o);
                System.out.println(aClass);
                System.out.println(o1);
                return null;
            }
        });
    }
}
