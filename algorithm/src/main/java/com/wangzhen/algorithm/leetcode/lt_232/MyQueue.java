package com.wangzhen.algorithm.leetcode.lt_232;

import java.util.Stack;

/**
 * Description: 232. 用栈实现队列
 * ans : 用双栈实现 队列
 * Datetime:    2020/9/28   10:01 下午
 * Author:   王震
 */
class MyQueue {

    Stack stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return false;
    }
}
