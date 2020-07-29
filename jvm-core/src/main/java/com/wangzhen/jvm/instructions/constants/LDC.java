package com.wangzhen.jvm.instructions.constants;


import com.wangzhen.jvm.classConstant.ConstantInfo;
import com.wangzhen.jvm.instructions.base.Index8Instruction;
import com.wangzhen.jvm.runtimeData.OperandStack;
import com.wangzhen.jvm.runtimeData.ZFrame;
import com.wangzhen.jvm.runtimeData.helap.RuntimeConstantInfo;
import com.wangzhen.jvm.runtimeData.helap.RuntimeConstantPool;
import com.wangzhen.jvm.runtimeData.helap.ZClass;

/**
 * @author zachaxy
 * @date 17/12/26
 * desc:获取操作数index，通过 index 来获取运行时常量池中的常量,并将其压入操作数栈
 */
public class LDC extends Index8Instruction {
    @Override
    public void execute(ZFrame frame) throws NoSuchMethodException {
        ZClass zClass = frame.getMethod().getClazz();
        RuntimeConstantPool runtimeConstantPool= zClass.getRuntimeConstantPool();
        OperandStack operandStack = frame.getOperandStack();
        RuntimeConstantInfo runtimeConstantInfo= runtimeConstantPool.getRuntimeConstant(index);
        switch (runtimeConstantInfo.getType()){
            case ConstantInfo.CONSTANT_Integer_info:
                operandStack.pushInt((Integer) runtimeConstantInfo.getValue());
                break;
            case ConstantInfo.CONSTANT_Float_info:
                operandStack.pushFLoat((Float) runtimeConstantInfo.getValue());
                break;
            case ConstantInfo.CONSTANT_String_info:


        }
    }
}
