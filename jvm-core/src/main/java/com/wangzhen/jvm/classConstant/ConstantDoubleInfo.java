package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class ConstantDoubleInfo extends ConstantInof{
    public Double value;

    public ConstantDoubleInfo(ClassReader classReader) {
        readInfo(classReader);
    }

    @Override
    void readInfo(ClassReader classReader) {
        byte [] doubleBytes = classReader.readNByte(8);
        value = ByteUtils.byteToDouble64(doubleBytes);
    }

    public Double getValue() {
        return value;
    }
}
