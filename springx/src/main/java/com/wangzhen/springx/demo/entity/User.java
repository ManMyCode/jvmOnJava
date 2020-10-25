package com.wangzhen.springx.demo.entity;

/**
 * Description:
 * Datetime:    2020/10/25   4:55 下午
 * Author:   王震
 */
public class User {
    String name;
    String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
