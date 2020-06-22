package com.wangzhen.jvm.instruction.stack.pop;

import com.wangzhen.jvm.instruction.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;

public class POP2 extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {

        frame.getOperandStack().popSlot();
        frame.getOperandStack().popSlot();
    }
}
