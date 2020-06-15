package com.wangzhen.jvm.attribute;

import com.wangzhen.jvm.classConstant.ConstantPool;
import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public abstract class AttributeInfo {
    // 属性名的index
    public int attributeNameIndex;
    // 属性名的值（从常量池里面查找）
    public String attributeNameValue;

    public int attributeLength;

    public abstract void readInfo(ClassReader classReader);

    public  AttributeInfo  readAttributeInfo(ClassReader classReader,ConstantPool constantPool){
        //读取属性名索引
        attributeNameIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
        // 从常量池中读取属性名的值
        attributeNameValue = constantPool.getConstantPoolUtf8Value(attributeNameIndex);
        attributeLength = ByteUtils.bytesToInt(classReader.readNByte(4));
        AttributeInfo attributeInfo =  createAttributeInfo(attributeNameValue,classReader,constantPool);
        attributeInfo.readInfo(classReader);
        return attributeInfo;
    }

    public   AttributeInfo[] readAttributeInfos(ClassReader classReader,ConstantPool constantPool){
        // 读取属性表的数量
        int attributesCount = ByteUtils.bytesToInt(classReader.readNByte(2));
        AttributeInfo[] attributeInfos = new AttributeInfo[attributesCount];
        for (int i=0;i<attributesCount;i++){
            attributeInfos[i] = readAttributeInfo(classReader,constantPool);
        }
        return attributeInfos;
    }

    public static AttributeInfo createAttributeInfo(String attributeNameValue,ClassReader classReader,ConstantPool constantPool){
        if ("Code".equals(attributeNameValue)) {
            return new CodeAttribute(constantPool);
        } else if ("ConstantValue".equals(attributeNameValue)) {
            return new ConstantValueAttribute(constantPool);
        } else if ("Deprecated".equals(attributeNameValue)) {
            return new DeprecatedAttribute();
        } else if ("Exceptions".equals(attributeNameValue)) {
            return new ExceptionsAttribute();
        } else if ("LineNumberTable".equals(attributeNameValue)) {
            return new LineNumberTableAttribute();
        } else if ("LocalVariableTable".equals(attributeNameValue)) {
            return new LocalVariableTableAttribute();
        } else if ("SourceFile".equals(attributeNameValue)) {
            return new SourceFileAttribute(constantPool);
        } else if ("Synthetic".equals(attributeNameValue)) {
            return new SyntheticAttribute();
        } else {
           // return new UnparsedAttribute(attrName, attrLen);
        }
        return null;
    }
}
