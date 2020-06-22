package com.wangzhen.jvm.instruction.stores.storeref;

import com.wangzhen.jvm.instruction.base.Index8Instruction;
import com.wangzhen.jvm.instruction.base.NoOperandsInstruction;
import com.wangzhen.jvm.instruction.stores.Store;
import com.wangzhen.jvm.runtimeData.JFrame;

/**
 * Author: zhangxin
 * Time: 2017/5/5 0005.
 * Desc:
 */
public class ASTORE_0 extends NoOperandsInstruction {
    @Override
    public void execute(JFrame frame) {
        Store.astore(frame,0);
    }
}
