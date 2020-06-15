package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

import javax.print.DocFlavor;

public class ConstantInvokeDynamicInfo extends ConstantInof{

    int bootstrapMethodAttrIndex;
    int nameAndTypeIndex;

    public ConstantInvokeDynamicInfo(ClassReader classReader) {
        readInfo(classReader);
    }

    @Override
    void readInfo(ClassReader classReader) {
        bootstrapMethodAttrIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
        nameAndTypeIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
    }
}
