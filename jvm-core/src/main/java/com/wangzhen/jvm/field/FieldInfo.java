package com.wangzhen.jvm.field;

import com.wangzhen.jvm.attribute.AttributeInfo;
import com.wangzhen.jvm.classConstant.ConstantPool;
import com.wangzhen.jvm.classPackage.ClassReader;

public class FieldInfo {

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

    public FieldInfo(ClassReader classReader, ConstantPool constantPool) {
        this.constantPool =constantPool;
        this.accessFlags = classReader.readNByteToInt(2);
        this.nameIndex = classReader.readNByteToInt(2);
        this.descriptorIndex = classReader.readNByteToInt(2);
        //this.attributesAccount = classReader.readNByteToInt(2);
        attributeInfos = AttributeInfo.readAttributeInfos(classReader,constantPool);
    }

    public static FieldInfo[] readFieldInfos(ClassReader classReader,ConstantPool constantPool){
        int fieldCounts = classReader.readNByteToInt(2);
        FieldInfo[] fieldInfos = new FieldInfo[fieldCounts];
        for (int i=0;i<fieldCounts;i++ ){
            fieldInfos[i]=new FieldInfo(classReader,constantPool);
        }
        return fieldInfos;
    }

}
