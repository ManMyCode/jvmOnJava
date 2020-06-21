package com.wangzhen.jvm.instruction.constants;

import com.wangzhen.jvm.instruction.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;

public class ICONST_1 extends NoOperandsInstruction {

    @Override
    public void execute(JFrame frame) {
        frame.getOperandStack().pushInt(1);
    }
}
