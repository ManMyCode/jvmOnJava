package com.wangzhen.jvm.instruction.loads.loadFloat;

import com.wangzhen.jvm.instruction.base.Index8Instruction;
import com.wangzhen.jvm.instruction.loads.Load;
import com.wangzhen.jvm.runtimeData.JFrame;

public class FLOAD_2 extends Index8Instruction {
    @Override
    public void execute(JFrame frame) {
        Load.fLoad(frame,0);
    }
}
