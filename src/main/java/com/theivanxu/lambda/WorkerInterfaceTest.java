package com.theivanxu.lambda;

/**
 * Created by xushaonan on 2017/11/28.
 **/
public class WorkerInterfaceTest
{
    public static void excute(WorkerInterface worker){
        worker.doSomeWork();
    }

    public static void main(String[] args) {
        //invoke doSomeWork using anonymous class
        excute(new WorkerInterface() {
            @Override
            public void doSomeWork() {
                System.out.println("Worker invoked using anonymous class");
            }
        });

        excute( () -> System.out.println("Worker invoked using lambda function"));
    }
}
