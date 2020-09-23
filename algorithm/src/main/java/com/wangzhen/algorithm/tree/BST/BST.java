package com.wangzhen.algorithm.tree.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:  binary search tree 二叉查找树/二叉搜索树 的实现
 * Datetime:    2020/9/20   4:09 下午
 * Author:   王震
 */
public class BST {
    public Node root;
    List<Integer> list = new ArrayList<>();
    private class Node{
        private int value;
        Node left;
        Node right;
        boolean isDelete;

        public Node(int value) {
            this.value = value;
        }
    }
    // 递归版插入
    public boolean insert(Node p,int data){
        Node newNode= new Node(data);
        if(p==null){
            return false;
        }
        if(data>p.value){
            if(p.right!=null){
                insert(p.right,data);
            }
            p.right=newNode;
        }else {
            if(p.left!=null){
                insert(p.left,data);
            }
            p.left=newNode;
        }
        return true;
    }

    // 递归版本查找
    public Node find(Node p,int data){
        if(p==null)
            return null;
        if(data==p.value){
            return p;
        }if(data>p.value){
            return find(p.right,data);
        }else{
            return find(p.left,data);
        }
    }

    //前序遍历 非递归版本
    public void preOrder(Node p){
        list.add(p.value);
        preOrder(p.left);
        preOrder(p.right);
    }
    //中序遍历 非递归版本
    public void infixOrder(Node p){
        infixOrder(p.left);
        list.add(p.value);
        infixOrder(p.right);
    }

    //后序遍历 非递归版本
    public void postOrder(Node p){
        postOrder(p.left);
        postOrder(p.right);
        list.add(p.value);
    }


    //查找最大值
    public Node findMax(){
        Node p = root;
        while (p.left!=null){
            p=p.left;
        }
        return p;
    }
    //查找最小值
    public Node findMin(){
        Node p = root;
        while (p.right!=null){
            p=p.right;
        }
        return p;
    };

    public boolean delete(int value){
        return false;
    }




}
