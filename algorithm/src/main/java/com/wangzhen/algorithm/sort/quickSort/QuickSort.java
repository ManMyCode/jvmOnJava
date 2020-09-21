package com.wangzhen.algorithm.sort.quickSort;

import com.wangzhen.algorithm.sort.SortBaic;

public class QuickSort extends SortBaic {

    @Override
    public Comparable[] sort(Comparable[] a) {

        return a;
    }
    public void sort(Comparable[] a,int left,int right){
        int part = partition(a,left,right);
    }
    // 获取基准值
    public int partition(Comparable []a ,int left,int right){
        return 0;
    }
}
