package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classfile.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class ConstantMethodRefInfo extends ConstantInfo {
    public  ConstantPool constantPool;
    public int classIndex;
    public int nameAndTyeIndex;

    public ConstantMethodRefInfo(ConstantPool constantPool,ClassReader classReader) {
        readInfo(classReader);
        this.constantPool = constantPool;
    }

    @Override
    void readInfo(ClassReader classReader) {
        classIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
        nameAndTyeIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
    }
}
