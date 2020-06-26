package com.wangzhen.jvm.instructions.loads.loadFloat;

import com.wangzhen.jvm.instructions.base.Index8Instruction;
import com.wangzhen.jvm.instructions.loads.Load;
import com.wangzhen.jvm.runtimeData.ZFrame;

public class FLOAD_1 extends Index8Instruction {
    @Override
    public void execute(ZFrame frame) {
        Load.fLoad(frame,0);
    }
}
