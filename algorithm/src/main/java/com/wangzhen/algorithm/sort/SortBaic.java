package com.wangzhen.algorithm.sort;

public abstract class SortBaic {
    public abstract  void sort(Comparable[] a);

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    public static void show(Comparable []a){
        for (int i=0;i<=a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static boolean isSorted(Comparable []a){
        for (int i=1;i<a.length;i++){
            if(less(a[i],a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(less(1, 2));
    }
}
