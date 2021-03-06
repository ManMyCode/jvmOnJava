package com.wangzhen.jvm.instructions.loads.loadxarr;

import com.wangzhen.jvm.instructions.base.NoOperandsInstruction;
import com.wangzhen.jvm.instructions.loads.Load;
import com.wangzhen.jvm.runtimeData.OperandStack;
import com.wangzhen.jvm.runtimeData.ZFrame;
import com.wangzhen.jvm.runtimeData.helap.ZObject;

/**
 * Description:
 * Datetime:    2020/9/28   14:10
 * Author:   王震
 */
public class CALOAD extends NoOperandsInstruction {
    @Override
    public void execute(ZFrame frame) {
        OperandStack operandStack = frame.getOperandStack();
        // 数组索引
        int index = operandStack.popInt();
        ZObject zObject = operandStack.popRef();
        Load.checkNotNull(zObject);
        // 将对象 转为为 数组对象
        char[] refs = zObject.getChars();
        Load.checkIndex(refs.length,index);
        operandStack.pushInt(refs[index]);
    }
}