package com.theivanxu.algorithm;

/**
 * Created by theivanxu on 2018/6/5.
 */
public class MainTest {

    public static void main(String[] args) {
        long start = System.nanoTime();
        MathSqrt.SqrtByBisetion(65535);
        long end = System.nanoTime();
        System.out.println("bisection: " + (end - start));

        long start1 = System.nanoTime();
        Math.sqrt(65535);
        long end1 = System.nanoTime();
        System.out.println("system: " + (end1 - start1));
    }
}
