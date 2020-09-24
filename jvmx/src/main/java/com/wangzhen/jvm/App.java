package com.wangzhen.jvm;





public class App  {
    public static void main(String[] args) {
        int i = 0;
        int [] arr = {1,2};
        set(i);
        setArr(arr);
        System.out.println(i);
        System.out.println(arr[0]);
    }

    public static void  set (int i){
        i = 8;
    }
    public static void  setArr(int []arr){
        arr[0] = 100;
    }

    public void swap(int []arr,int i,int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void test(){
        System.out.println("test 方法被调用了");
    }
}

