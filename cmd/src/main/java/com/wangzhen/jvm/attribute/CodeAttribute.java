package com.wangzhen.jvm.attribute;

import com.wangzhen.jvm.classConstant.ConstantPool;
import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class CodeAttribute extends AttributeInfo{
    ConstantPool constantPool;
    int maxStack;
    int maxLocals;
    int codeLength;
    byte[] code;
    int exceptionTableLength;
    ExceptionTable[] exceptionTables;
    AttributeInfo[] attributes;

    public CodeAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        maxStack = ByteUtils.bytesToInt(classReader.readNByte(2));
        maxLocals = ByteUtils.bytesToInt(classReader.readNByte(2));
        codeLength = ByteUtils.bytesToInt(classReader.readNByte(4));
        code = classReader.readNByte(codeLength);
        exceptionTableLength = ByteUtils.bytesToInt(classReader.readNByte(2));
        readExceptionTables(classReader,exceptionTableLength);
        attributes = readAttributeInfos(classReader,constantPool);

    }



    public void readExceptionTables(ClassReader classReader,int exceptionTableLength ) {
        exceptionTables = new ExceptionTable[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            ExceptionTable exceptionTable = new ExceptionTable(classReader);
            exceptionTables[i] = exceptionTable;
        }
    }
}
