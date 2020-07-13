package com.wangzhen.jvm.runtimeData.helap;

import com.wangzhen.jvm.classfile.classPackage.ClassFile;
import com.wangzhen.jvm.classfile.classPath.ClassPath;
import com.wangzhen.jvm.runtimeData.Slots;

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
            zClass = loadArrayClass(name);
        }else{
            zClass = loadNonArrayClass(name);
        }
        // 为每一个class 都关联一个元类
        ZClass jlcClass = map.get("java/lang/Class");
        if(jlcClass!=null){
            zClass.jObject = jlcClass.newObject();
            zClass.jObject.extra = zClass;
        }
        return zClass;
    }

    public ZClass loadArrayClass(String name){
        return null;
    }

    private ZClass loadNonArrayClass(String name){
        byte []data = readClass(name);
        ZClass clazz = defineClass(data);
        link(clazz); ;
        return clazz;
    }



    /*
     * 首先把class文件数据转换成 ClassFile 对象，在转为 Zclass 对象；
     * 加载父类
     * 加载接口
     * resolveSuperClass：是一个递归的过程，不断的加载父类信息
     * */
    public ZClass defineClass(byte []data){
        ZClass zClass = this.parseClass(data);
        zClass.loader =  this;
        resolveSuperClass(zClass);
        resolveInterfaces(zClass);
        map.put(zClass.thisClassName,zClass);
        return zClass;
    }

    /*
    class 链接阶段分为3个：
        1.验证
        2.准备
        3.解析
     */
    public void link(ZClass zClass){
        // 验证为空
        verify(zClass);
        prepare(zClass);
    }

    //在执行类的任何代码之前要对类进行严格的检验,这里忽略检验过程,作为空实现;
    private void verify(ZClass clazz) {
    }

    //给类变量分配空间并赋予初始值
    private void prepare(ZClass clazz) {
        calcInstanceFieldSlotIds(clazz);
        calcStaticFieldSlotIds(clazz);
        allocAndInitStaticVars(clazz);
    }

    // 计算new一个对象所需的空间,单位是clazz.instanceSlotCount,主要包含了类的非静态成员变量(包含父类的)
    // 但是这里并没有真正的申请空间，只是计算大小，同时为每个非静态变量关联 slotId
    private void calcInstanceFieldSlotIds(ZClass clazz) {
        int slotId = 0;
        if (clazz.superClass != null) {
            slotId = clazz.superClass.instanceSlotCount;
        }

        for (ZField field : clazz.fileds) {
            if (!field.isStatic()) {
                field.slotId = slotId;
                slotId++;
                if (field.isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        clazz.instanceSlotCount = slotId;
    }

    //计算类的静态成员变量所需的空间，不包含父类，同样也只是计算和分配 slotId，不申请空间
    private void calcStaticFieldSlotIds(ZClass clazz) {
        int slotId = 0;
        for (ZField field : clazz.fileds) {
            if (field.isStatic()) {
                field.slotId = slotId;
                slotId++;
                if (field.isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        clazz.staticSlotCount = slotId;
    }

    // 为静态变量申请空间,注意:这个申请空间的过程,就是将所有的静态变量赋值为0或者null;
    // 如果是 static final 的基本类型或者 String，其值会保存在ConstantValueAttribute属性中
    private void allocAndInitStaticVars(ZClass clazz) {
        clazz.staticVars = new Slots(clazz.staticSlotCount);
        for (ZField field : clazz.fileds) {
            if (field.isStatic() && field.isFinal()) {
                initStaticFinalVar(clazz, field);
            }
        }
    }

    // 将class文件解析成 运行时class
    private ZClass parseClass(byte[] data) {
        ClassFile cf = new ClassFile(data);
        return new ZClass(cf);
    }

    //加载当前类的父类,除非是Object类，否则需要递归调用LoadClass()方法加载它的超类
    //默认情况下,父类和子类的类加载器是同一个;
    private void resolveSuperClass(ZClass clazz) {
        if (!"java/lang/Object".equals(clazz.thisClassName)) {
            clazz.superClass = clazz.loader.loadClass(clazz.superClassName);
        }
    }

    //加载当前类的接口类
    private void resolveInterfaces(ZClass clazz) {
        int count = clazz.interfaceNames.length;
        clazz.interfaces = new ZClass[count];
        for (int i = 0; i < count; i++) {
            clazz.interfaces[i] = clazz.loader.loadClass(clazz.interfaceNames[i]);
        }
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

    // 为static final 修饰的成员赋值,这种类型的成员是ConstantXXXInfo类型的,该info中包含真正的值;
    private void initStaticFinalVar(ZClass clazz, ZField zfield) {
        Slots staticVars = clazz.staticVars;
        RuntimeConstantPool runtimeConstantPool = clazz.getRuntimeConstantPool();
        int index = zfield.constValueIndex;
        int slotId = zfield.slotId;

        if (index > 0) {
            switch (zfield.getDescriptor()) {
                case "Z":
                case "B":
                case "C":
                case "S":
                case "I":
                    int intValue = (int) runtimeConstantPool.getRuntimeConstant(index).getValue();
                    staticVars.setInt(slotId, intValue);
                    break;
                case "J":
                    long longValue = (long) runtimeConstantPool.getRuntimeConstant(index).getValue();
                    staticVars.setLong(slotId, longValue);
                    break;
                case "F":
                    float floatValue = (float) runtimeConstantPool.getRuntimeConstant(index).getValue();
                    staticVars.setFloat(slotId, floatValue);
                    break;
                case "D":
                    double doubleValue = (double) runtimeConstantPool.getRuntimeConstant(index).getValue();
                    staticVars.setDouble(slotId, doubleValue);
                    break;
                case "Ljava/lang/String;":
                    String stringValue = (String) runtimeConstantPool.getRuntimeConstant(index).getValue();
                   // Zobject jStr = StringPool.jString(clazz.getLoader(), stringValue);
                default:
                    break;
            }
        }

    }

}
