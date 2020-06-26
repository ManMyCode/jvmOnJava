package com.wangzhen.jvm.runtimeData;

public class ZThread {
    // 程序计数器
    int pc;
    //Stack 结构体（Java 虚拟机栈）的引用;
    ZStack jstack;

    public ZThread() {
        jstack = new ZStack(1024);
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void pushFrame(ZFrame frame) {
        jstack.push(frame);
    }

    public ZFrame popFrame() {
        return jstack.pop();
    }

    public ZFrame getCurrentFrame() {
        return jstack.top();
    }
}
