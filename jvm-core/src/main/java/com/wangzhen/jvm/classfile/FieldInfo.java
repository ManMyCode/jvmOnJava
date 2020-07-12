package com.wangzhen.jvm.classfile;

import com.wangzhen.jvm.attribute.AttributeInfo;
import com.wangzhen.jvm.classConstant.ConstantPool;
import com.wangzhen.jvm.classfile.classPackage.ClassReader;

/**
 常量池中的字段，结构如下
 field_info {
     u2 access_flags;      //字段的访问修饰符
     u2 name_index;        //常量池索引，代表字段的简单名称
     u2 descriptor_index;  //常量池索引，代表字段描述符
     u2 attributes_count;  //字段的额外附加属性数量
     attribute_info attributes[attributes_count];  //字段的额外的附加属性
 }
 */
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
