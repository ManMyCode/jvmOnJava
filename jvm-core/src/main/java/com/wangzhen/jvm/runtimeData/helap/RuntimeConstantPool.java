package com.wangzhen.jvm.runtimeData.helap;

import com.wangzhen.jvm.classConstant.*;

import java.util.NoSuchElementException;

public class RuntimeConstantPool {
    ZClass zClass;
    RuntimeConstantInfo[] infos;

    public RuntimeConstantPool(ZClass zClass, ConstantPool classFileConstantPool) {
        this.zClass = zClass;
        ConstantInof [] classFileConstantInofs  = classFileConstantPool.getConstantInofs();
        this.infos = new RuntimeConstantInfo[classFileConstantInofs.length];
        for (int i =0;i<classFileConstantInofs.length;i++){
            ConstantInof classFileConstantInof = classFileConstantInofs[i];
            switch (classFileConstantInof.getType()){
                case ConstantInof.CONSTANT_utf8_info :
                    ConstantUtf8Info constantUtf8Info = (ConstantUtf8Info) classFileConstantInof;
                    this.infos[i] = new RuntimeConstantInfo<String>(constantUtf8Info.getValue(),ConstantInof.CONSTANT_utf8_info);
                    break;
                case ConstantInof.CONSTANT_Integer_info:
                    ConstantIntegerInfo constantIntegerInfo = (ConstantIntegerInfo) classFileConstantInof;
                    this.infos[i] = new RuntimeConstantInfo<Integer>(constantIntegerInfo.getValue(),ConstantInof.CONSTANT_Integer_info);
                    break;
                case ConstantInof.CONSTANT_Float_info:
                    ConstantFloatInfo constantFloatInfo = (ConstantFloatInfo) classFileConstantInof;
                    this.infos[i] = new RuntimeConstantInfo<Float>(constantFloatInfo.getValue(),ConstantInof.CONSTANT_Float_info);
                    break;
                case ConstantInof.CONSTANT_Long_info:
                    ConstantLongInfo constantLongInfo = (ConstantLongInfo) classFileConstantInof;
                    this.infos[i] = new RuntimeConstantInfo<Long>(constantLongInfo.value,ConstantInof.CONSTANT_Long_info);
                    break;
                case ConstantInof.CONSTANT_Double_info:
                    ConstantDoubleInfo constantDoubleInfo = (ConstantDoubleInfo) classFileConstantInof;
                    this.infos[i] = new RuntimeConstantInfo<Double>(constantDoubleInfo.getValue(),ConstantInof.CONSTANT_Double_info);
                    break;
                case ConstantInof.CONSTANT_Class_info:
                    ConstantClassInfo constantClassInfo = (ConstantClassInfo) classFileConstantInof;

                    break;
                case ConstantInof.CONSTANT_String_info:
                    break;
                case ConstantInof.CONSTANT_Fieldref_info:
                    break;
                case ConstantInof.CONSTANT_Methodref_info:
                    break;
                case ConstantInof.CONSTANT_InterfaceMethodref_info:
                    break;
                case ConstantInof.CONSTANT_NameAndType_info:
                    break;
                case ConstantInof.CONSTANT_MethodHandle_info:
                    break;
                case ConstantInof.CONSTANT_MethodType_info:
                    break;
                case ConstantInof.CONSTANT_InvokeDynamic_info:
                    break;

            }

        }


    }
    //这里只是把ConstantInfo返回，至于具体是那种数据，可以根据其中保存的type字段来判断，并拿到对应类型的值；
    public RuntimeConstantInfo getRuntimeConstant(int index) {
        RuntimeConstantInfo info = infos[index];
        if (info != null) {
            return info;
        }

        throw new NoSuchElementException("No constants at index " + index);
    }
}
