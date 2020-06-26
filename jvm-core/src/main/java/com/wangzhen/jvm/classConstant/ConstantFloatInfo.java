package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class ConstantFloatInfo extends ConstantInof{
    public float value;

    public ConstantFloatInfo(ClassReader classReader) {
        readInfo(classReader);
    }

    @Override
    void readInfo(ClassReader classReader) {
        byte [] floatBytes = classReader.readNByte(4);
        value = ByteUtils.byteToFloat32(floatBytes);
    }
}
