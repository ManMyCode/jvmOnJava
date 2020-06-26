package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class ConstantLongInfo extends ConstantInof{
    public long value;

    public ConstantLongInfo(ClassReader classReader) {
        readInfo(classReader);
    }

    @Override
    void readInfo(ClassReader classReader) {
        byte [] logBytes = classReader.readNByte(8);
        value = ByteUtils.byteToLong64(logBytes);
    }
}
