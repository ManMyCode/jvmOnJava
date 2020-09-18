package com.wangzhen.jvm.instructions.comparisons.ifacmp;

import com.wangzhen.jvm.runtimeData.OperandStack;
import com.wangzhen.jvm.runtimeData.ZFrame;
import com.wangzhen.jvm.runtimeData.helap.ZObject;

public class IfAcmp {
    public static  boolean _acmp(ZFrame frame){
        OperandStack stack = frame.getOperandStack();
        ZObject ref2 = stack.popRef();
        ZObject ref1 = stack.popRef();
        return ref2 == ref1;

    }
}
