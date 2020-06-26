package com.wangzhen.jvm.instructions.conversions.l2x;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class L2I extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long val1= stack.popLong();
        int val2 = (int) val1;
        stack.pushInt(val2);
    }
}
