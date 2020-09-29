package com.wangzhen.algorithm.leetcode.lt_912;


import java.util.Random;

/**
 * Description: 快速排序
 * Datetime:    2020/9/29   11:29 上午
 * Author:   王震
 */
class Solution {
    public static void main(String[] args) {
        //System.out.println(new Random().nextInt(4));
        int []array = {9,5,2,4,6,1,-1,6,0,33,43,22};
        Solution solution = new Solution();
        solution.sortArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public void quickSort(int []arr,int left,int right){
        if (left<right){
            int part = partition(arr,left,right);
            quickSort(arr,0,part-1);
            quickSort(arr,part+1,right);
        }
    }
    public int partition(int []arr,int left,int right){
        int temp= new Random().nextInt(right-left+1)+left;
        swap(arr,left,temp);
        int part = left;
        int index = left+1;
        for (int i = index;i<= right;i++){
            if(arr[i]<arr[part]){
                swap(arr,index,i);
                index++;
            }
        }
        swap(arr,part,index-1);
        return  index-1;
    }

//    public int partition(int []arr,int left,int right){
//        int part = left;
//        int index = part+1;
//        for (int i = index; i<= right;i++){
//            if(arr[i]<arr[part]){
//                swap(arr,i,index);
//                index++;
//            }
//        }
//        swap(arr,part,index-1);
//        return index -1;
//    }
    public void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
