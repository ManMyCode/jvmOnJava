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
    ListNode head;
    ListNode tail;

    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

    }



    class ListNode{
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int value, ListNode prev, ListNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

}

