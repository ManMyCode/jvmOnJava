package com.wangzhen.jvm.instructions;


import com.wangzhen.jvm.instructions.base.ByteCodeReader;
import com.wangzhen.jvm.instructions.base.Instruction;
import com.wangzhen.jvm.runtimeData.ZFrame;
import com.wangzhen.jvm.runtimeData.ZThread;


//
public class Interpreter {
    public static void loop(ZThread thread,byte[] byteCode){
        // 获得虚拟机栈上的 最顶层栈
        ZFrame frame = thread.popFrame();
        ByteCodeReader reader = new ByteCodeReader();
        while (true){
            //这第一次 frame 才刚初始化，获取的 pc 应该是默认值 0 吧。
            int pc = frame.getNextPC();
            thread.setPc(pc);
            //reset 方法，其实是在不断的设置 pc 的位置。
            reader.reset(byteCode,pc);
            int opCode = reader.readUint8();
            //解析指令,创建指令,然后根据不同的指令执行不同的操作
            Instruction instruction = InstructionFactory.createInstruction(opCode);
            instruction.fetchOperands(reader);
            frame.setNextPC(reader.getPc());
            instruction.execute(frame);
        }


    }
}
