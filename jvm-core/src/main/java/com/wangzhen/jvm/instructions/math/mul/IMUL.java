package com.wangzhen.jvm.instructions.math.mul;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class IMUL extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int d1 = stack.popInt();
        int d2 = stack.popInt();
        int result = d1 * d2;
        stack.pushInt(result);
    }
}
