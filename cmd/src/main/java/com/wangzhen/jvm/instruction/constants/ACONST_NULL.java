package com.wangzhen.jvm.instruction.constants;

import com.wangzhen.jvm.instruction.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;

/**
 * 将 null push 到操作数栈顶
 */
public class ACONST_NULL extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        frame.getOperandStack().pushRef(null);
    }
}
