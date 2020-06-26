package com.wangzhen.jvm.instructions.math.div;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class FDIV extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float num1 = stack.popFLoat();
        float num2 = stack.popFLoat();
        float result = num2/num1;
        stack.pushFLoat(result);
    }
}
