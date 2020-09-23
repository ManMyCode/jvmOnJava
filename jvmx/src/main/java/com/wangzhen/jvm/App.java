package com.wangzhen.jvm;





public class App  {
    public static void main(String[] args) {
        App app = new App();
        int []array = {3,8};
        app.swap(array,0,1);
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

