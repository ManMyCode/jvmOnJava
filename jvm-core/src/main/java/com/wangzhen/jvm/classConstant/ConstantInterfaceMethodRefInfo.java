package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classfile.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;


/**
 * Author: zhangxin
 * Time: 2017/5/3 0003.
 * Desc: 接口方法引用消息
 */
public class ConstantInterfaceMethodRefInfo extends ConstantInfo {
    public  ConstantPool constantPool;
    public int classIndex;
    public int nameAndTyeIndex;

    public ConstantInterfaceMethodRefInfo(ConstantPool constantPool, ClassReader classReader) {
        readInfo(classReader);
        this.constantPool = constantPool;
    }

    @Override
    void readInfo(ClassReader classReader) {
        classIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
        nameAndTyeIndex = ByteUtils.bytesToInt(classReader.readNByte(2));
    }
}
