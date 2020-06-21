package com.wangzhen.jvm.instruction.constants;

import com.wangzhen.jvm.instruction.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;


/**
 * nop指令是最简单的一条指令，因为它什么也不做
 */
public class NOP extends NoOperandsInstruction {
    @Override
    public void execute(JFrame jFrame) {

    }
}
