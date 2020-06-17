package com.wangzhen.jvm.runtimeData;

import com.wangzhen.jvm.runtimeData.helap.JMethod;

public class JFrame {
    LocalVars localVars;    //局部变量表的引用;
    OperandStack operandStack;  //操作数栈的引用;
    JThread thread;         //当前栈帧所在的线程;
    JMethod method;
    //frame中并不改变PC的值,其PC值是由ByteReader读取字节码不断改变的
    int nextPC;

    public JFrame(JThread thread,int maxLocal,int maxStack) {
        localVars = new LocalVars(maxLocal);
        operandStack = new OperandStack(maxStack);
        this.thread = thread;
    }

    public JFrame(JThread thread, JMethod method) {
        this.thread = thread;
        this.method = method;
    }

    public LocalVars getLocalVars() {
        return localVars;
    }

    public void setLocalVars(LocalVars localVars) {
        this.localVars = localVars;
    }

    public OperandStack getOperandStack() {
        return operandStack;
    }

    public void setOperandStack(OperandStack operandStack) {
        this.operandStack = operandStack;
    }

    public JThread getThread() {
        return thread;
    }

    public void setThread(JThread thread) {
        this.thread = thread;
    }

    public JMethod getMethod() {
        return method;
    }

    public void setMethod(JMethod method) {
        this.method = method;
    }

    public int getNextPC() {
        return nextPC;
    }

    public void setNextPC(int nextPC) {
        this.nextPC = nextPC;
    }
}
