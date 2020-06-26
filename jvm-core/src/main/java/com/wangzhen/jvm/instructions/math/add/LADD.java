package com.wangzhen.jvm.instructions.math.add;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.OperandStack;

public class LADD extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long num1 = stack.popLong();
        long  num2 = stack.popLong();
        long  result = num1+num2;
        stack.pushLong(result);
    }
}
