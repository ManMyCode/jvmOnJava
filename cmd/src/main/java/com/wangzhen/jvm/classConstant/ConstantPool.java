package com.wangzhen.jvm.classConstant;

import com.sun.org.apache.bcel.internal.classfile.ConstantInterfaceMethodref;
import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

public class ConstantPool {
    public int constantPoolCount;
    public int realConstantPoolCount;
    public ConstantInof[] constantInofs;

    public ConstantPool(ClassReader classReader) {
        // 读取 2个字节的 常量池大小数量
        constantPoolCount = ByteUtils.bytesToInt(classReader.readUint2());
        constantInofs = new ConstantInof[constantPoolCount];
        for (int i =1;i< constantPoolCount;i++){
            constantInofs[i] = createConstantInfo(classReader);
            realConstantPoolCount++;
            if ((constantInofs[i] instanceof ConstantLongInfo) || (constantInofs[i] instanceof ConstantDoubleInfo)) {
                i++;
            }
        }
        System.out.println(constantInofs.toString());
    }

    public ConstantInof createConstantInfo(ClassReader classReader){
        // 先读取常量池的tag标记其是哪一次信息
        int tag = ByteUtils.bytesToInt(classReader.readUint1());
        switch (tag){
            case ConstantInof.CONSTANT_utf8_info :
                return new ConstantUtf8Info(classReader);
            case ConstantInof.CONSTANT_Integer_info:
                return new ConstantIntegerInfo(classReader);
            case ConstantInof.CONSTANT_Float_info:
                return new ConstantFloatInfo(classReader);
            case ConstantInof.CONSTANT_Long_info:
                return new ConstantLongInfo(classReader);
            case ConstantInof.CONSTANT_Double_info:
                return new ConstantDoubleInfo(classReader);
            case ConstantInof.CONSTANT_Class_info:
                return new ConstantClassInfo(this,classReader);
            case ConstantInof.CONSTANT_String_info:
                return new ConstantStringInfo(this,classReader);
            case ConstantInof.CONSTANT_Fieldref_info:
                return new ConstantFieldRefInfo(this,classReader);
            case ConstantInof.CONSTANT_Methodref_info:
                return new ConstantMethodRefInfo(this,classReader);
            case ConstantInof.CONSTANT_InterfaceMethodref_info:
                return new ConstantInterfaceMethodRefInfo(this,classReader);
            case ConstantInof.CONSTANT_NameAndType_info:
                return new ConstantNameAndTypeInfo(this,classReader);
            case ConstantInof.CONSTANT_MethodHandle_info:
                return new ConstantMethodHandleInfo(classReader);
            case ConstantInof.CONSTANT_MothodType_info:
                return new ConstantMethodTypeInfo(classReader);
            case ConstantInof.CONSTANT_InvokeDynamic_info:
                return new ConstantInvokeDynamicInfo(classReader);
            default:
               throw new RuntimeException("java.lang.ClassFormatError: constant pool tag!");
               // return null;







        }

    }

    // 获取常量池中的 静态字符
    public String getConstantPoolUtf8Value(int index){
        ConstantUtf8Info constantUtf8Info = (ConstantUtf8Info) constantInofs[index];
        return  constantUtf8Info.getValue();
    }

    public int getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(int constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    public int getRealConstantPoolCount() {
        return realConstantPoolCount;
    }

    public void setRealConstantPoolCount(int realConstantPoolCount) {
        this.realConstantPoolCount = realConstantPoolCount;
    }

    public ConstantInof[] getConstantInofs() {
        return constantInofs;
    }

    public void setConstantInofs(ConstantInof[] constantInofs) {
        this.constantInofs = constantInofs;
    }
}
