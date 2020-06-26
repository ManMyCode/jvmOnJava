package com.wangzhen.jvm.instructions.math.rem;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class DREM extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double num1 = stack.popFLoat();
        double num2 = stack.popFLoat();
        double result = num2/num1;
        stack.pushDouble(result);

    }
}
