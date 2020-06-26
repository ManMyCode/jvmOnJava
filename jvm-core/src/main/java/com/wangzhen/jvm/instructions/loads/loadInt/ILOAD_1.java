package com.wangzhen.jvm.instructions.loads.loadInt;

import com.wangzhen.jvm.instructions.base.Index8Instruction;
import com.wangzhen.jvm.instructions.loads.Load;
import com.wangzhen.jvm.runtimeData.ZFrame;

public class ILOAD_1 extends Index8Instruction {
    @Override
    public void execute(ZFrame frame) {
        Load.iLoad(frame,1);
    }
}
