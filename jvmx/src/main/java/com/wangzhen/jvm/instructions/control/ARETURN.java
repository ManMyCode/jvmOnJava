package com.wangzhen.jvm.instructions.control;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.runtimeData.ZFrame;

/**
 * Description:
 * Datetime:    2020/9/28   8:41 下午
 * Author:   王震
 */
public class ARETURN extends NoOperandsInstruction {
    @Override
    public void execute(ZFrame frame) {
        System.out.println("该指令还没有完成");
    }
}
