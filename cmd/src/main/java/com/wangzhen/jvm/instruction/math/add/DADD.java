package com.wangzhen.jvm.instruction.math.add;

import com.wangzhen.jvm.instruction.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class DADD extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double d1 = stack.popDouble();
        double d2 = stack.popDouble();
        double result = d1+d2;
        stack.pushDouble(result);
    }
}
