package com.wangzhen.algorithm.leetcode.lt_16;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Description:  设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。
 * Datetime:    2020/9/27   2:07 下午
 * Author:   王震
 */
public class LRUCache {

    HashMap<Integer,Integer> map;
    DList<Integer,Integer> cache;

    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        cache = new DList();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
            cache.del(key);
            cache.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            cache.del(key);
            cache.put(key,value);
        }else{
            // 如果集合已经满了
            if(map.size()==capacity){
                // 移除第一个key
                map.remove(map.keySet().iterator().next());
                cache.del(key);
                cache.put(key,value);
            }else{
                map.put(key,value);
                cache.del(key);
                cache.put(key,value);
            }
        }
    }


}

