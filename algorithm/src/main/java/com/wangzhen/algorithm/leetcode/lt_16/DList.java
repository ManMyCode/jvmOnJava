package com.wangzhen.algorithm.leetcode.lt_16;

/**
 * Description: 自定义双向列表
 * Datetime:    2020/9/27   3:57 下午
 * Author:   王震
 */
public class DList<K,V> {
    int size;
    Node head;
    Node tail;
    // 尾插法，新的节点放在尾部
    public void put(K key,V value){

        Node newNode = new Node(key,value);
        if(tail==null){
            head = tail = newNode;
        }
        Node t = tail;
        newNode.prev = t;
        newNode.next = null;
        t.next= newNode;
        head = newNode;
        size++;
    }



    public V get(K key){
        Node<K,V> x = new Node(key,null);
        return findNode(x).value;
    }

    public Node<K,V> findNode(Node node){
        Node<K,V> x = head;
        while (x!=null){
            if(x.key==node.key){
                return x;
            }
            x = x.next;
        }
        return null;
    }

    public void del(K key){
        Node x = new Node(key,null);
        del(x);
    }
    // 删除一个 node 节点
    public void del(Node node){
        Node x = findNode(node);
        Node prevNode = x.prev;
        Node nextNode = x.next;
        if(prevNode!=null){
            prevNode.next=nextNode;
        }
        if(nextNode!=null){
            nextNode.prev = prevNode;
        }
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
