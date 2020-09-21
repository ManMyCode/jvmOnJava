package com.wangzhen.algorithm.tree.BST;

/**
 * Description:  binary search tree 二叉查找树的实现
 * Datetime:    2020/9/20   4:09 下午
 * Author:   王震
 */
public class BST<key extends Comparable<key>,value> {
    public Node root;
    private class Node{
        // 键
        private key key;
        // 值
        private value value;
        // 左右节点
        private Node left,right;
        // 以该节点为根的节点的树中的节点总数
        private int N;

        public Node(key key, value value, Node left, Node right, int n) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            N = n;
        }
    }

    public int size(){
        return 0;
    }
    private int size(Node x){
        if(x==null)
            return 0;
        else
            return x.N;
    }
    public value get(key k){
        return null;
    }
    public void put(key k, value v){

    }

}
