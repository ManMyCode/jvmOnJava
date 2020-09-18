package com.wangzhen.jvm.instructions.base;

import com.wangzhen.jvm.runtimeData.ZFrame;

public abstract  class BranchInstruction implements Instruction {

    public int offset;
    @Override
    public void fetchOperands(ByteCodeReader codeReader) {
        offset = codeReader.readUint16();
    }

}
