package com.wangzhen.jvm.instruction.loads.loadref;


import com.wangzhen.jvm.instruction.base.Index8Instruction;
import com.wangzhen.jvm.instruction.loads.Load;
import com.wangzhen.jvm.runtimeData.JFrame;

/**
 * Author: zhangxin
 * Time: 2017/5/5 0005.
 * Desc:
 */
public class ALOAD_2 extends Index8Instruction {

    @Override
    public void execute(JFrame frame) {
        Load.aLoad(frame,2);
    }
}
