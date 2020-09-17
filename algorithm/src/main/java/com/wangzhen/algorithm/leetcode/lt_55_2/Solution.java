package com.wangzhen.algorithm.leetcode.lt_55_2;

/**
 * Description:  输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * Datetime:    2020/9/13   3:00 下午
 * Author:   王震
 */
class Solution {
    boolean isBala = true;
    public boolean isBalanced(TreeNode root) {
        list(root);
        return isBala;
    }
    public void list(TreeNode root){
        if(root==null){
            return;
        }
        list(root.left);
        if(!isBalance(root)){
            isBala = false;
        }
        list(root.right);
    }
    public boolean isBalance(TreeNode node){

        if(Math.abs(maxDepth(node.left)-maxDepth(node.right))>1){
            return false;
        }
        return true;
    }


    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(root.left == null ? 0 : maxDepth(root.left),root.right == null ?0:maxDepth(root.right))+1;
    }

}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      public int height(){
          return Math.max(this.left==null ? 0 : left.height(),this.right==null ? 0 :right.height())+1;
      }
      TreeNode(int x) {
          val = x;
      }
}

