package com.wangzhen.jvm.runtimeData.helap;

import com.wangzhen.jvm.runtimeData.Slots;

public class ZObject {
    //存放一个class的成员,用来调用类的方法,静态成员变量
    private ZClass clazz;
    //存放的是非静态成员变量,包含父类+ 自己的；或者存放数组
    private Object data;
    // 该Object不仅作为普通对象的一个存在,同时也作为每个Class结构对应的object,该Class对象需要的额外信息保存在extra中
    // 最简单的其可以用来记录类对象对应的Class结构体指针;（目前来看只有元类对象才会设置该 extra 字段）
    public Object extra;

    public ZObject(ZClass clazz) {
        this.clazz = clazz;
        data = new Slots(clazz.instanceSlotCount);
    }

    public ZObject(ZClass clazz, Object data, Object extra) {
        this.clazz = clazz;
        this.data = data;
        this.extra = extra;
    }

    public ZClass getClazz() {
        return clazz;
    }

    public Object getData() {
        return data;
    }

    public Object getExtra() {
        return extra;
    }

    public Slots getFields(){
        return (Slots) data;
    }

    //为数组添加一些特有的方法：
    public byte[] getBytes() {
        return (byte[]) data;
    }

    public char[] getChars() {
        return (char[]) data;
    }

    public short[] getShorts() {
        return (short[]) data;
    }

    public int[] getInts() {
        return (int[]) data;
    }

    public long[] getLongs() {
        return (long[]) data;
    }

    public float[] getFloats() {
        return (float[]) data;
    }

    public double[] getDoubles() {
        return (double[]) data;
    }

    public ZObject[] getRefs() {
        return (ZObject[]) data;
    }
}
