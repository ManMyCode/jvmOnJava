package com.wangzhen.jvm.instructions.constants;

import com.wangzhen.jvm.instructions.base.Index16Instruction;
import com.wangzhen.jvm.runtimeData.ZFrame;

/**
 * Description: LDC2_W 和 LDC 的区别是，其获取常量池的常量类型为 Long 和 Double，都是 16bit 宽的
 * Datetime:    2020/9/27   13:52
 * Author:   王震
 */
public class LDC2_W extends Index16Instruction {
    @Override
    public void execute(ZFrame frame) throws NoSuchMethodException {

    }
}