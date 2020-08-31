package com.wangzhen.concurrent.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;


// undafe 对象的获取
public class TestUnsafe {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        System.out.println(unsafe.toString());
        Person p = new Person();
        long ageOffset = unsafe.objectFieldOffset(Person.class.getDeclaredField("age"));
        long nameOffset = unsafe.objectFieldOffset(Person.class.getDeclaredField("name"));
        unsafe.compareAndSwapInt(p,ageOffset,0,26);
        unsafe.compareAndSwapObject(p,nameOffset,null,"王震");
        System.out.println(p.toString());


    }
}
class Person{
    volatile int age;
    volatile String name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
