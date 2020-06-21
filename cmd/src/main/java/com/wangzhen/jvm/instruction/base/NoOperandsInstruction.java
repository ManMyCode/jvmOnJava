package com.wangzhen.jvm.instruction.base;

/**
 *  表示不需要涉及到操作数栈的指令
 */
public  abstract  class NoOperandsInstruction implements Instruction{
    @Override
    public void fetchOperands(ByteCodeReader codeReader) {

    }
}
