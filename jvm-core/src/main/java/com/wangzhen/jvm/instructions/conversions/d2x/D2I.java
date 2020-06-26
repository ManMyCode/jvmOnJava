package com.wangzhen.jvm.instructions.conversions.d2x;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class D2I extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double val1= stack.popDouble();
        int val2 = (int) val1;
        stack.pushFLoat(val2);
    }
}
