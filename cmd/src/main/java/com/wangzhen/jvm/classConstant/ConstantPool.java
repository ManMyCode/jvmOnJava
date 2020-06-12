package com.wangzhen.jvm.classConstant;

import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class ConstantPool {
    public int constantPoolCount;
    public int realConstantPoolCount;
    public ConstantInof[] constantInofs;

    public ConstantPool(ClassReader classReader) {
        // 读取 2个字节的 常量池大小数量
        constantPoolCount = ByteUtils.byteToInt32(classReader.readUint2());
        constantInofs = new ConstantInof[constantPoolCount];
        for (int i =1;i<= constantPoolCount;i++){
            constantInofs[i] = createConstantInfo(classReader);
        }
    }

    public ConstantInof createConstantInfo(ClassReader classReader){
        // 先读取常量池的tag标记其是哪一次信息
        int tag = ByteUtils.byteToInt32(classReader.readUint1());
        switch (tag){
            case ConstantInof.CONSTANT_utf8_info :
                //return new
        }
        return null;
    }


}
