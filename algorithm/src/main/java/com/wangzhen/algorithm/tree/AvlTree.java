package com.wangzhen.algorithm.tree;

/**
 * Description:  平衡二叉树
 * Datetime:    2020/9/13   2:50 下午
 * Author:   王震
 */
public class AvlTree {
    public static void main(String[] args) {

    }



    class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }

        public int leftHeight(){
            return left == null ? 0 : left.height();
        }

        public int rightHeight(){
            return right == null ? 0 :right.height();
        }

        // 返回 以当前节点为根节点的数的高度
        public int height(){
            return Math.max(this.left==null ? 0:this.left.height(),this.right==null?0 :this.right.height())+1;
        }

        public Node search(int value){
            if(this.data ==value){
                return this;
            }

            if(value>data){
                return right == null ? null: search(right.data);
            }else {
                return left == null ? null :search(left.data);
            }
        }
    }

}


