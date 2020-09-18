package com.wangzhen.concurrent.collection.tree;


import java.util.ArrayList;
import java.util.List;

public class Tree {
    public Node root;
    List list ;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arrays = { 6,3,9,5,8,1,0,7,2,4};
        for (int i = 0; i < arrays.length; i++) {
            tree.put(arrays[i]);
        }
        System.out.println(tree.toString());
        tree.setList(new ArrayList());
        tree.preOrder(tree.root);
        System.out.println("前序遍历"+tree.list);
        tree.setList(new ArrayList());
        tree.midOrder(tree.root);
        System.out.println("中序遍历"+tree.list);
        tree.setList(new ArrayList());
        tree.afterOrder(tree.root);
        System.out.println("后序遍历"+tree.list);

    }

    public void put (int value){
        Node newNode = new Node(value);
        Node p = root;
        if(root == null){
            root=newNode;
        }else {
          root.put(newNode);
        }
    }

    // 前序遍历
    public void preOrder(Node node){
        list.add(node.data);
        if(node.left!=null){
            preOrder(node.left);
        }
        if(node.right!=null){
            preOrder(node.right);
        }

    }
    //中序遍历
    public void midOrder(Node node){

        if(node.left!=null){
            midOrder(node.left);
        }
        list.add(node.data);
        if(node.right!=null){
            midOrder(node.right);
        }

    }
    // 后续遍历
    public void afterOrder(Node node){

        if(node.left!=null){
            afterOrder(node.left);
        }

        if(node.right!=null){
            afterOrder(node.right);
        }

        list.add(node.data);
    }
    class Node{
        int data;
        Node left;
        Node right;
        //Node parent;

        public Node(int data) {
            this.data = data;
        }
        public void put(Node newNode){
            if(data>newNode.data){
                if(left==null){
                    left = newNode;
                }else {
                    left.put(newNode);
                }
            }else {
                if(right==null){
                    right = newNode;
                }else {
                    right.put(newNode);
                }
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
