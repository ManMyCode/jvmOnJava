package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class ConstantStringInfo extends ConstantInof{
    public int stringIndex;
    public ConstantPool constantPool;
    public String stringValue;

    public ConstantStringInfo(ConstantPool constantPool,ClassReader classReader) {
        readInfo(classReader);
        this.constantPool = constantPool;
    }

    @Override
    void readInfo(ClassReader classReader) {
        stringIndex = classReader.readNByteToInt(2);
    }

    public String getStringValue() {
        stringValue = constantPool.getConstantPoolUtf8Value(stringIndex);
        return stringValue;
    }
}
