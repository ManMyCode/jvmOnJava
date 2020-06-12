package com.wangzhen.jvm.classPackage;


import com.wangzhen.jvm.classConstant.ConstantInof;
import com.wangzhen.jvm.classConstant.ConstantPool;
import com.wangzhen.jvm.utils.ByteUtils;

import java.util.Arrays;

public class ClassFile {
    //魔数 0xcafebabe  u4
    String magic;
    // 次版本号 u2
    int minorVersion;
    // 主版本号 u2
    int majorVersion;
    // 常量池大小 u2
    int constantPoolCount;
    // 常量池
    ConstantPool constantPool;
    // 访问标识 u2
    int accessFlags;
    // 类索引 u2
    int thisClass;
    // 父类索引 u2
    int superClass;
    // 本类实现的接口数量 u2
    int interfacesCount;
    // 实现的接口 存放在数组中
    int[] interfaces;

    // 字段
    Object[] fields;

    // 方法
    Object[] methods;

    // 属性
    Object[] attributes;


    public ClassFile(byte[] classData) {
        ClassReader classReader = new ClassReader(classData);
        read(classReader);

    }
    public void read(ClassReader classReader){
        // 读取魔数
        this.magic =  ByteUtils.bytesToHexString(classReader.readUint4());
       // 读取次版本号
        this.minorVersion = ByteUtils.byteToInt32(classReader.readUint2());
        this.majorVersion = ByteUtils.byteToInt32(classReader.readUint2());
       // constantPool = ConstantInof.c
        constantPool = new ConstantPool(classReader);


    }

    @Override
    public String toString() {
        return "ClassFile{" +
                "magic='" + magic + '\'' +
                ", minorVersion=" + minorVersion +
                ", majorVersion=" + majorVersion +
                ", constantPoolCount=" + constantPoolCount +
                ", constantPool=" + constantPool +
                ", accessFlags=" + accessFlags +
                ", thisClass=" + thisClass +
                ", superClass=" + superClass +
                ", interfacesCount=" + interfacesCount +
                ", interfaces=" + Arrays.toString(interfaces) +
                ", fields=" + Arrays.toString(fields) +
                ", methods=" + Arrays.toString(methods) +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}
