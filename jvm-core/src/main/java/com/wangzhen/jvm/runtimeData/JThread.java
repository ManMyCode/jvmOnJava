package com.wangzhen.jvm.runtimeData;

public class JThread {
    // 程序计数器
    int pc;
    //Stack 结构体（Java 虚拟机栈）的引用;
    JStack jstack;

    public JThread() {
        jstack = new JStack(1024);
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void pushFrame(JFrame frame) {
        jstack.push(frame);
    }

    public JFrame popFrame() {
        return jstack.pop();
    }

    public JFrame getCurrentFrame() {
        return jstack.top();
    }
}
