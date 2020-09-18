package com.wangzhen.concurrent.collection.list;

import java.util.*;

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>,Cloneable,java.io.Serializable {

    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    public LinkedList(){

    }
    public LinkedList(Collection<? extends E> collection){
        this();
        addAll(collection);
    }

    private void linkFist(E e){
        Node f = first;
        Node newNode = new Node(null,e,first);
        first = newNode;
        if(f==null){
            last = newNode;
        }else{
            f.prev = newNode;
        }
        size++;
        modCount++;
    }

    void linkLast(E e){
        Node l = last;
        Node newNode = new Node(l,e,null);
        last = newNode;
        if(l == null){
            first = newNode;
        }else {
            l.next=newNode;
        }
        size++;
        modCount++;
    }

    void linkBefore(E e,Node<E> succ){
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node(pred,e,succ);
        succ.prev = newNode;
        if(pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;

    }

    private E unlinkFirst(Node<E> f){
        final E element = f.item;
        final  Node<E> next = f.next;
        f.item = null;
        f.next = null;// help.gc
        first = next;
        if(next==null){
            last = null;
        }else {
            next.prev=null;
        }
        size --;
        modCount++;
        return element;
    }

    // 移除最后一个节点，需要考虑移除的节点是第一个节点的情况
    private E unlinkLast(Node<E> l){
        final E element = l.item;
        Node pred = l.prev;
        // 设置最后的节点 为l 的上一个节点
        l.item= null;
        l.prev=null; // help gc
        last = pred;
        // 说明当前列表只有一个节点了，移除的就是头节点
        if(pred ==null){
            first = null;
        }else {
            pred.next = null;
        }
        return element;
    }

    E unlink(Node<E> x){
        E element = x.item;

        return element;
    }

    // 遍历 列表 查找对应的位置
    public int indexOf(Object o){
        int index = 0;
        if(o==null){
            for (Node n = first;n.next !=null;n = n.next){
                index++;
                if(n.item==null){
                    return index;
                }
            }
        }else {
            for (Node n = first;n.next !=null;n = n.next){
                index++;
                if(o.equals(n.item)){
                    return  index;
                }
            }
        }
        return -1;
    }


    private static class Node<E>{
        E item;
        Node<E> prev;
        Node<E> next;
        Node(Node<E> prev,E element,Node<E> next){
            this.prev = prev;
            this.item =element;
            this.next=next;
        }
    }






    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public void addFirst(E e) {

    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }
}
