package com.wangzhen.jvm.instruction.constants;

import com.wangzhen.jvm.instruction.base.ByteCodeReader;
import com.wangzhen.jvm.instruction.base.Instruction;
import com.wangzhen.jvm.runtimeData.JFrame;

public class BIPUSH implements Instruction {
    int val;
    @Override
    public void fetchOperands(ByteCodeReader codeReader) {
        val = codeReader.readInt8();
    }

    @Override
    public void execute(JFrame frame) {
        frame.getOperandStack().pushInt((val + 256) % 256);
    }


}
