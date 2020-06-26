package com.wangzhen.jvm.instructions.loads.loadFloat;

import com.wangzhen.jvm.instructions.base.Index8Instruction;
import com.wangzhen.jvm.instructions.loads.Load;
import com.wangzhen.jvm.runtimeData.JFrame;

public class FLOAD_1 extends Index8Instruction {
    @Override
    public void execute(JFrame frame) {
        Load.fLoad(frame,0);
    }
}
