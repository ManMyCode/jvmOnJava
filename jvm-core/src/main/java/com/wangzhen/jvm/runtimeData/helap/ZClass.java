package com.wangzhen.jvm.runtimeData.helap;

import com.wangzhen.jvm.classPackage.ClassFile;
import com.wangzhen.jvm.runtimeData.Slots;

public class ZClass {
    // 访问标识符
    private int accessFlags;
    // 当前类的名字（完全限定名）
    public String thisClassName;
    //父类的名字 （完全限定名）
    public String superClassName;
    //接口名字(完全限定名,不可以为null,若为接口,数组大小为0)
    public String[] interfaceNames;
    //运行时常量池,注意和class文件中常量池区别;
    private RuntimeConstantPool runtimeConstantPool;
    //字段表,包括静态和非静态，此时并不分配 slotId；下面的staticVars 是其子集
    ZField[] fileds;
    //方法表，包括静态和非静态
    ZMethod[] methods;
    //类加载器
    ZClassLoader loader;
    //当前类的父类class,由类加载时,给父类赋值;
    ZClass superClass;
    //当前类的接口class,由类加载时,给父类赋值;
    ZClass[] interfaces;
    //非静态变量占用slot大小,这里只是统计个数(从顶级父类Object开始算起)
    int instanceSlotCount;
    // 静态变量所占空间大小
    int staticSlotCount;
    // 存放静态变量
    Slots staticVars;
    //判断类是否已经初始化，执行了类的<clinit>方法
    boolean initStarted;
    // jObject 指向的是该类的元类对象obj。 eg：String.class 得到的结果
    ZObject jObject;
    String sourceFile;

    public ZClass(ClassFile classFile) {
        this.accessFlags = classFile.getAccessFlags();
        //this.thisClassName = classFile.get
        this.thisClassName=classFile.getThisClassName();
        this.superClassName=classFile.getSuperClassName();
        this.interfaceNames = classFile.getInterfaceNames();
       // RuntimeConstantPool runtimeConstantPool = new RuntimeConstantPool();

    }
}
