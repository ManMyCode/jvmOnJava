package com.wangzhen.jvm.instruction.loads;

import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.helap.JObject;
import jdk.nashorn.internal.scripts.JO;

public class Load {
    public static void aLoad(JFrame frame,int index){
        JObject object =frame.getLocalVars().getRef(index);
        frame.getOperandStack().pushRef(object);
    }
    public static void dLoad(JFrame frame,int index){
        double d =frame.getLocalVars().getDouble(index);
        frame.getOperandStack().pushDouble(d);

    }
    public static void fLoad(JFrame frame,int index){
        float f =frame.getLocalVars().getFloat(index);
        frame.getOperandStack().pushFLoat(f);
    }
    public static void iLoad(JFrame frame,int index){
        int  i =frame.getLocalVars().getInt(index);
        frame.getOperandStack().pushInt(i);
    }

    public static void lLoad(JFrame frame,int index){
        long  l =frame.getLocalVars().getLong(index);
        frame.getOperandStack().pushLong(l);
    }

    //用在 load 数组元素时，检测数组是否为 null
    public static void checkNotNull(JObject arrRef) {
        if (arrRef == null) {
            throw new NullPointerException();
        }
    }

    public static void checkIndex(int count, int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("index: " + index + " array's count: " + count);
        }
    }

}
