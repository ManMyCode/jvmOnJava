package com.wangzhen.jvm.test;

import java.math.BigDecimal;

public class Math {
    public static void main(String[] args) {
        double f1 = 0.05;
        double f2 = 0.01;
        System.out.println(f1+f2);
        BigDecimal f3 = new BigDecimal(String.valueOf(f1));
        BigDecimal f4 = new BigDecimal(String.valueOf(f2));
        BigDecimal f5 = f3.add(f4);
        f3.doubleValue();
//        System.out.println(f5.toBigInteger());
    }
}
