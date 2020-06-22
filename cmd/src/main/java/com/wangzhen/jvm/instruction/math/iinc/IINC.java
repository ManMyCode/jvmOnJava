package com.wangzhen.jvm.instruction.math.iinc;

import com.wangzhen.jvm.instruction.base.ByteCodeReader;
import com.wangzhen.jvm.instruction.base.Instruction;
import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.LocalVars;

public class IINC implements Instruction {
    int index;
    int offset;
    @Override
    public void fetchOperands(ByteCodeReader codeReader) {
        index = codeReader.readUint8();
        offset = codeReader.readInt8();
    }

    @Override
    public void execute(JFrame frame) {
        LocalVars localVars = frame.getLocalVars();
        int num1= localVars.getInt(index);
        int result = num1 + offset;
        localVars.setInt(index,result);
    }
}
