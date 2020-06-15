package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class ConstantMethodHandleInfo extends ConstantInof{
    private byte referenceKind;
    private int referenceIndex;

    public ConstantMethodHandleInfo(ClassReader classReader) {
        readInfo(classReader);
    }

    @Override
    void readInfo(ClassReader classReader) {
        referenceKind = classReader.readNByte(1)[0];
        referenceIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
    }
}
