package com.wangzhen.jvm.instruction.loads.loadInt;

import com.wangzhen.jvm.instruction.base.Index8Instruction;
import com.wangzhen.jvm.instruction.loads.Load;
import com.wangzhen.jvm.runtimeData.JFrame;

public class ILOAD_2 extends Index8Instruction {
    @Override
    public void execute(JFrame frame) {
        Load.iLoad(frame,2);
    }
}
