package com.wangzhen.jvm.instructions.constants;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;

public class ICONST_0 extends NoOperandsInstruction {

    @Override
    public void execute(JFrame frame) {
        frame.getOperandStack().pushInt(0);
    }
}
