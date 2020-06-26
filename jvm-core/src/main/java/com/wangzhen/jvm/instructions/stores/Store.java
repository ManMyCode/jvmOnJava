package com.wangzhen.jvm.instructions.stores;

import com.wangzhen.jvm.runtimeData.JFrame;
import com.wangzhen.jvm.runtimeData.helap.JObject;

public class Store {
    public static void astore(JFrame frame, int index) {
        JObject ref = frame.getOperandStack().popRef();
        frame.getLocalVars().setRef(index, ref);
    }

    public static void istore(JFrame frame, int index) {
        int val = frame.getOperandStack().popInt();
        frame.getLocalVars().setInt(index, val);
    }

    public static void lstore(JFrame frame, int index) {
        long val = frame.getOperandStack().popLong();
        frame.getLocalVars().setLong(index, val);
    }

    public static void fstore(JFrame frame, int index) {
        float val = frame.getOperandStack().popFLoat();
        frame.getLocalVars().setFloat(index, val);
    }

    public static void dstote(JFrame frame, int index) {
        double val = frame.getOperandStack().popDouble();
        frame.getLocalVars().setDouble(index, val);
    }

    //用在 store 数组元素时，检测数组是否为 null
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
