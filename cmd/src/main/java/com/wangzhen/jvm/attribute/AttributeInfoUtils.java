package com.wangzhen.jvm.attribute;

import com.wangzhen.jvm.classConstant.ConstantPool;
import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class AttributeInfoUtils {


    public   AttributeInfo[] readAttributeInfos(ClassReader classReader,ConstantPool constantPool){
        // 读取属性表的数量
        int attributesCount = ByteUtils.bytesToInt(classReader.readNByte(2));
        AttributeInfo[] attributeInfos = new AttributeInfo[attributesCount];
        for (int i=0;i<attributesCount;i++){
            attributeInfos[i] = readAttributeInfo(classReader,constantPool);
        }
        return attributeInfos;
    }
}
