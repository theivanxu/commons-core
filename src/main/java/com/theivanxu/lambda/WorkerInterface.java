package com.theivanxu.lambda;

/**
 * Created by xushaonan on 2017/11/28.
 **/
@FunctionalInterface
public interface WorkerInterface
{

    void doSomeWork();

    static void printResult(){
        System.out.println("Hello, Ivan!");
    }

}
