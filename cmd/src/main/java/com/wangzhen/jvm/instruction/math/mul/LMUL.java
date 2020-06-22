package com.wangzhen.jvm.instruction.math.mul;

import com.wangzhen.jvm.instruction.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class LMUL extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long d1 = stack.popLong();
        long d2 = stack.popLong();
        long result = d1 * d2;
        stack.pushLong(result);
    }
}
