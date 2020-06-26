package com.wangzhen.jvm.instructions.stores.storedouble;


import com.wangzhen.jvm.instructions.base.Index8Instruction;
import com.wangzhen.jvm.instructions.stores.Store;
import com.wangzhen.jvm.runtimeData.JFrame;

/**
 * Author: zhangxin
 * Time: 2017/5/5 0005.
 * Desc:
 */
public class DSTORE extends Index8Instruction {

    @Override
    public void execute(JFrame frame) {
        Store.astore(frame,index);
    }
}
