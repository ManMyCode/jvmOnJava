package com.wangzhen.jvm.instructions.constants;

import com.wangzhen.jvm.instructions.base.ByteCodeReader;
import com.wangzhen.jvm.instructions.base.Instruction;
import com.wangzhen.jvm.runtimeData.ZFrame;

/**
 *  从局部变量表中 读取一个操作数 然后在转换为int 推入到操作数
 */
public class BIPUSH implements Instruction {
    int val;
    @Override
    public void fetchOperands(ByteCodeReader codeReader) {
        val = codeReader.readInt8();
    }

    @Override
    public void execute(ZFrame frame) {
        frame.getOperandStack().pushInt((val + 256) % 256);
    }


}
