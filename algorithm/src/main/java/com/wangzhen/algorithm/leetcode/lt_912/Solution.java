package com.wangzhen.algorithm.leetcode.lt_912;

/**
 * Description: 快速排序
 * Datetime:    2020/9/29   11:29 上午
 * Author:   王震
 */
class Solution {
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
        int part = left;
        int index = part+1;
        for (int i = index; i<= right;i++){
            if(arr[i]<arr[part]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,part,index-1);
        return index -1;
    }
    public void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
