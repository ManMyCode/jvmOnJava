package com.wangzhen.jvm.instruction.constants;

import com.wangzhen.jvm.instruction.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.JFrame;


/**
 * Author: zhangxin
 * Time: 2017/5/5 0005.
 * Desc: Push float
 */
public class FCONST_2 extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        frame.getOperandStack().pushFLoat(2.0f);
    }
}
