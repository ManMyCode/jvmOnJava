package com.wangzhen.jvm.instructions.math.mul;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class FMUL extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float d1 = stack.popFLoat();
        float d2 = stack.popFLoat();
        float result = d1 * d2;
        stack.pushFLoat(result);
    }
}
