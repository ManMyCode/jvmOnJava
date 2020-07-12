package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classfile.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class ConstantMethodTypeInfo extends ConstantInfo {
    public int descIndex;

    public ConstantMethodTypeInfo(ClassReader classReader) {
        readInfo(classReader);
    }

    @Override
    void readInfo(ClassReader classReader) {
        descIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
    }
}
