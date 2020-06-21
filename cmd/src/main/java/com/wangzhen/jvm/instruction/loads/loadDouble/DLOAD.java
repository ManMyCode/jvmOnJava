package com.wangzhen.jvm.instruction.loads.loadDouble;

import com.wangzhen.jvm.instruction.base.Index8Instruction;
import com.wangzhen.jvm.instruction.loads.Load;
import com.wangzhen.jvm.runtimeData.JFrame;

public class DLOAD extends Index8Instruction {
    @Override
    public void execute(JFrame frame) {
        Load.dLoad(frame,index);
    }
}
