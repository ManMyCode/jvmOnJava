package com.wangzhen.jvm.instructions.comparisons.ificmp;

import com.wangzhen.jvm.runtimeData.OperandStack;
import com.wangzhen.jvm.runtimeData.ZFrame;

/**
 * Description:  将方法中的数压入 当前方法的操作数栈中，然后使用 ificmp 指令进行比较，然后跳转到对应的字节码
 * Datetime:    2020/9/28   11:00
 * Author:   王震
 */
public class IfIcmp {
    static int[] _icmpPop(ZFrame frame) {
        OperandStack operandStack = frame.getOperandStack();
        int []res = new int[2];
        res[0]=operandStack.popInt();
        res[1]=operandStack.popInt();
        return res;
    }
}