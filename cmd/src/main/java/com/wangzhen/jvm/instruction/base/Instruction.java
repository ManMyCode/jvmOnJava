package com.wangzhen.jvm.instruction.base;

import com.wangzhen.jvm.runtimeData.JFrame;

public interface Instruction {
    //从字节码中提取操作数
    void fetchOperands(ByteCodeReader codeReader);

    // 执行指令逻辑
    void execute(JFrame jFrame);
}
