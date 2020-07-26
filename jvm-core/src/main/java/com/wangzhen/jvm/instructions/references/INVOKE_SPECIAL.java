package com.wangzhen.jvm.instructions.references;


import com.wangzhen.jvm.instructions.base.Index16Instruction;
import com.wangzhen.jvm.runtimeData.ZFrame;
import com.wangzhen.jvm.runtimeData.helap.MethodRef;
import com.wangzhen.jvm.runtimeData.helap.RuntimeConstantPool;
import com.wangzhen.jvm.runtimeData.helap.ZClass;
import com.wangzhen.jvm.runtimeData.helap.ZMethod;

/**
 * desc:调用无须动态绑定的实例方法(包括：构造函数,私有方法,通过super关键字调用的超类方法)
 * JVM特意为这种不需要动态绑定的方法创建的invokespecial,目的是为了加快方法调用(解析)的速度
 *
 * */
public class INVOKE_SPECIAL extends Index16Instruction {

    @Override
    public void execute(ZFrame frame) throws NoSuchMethodException {
       RuntimeConstantPool runtimeConstantPool = frame.getMethod().getClazz().getRuntimeConstantPool();
       MethodRef methodRef = (MethodRef) runtimeConstantPool.getRuntimeConstant(index).getValue();
       ZMethod method = methodRef.resolvedMethod();
       ZClass zClass = methodRef.resolvedClass();
       if("<init>".equals(method.getName())&&method.getClazz()!=zClass){
           throw new NoSuchMethodException(method.getName());
       }
       if(method.isStatic()){
           throw new IncompatibleClassChangeError(method.getName()+"is unstatic contenxt");
       }



    }
}
