package com.wangzhen.jvm.runtimeData.helap;

import com.wangzhen.jvm.classPackage.ClassFile;
import com.wangzhen.jvm.classPath.ClassPath;

import java.util.HashMap;

public class ZClassLoader {
      ClassPath classPath;
      HashMap<String,ZClass> map;


    //先查找classMap，看类是否已经被加载。如果是，直接返回类数据，否则调用loadNonArrayClass（）方法加载类。
    //在类方法中的一个递归调用,也是classLoader中的入口方法
    public ZClass loadClass(String name) {
        if(map.containsKey(name)){
            return map.get(name);
        }
        ZClass zClass;
        if(name.charAt(0)=='['){
            loadArrayClass(name);
        }else{
            loadNonArrayClass(name);
        }

        return null;
    }

    public ZClass loadArrayClass(String name){
        return null;
    }
    private ZClass loadNonArrayClass(String name){
        byte []data = readClass(name);
        //ZClass clazz = defineClass(data);
        ZClass zClass ;
        return null;
    }

    public ZClass defineClass(byte []data){

        return null;
    }

    // 将class文件解析成 运行时class
    private ZClass parseClass(byte[] data) {
        ClassFile cf = new ClassFile(data);
        return new ZClass(cf);
    }

    private void loadBasicClasses(){

    }




    /**
     * 利用 ClassPath 把 class 文件读进来
     *
     * @param name 类名，eg：java.lang.String 或者包含 main 方法的主类名
     * @return class 字节数据
     */
    private byte[] readClass(String name) {
        byte[] data = classPath.readClass(name);
        if (data != null) {
            return data;
        } else {
            throw new ClassCastException("class name: " + name);
        }
    }

}
