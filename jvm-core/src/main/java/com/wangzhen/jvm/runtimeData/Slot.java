package com.wangzhen.jvm.runtimeData;

import com.wangzhen.jvm.runtimeData.helap.JObject;

public class Slot {
    public int num;
    public JObject ref;

    public Slot() {}

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public JObject getRef() {
        return ref;
    }

    public void setRef(JObject ref) {
        this.ref = ref;
    }
}
