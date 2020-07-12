package com.wangzhen.jvm.classfile;

import com.wangzhen.jvm.attribute.AttributeInfo;
import com.wangzhen.jvm.classConstant.ConstantPool;
import com.wangzhen.jvm.classfile.classPackage.ClassReader;

public class MethodInfo {
    // 访问标识符
    public int accessFlags;
    // 字段名称索引
    public int nameIndex;
    // 字段描述索引
    public int descriptorIndex;
    // 属性表数量
    public int attributesAccount;
    public AttributeInfo [] attributeInfos;

    ConstantPool constantPool;

    public MethodInfo(ClassReader classReader, ConstantPool constantPool) {
        this.constantPool =constantPool;
        this.accessFlags = classReader.readNByteToInt(2);
        this.nameIndex = classReader.readNByteToInt(2);
        this.descriptorIndex = classReader.readNByteToInt(2);
        //this.attributesAccount = classReader.readNByteToInt(2);
        attributeInfos = AttributeInfo.readAttributeInfos(classReader,constantPool);
    }

    public static MethodInfo[] readMethodInfos(ClassReader classReader, ConstantPool constantPool){
        int methodCounts = classReader.readNByteToInt(2);
        MethodInfo[] methodInfos = new MethodInfo[methodCounts];
        for (int i=0;i<methodCounts;i++ ){
            methodInfos[i]=new MethodInfo(classReader,constantPool);
        }
        return methodInfos;
    }

}
