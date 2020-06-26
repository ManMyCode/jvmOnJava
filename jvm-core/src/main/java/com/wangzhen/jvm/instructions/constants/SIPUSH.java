package com.wangzhen.jvm.instructions.constants;

import com.wangzhen.jvm.instructions.base.ByteCodeReader;
import com.wangzhen.jvm.instructions.base.Instruction;
import com.wangzhen.jvm.runtimeData.JFrame;

public class SIPUSH implements Instruction {
    int val;
    @Override
    public void fetchOperands(ByteCodeReader codeReader) {
        val = codeReader.readInt16();
    }

    @Override
    public void execute(JFrame frame) {
        frame.getOperandStack().pushInt(val);
    }
}
