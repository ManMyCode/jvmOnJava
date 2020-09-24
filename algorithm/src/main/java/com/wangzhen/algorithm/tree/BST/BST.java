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

    public boolean insert(int data){
        return insert(root,data);
    }

    // 递归版插入
    public boolean insert(Node p,int data){
        Node newNode= new Node(data);
        if(root==null){
            root=newNode;
        }
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

    public Node find(int data){
        return find(root,data);
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
        if(p!=null){
            list.add(p.value);
            preOrder(p.left);
            preOrder(p.right);
        }

    }
    //中序遍历 非递归版本
    public void infixOrder(Node p){
        if(p!=null){
            infixOrder(p.left);
            list.add(p.value);
            infixOrder(p.right);
        }

    }

    //后序遍历 非递归版本
    public void postOrder(Node p){
        if(p!=null){
            postOrder(p.left);
            postOrder(p.right);
            list.add(p.value);
        }

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


    public static void main(String[] args) {
        BST bt = new BST();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        bt.delete(10);//删除没有子节点的节点
        bt.delete(30);//删除有一个子节点的节点
        bt.delete(80);//删除有两个子节点的节点
        System.out.println(bt.findMax().value);
        System.out.println(bt.findMin().value);
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));
    }


}
