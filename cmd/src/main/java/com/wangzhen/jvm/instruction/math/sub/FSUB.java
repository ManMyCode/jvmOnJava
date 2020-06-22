package com.wangzhen.jvm.instruction.math.sub;

import com.wangzhen.jvm.instruction.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class FSUB extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float num1 = stack.popFLoat();
        float num2 = stack.popFLoat();
        float result = num2 - num1;
        stack.pushFLoat(result);
    }
}
