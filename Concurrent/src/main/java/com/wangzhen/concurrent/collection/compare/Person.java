package com.wangzhen.concurrent.collection.compare;

public class Person implements Comparable<Person>{
    int age;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public int compareTo(Person o) {
        // 按照年龄排序
        //return this.age - o.age;
        return o.age-this.age;
    }
}
