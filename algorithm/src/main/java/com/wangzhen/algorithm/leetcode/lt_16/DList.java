package com.wangzhen.algorithm.leetcode.lt_16;

/**
 * Description:
 * Datetime:    2020/9/27   3:57 下午
 * Author:   王震
 */
public class DList<K,V> {
    int size;
    Node head;
    Node tail;
    public void put(K key,V value){
        Node newNode = new Node(key,value);
        Node t = tail;
        newNode.prev = t;
        newNode.next = null;
        t.next= newNode;
        head = newNode;
        size++;
    }


    class Node<K,V>{
        K key;
        V value;
        Node prev;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
