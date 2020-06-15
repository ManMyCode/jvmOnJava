package com.wangzhen.jvm.attribute;

import com.wangzhen.jvm.classPackage.ClassReader;
import com.wangzhen.jvm.utils.ByteUtils;

/**
 * {
 *     u2 start_pc;
 *     u2 end_pc;
 *     u2 handler_pc;
 *     u2 catch_type;
 * }
 */
public class ExceptionTable {
    int startPc;
    int endPc;
    int handlerPc;
    int catchType;

    public  ExceptionTable (ClassReader classReader){
        startPc = ByteUtils.bytesToInt(classReader.readNByte(2));
        endPc = ByteUtils.bytesToInt(classReader.readNByte(2));
        handlerPc = ByteUtils.bytesToInt(classReader.readNByte(2));
        catchType = ByteUtils.bytesToInt(classReader.readNByte(2));

    }

    public int getStartPc() {
        return startPc;
    }

    public void setStartPc(int startPc) {
        this.startPc = startPc;
    }

    public int getEndPc() {
        return endPc;
    }

    public void setEndPc(int endPc) {
        this.endPc = endPc;
    }

    public int getHandlerPc() {
        return handlerPc;
    }

    public void setHandlerPc(int handlerPc) {
        this.handlerPc = handlerPc;
    }

    public int getCatchType() {
        return catchType;
    }

    public void setCatchType(int catchType) {
        this.catchType = catchType;
    }
}
