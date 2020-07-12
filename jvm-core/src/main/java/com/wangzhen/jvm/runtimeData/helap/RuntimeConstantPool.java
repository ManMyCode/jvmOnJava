package com.wangzhen.jvm.runtimeData.helap;

import com.wangzhen.jvm.classConstant.*;

import java.util.NoSuchElementException;

public class RuntimeConstantPool {
    ZClass zClass;
    RuntimeConstantInfo[] infos;

    public RuntimeConstantPool(ZClass zClass, ConstantPool classFileConstantPool) {
        this.zClass = zClass;
        ConstantInfo[] classFileConstantInfos = classFileConstantPool.getConstantInfos();
        this.infos = new RuntimeConstantInfo[classFileConstantInfos.length];
        for (int i = 0; i< classFileConstantInfos.length; i++){
            ConstantInfo classFileConstantInfo = classFileConstantInfos[i];
            switch (classFileConstantInfo.getType()){
                case ConstantInfo.CONSTANT_utf8_info :
                    ConstantUtf8Info constantUtf8Info = (ConstantUtf8Info) classFileConstantInfo;
                    this.infos[i] = new RuntimeConstantInfo<String>(constantUtf8Info.getValue(), ConstantInfo.CONSTANT_utf8_info);
                    break;
                case ConstantInfo.CONSTANT_Integer_info:
                    ConstantIntegerInfo constantIntegerInfo = (ConstantIntegerInfo) classFileConstantInfo;
                    this.infos[i] = new RuntimeConstantInfo<Integer>(constantIntegerInfo.getValue(), ConstantInfo.CONSTANT_Integer_info);
                    break;
                case ConstantInfo.CONSTANT_Float_info:
                    ConstantFloatInfo constantFloatInfo = (ConstantFloatInfo) classFileConstantInfo;
                    this.infos[i] = new RuntimeConstantInfo<Float>(constantFloatInfo.getValue(), ConstantInfo.CONSTANT_Float_info);
                    break;
                case ConstantInfo.CONSTANT_Long_info:
                    ConstantLongInfo constantLongInfo = (ConstantLongInfo) classFileConstantInfo;
                    this.infos[i] = new RuntimeConstantInfo<Long>(constantLongInfo.value, ConstantInfo.CONSTANT_Long_info);
                    break;
                case ConstantInfo.CONSTANT_Double_info:
                    ConstantDoubleInfo constantDoubleInfo = (ConstantDoubleInfo) classFileConstantInfo;
                    this.infos[i] = new RuntimeConstantInfo<Double>(constantDoubleInfo.getValue(), ConstantInfo.CONSTANT_Double_info);
                    break;
                case ConstantInfo.CONSTANT_Class_info:
                    ConstantClassInfo constantClassInfo = (ConstantClassInfo) classFileConstantInfo;
                    this.infos[i] = new RuntimeConstantInfo<ClassRef>(new ClassRef(this,constantClassInfo), ConstantInfo.CONSTANT_Class_info);

                    break;
                case ConstantInfo.CONSTANT_String_info:
                    ConstantStringInfo constantStringInfo = (ConstantStringInfo) classFileConstantInfo;
                    this.infos[i] = new RuntimeConstantInfo<String>(constantStringInfo.getStringValue(), ConstantInfo.CONSTANT_String_info);
                    break;
                case ConstantInfo.CONSTANT_Fieldref_info:
                    ConstantFieldRefInfo constantFieldRefInfo = (ConstantFieldRefInfo) classFileConstantInfo;
                    //this.infos[i] = new RuntimeConstantInfo<>
                    break;
                case ConstantInfo.CONSTANT_Methodref_info:
                    break;
                case ConstantInfo.CONSTANT_InterfaceMethodref_info:
                    break;
                case ConstantInfo.CONSTANT_NameAndType_info:
                    break;
                case ConstantInfo.CONSTANT_MethodHandle_info:
                    break;
                case ConstantInfo.CONSTANT_MethodType_info:
                    break;
                case ConstantInfo.CONSTANT_InvokeDynamic_info:
                    break;
                default:
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
