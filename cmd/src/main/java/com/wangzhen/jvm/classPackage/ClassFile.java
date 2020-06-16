package com.wangzhen.jvm.classPackage;


import com.wangzhen.jvm.attribute.AttributeInfo;
import com.wangzhen.jvm.classConstant.ConstantInof;
import com.wangzhen.jvm.classConstant.ConstantPool;
import com.wangzhen.jvm.field.FieldInfo;
import com.wangzhen.jvm.method.MethodInfo;
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
    int thisClassIndex;
    // 父类索引 u2
    int superClassIndex;
    // 本类实现的接口数量 u2
    int interfacesCount;
    // 实现的接口 存放在数组中
    int[] interfaces;

    // 字段
    FieldInfo[] fields;

    // 方法
    MethodInfo[] methods;

    // 属性
    AttributeInfo[] attributes;


    public ClassFile(byte[] classData) {
        ClassReader classReader = new ClassReader(classData);
        read(classReader);

    }
    public void read(ClassReader classReader){
        // 读取魔数
        this.magic =  ByteUtils.bytesToHexString(classReader.readUint4());
       // 读取次版本号
        this.minorVersion = ByteUtils.bytesToInt(classReader.readUint2());
        // 读取主版本号
        this.majorVersion = ByteUtils.bytesToInt(classReader.readUint2());
        // 读取常量池
        constantPool = new ConstantPool(classReader);
        // 读取访问标识符
        this.accessFlags = ByteUtils.bytesToInt(classReader.readNByte(2));
        // 读取类索引
        this.thisClassIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
        // 读取父索引
        this.superClassIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
       //  读取接口索引，和接口内容
        readInterfaces(classReader);
        // 读取字段
        fields = FieldInfo.readFieldInfos(classReader,constantPool);
        // 读取方法
        methods = MethodInfo.readMethodInfos(classReader,constantPool);
        // 读取属性
        attributes = AttributeInfo.readAttributeInfos(classReader,constantPool);




    }

    public void readInterfaces(ClassReader classReader){

        // 读取 接口数量
        this.interfacesCount = classReader.readNByteToInt(2);
        for (int i =0 ;i<interfacesCount;i++){
            interfaces[i]=classReader.readNByteToInt(2);
        }
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
                ", thisClassIndex=" + thisClassIndex +
                ", superClassIndex=" + superClassIndex +
                ", interfacesCount=" + interfacesCount +
                ", interfaces=" + Arrays.toString(interfaces) +
                ", fields=" + Arrays.toString(fields) +
                ", methods=" + Arrays.toString(methods) +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}
