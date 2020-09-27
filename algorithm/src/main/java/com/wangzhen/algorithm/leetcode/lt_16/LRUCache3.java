package com.wangzhen.algorithm.leetcode.lt_16;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Description:  设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。
 * Datetime:    2020/9/27   2:07 下午
 * Author:   王震
 */
class LRUCache3 {
    LinkedHashMap<Integer,Integer> map;
    int capacity;


    public LRUCache3(int capacity) {
        this.map = new LinkedHashMap();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        }else{
            // 如果map 已经满了的话需要找到并且删除这个key
            if(capacity==map.size()){
                map.remove(map.entrySet().iterator().next().getKey());
                map.put(key,value);
            }else {
                map.put(key,value);
            }
        }

    }
}

