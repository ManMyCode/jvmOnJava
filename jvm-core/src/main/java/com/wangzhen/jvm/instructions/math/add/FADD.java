package com.wangzhen.jvm.instructions.math.add;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class FADD extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float num1 = stack.popFLoat();
        float  num2 = stack.popFLoat();
        float  result = num1+num2;
        stack.pushFLoat(result);
    }
}
