package com.wangzhen.concurrent.collection.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    List<Person> list =new ArrayList<>();
    public void add(){
        Person a = new Person(17,"a");
        Person b = new Person(18,"b");
        Person c = new Person(19,"c");
        list.add(a);
        list.add(b);
        list.add(c);
    }

    @Test
    public void test1(){
        add();
        Collections.sort(list);

        System.out.println(list);
    }
    @Test
    public void test2(){
        add();
        Comparator<Person> cpt = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.age - o1.age;
            }
        };
        Collections.sort(list,cpt);
        System.out.println(list);

    }

}
