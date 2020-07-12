package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classfile.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class ConstantNameAndTypeInfo extends ConstantInfo {
    public  ConstantPool constantPool;
    public int functionNameIndex;
    public int descriptionIndex;

    public ConstantNameAndTypeInfo(ConstantPool constantPool, ClassReader classReader) {
        readInfo(classReader);
        this.constantPool = constantPool;
    }

    @Override
    void readInfo(ClassReader classReader) {
        functionNameIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
        descriptionIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
    }
}
