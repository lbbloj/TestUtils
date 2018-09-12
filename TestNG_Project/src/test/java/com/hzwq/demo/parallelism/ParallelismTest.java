package com.hzwq.demo.parallelism;

import org.testng.annotations.Test;

public class ParallelismTest {


    @Test(threadPoolSize = 10,invocationCount = 2)
    public void test() {
        int i =1;
        while(i++<1000){
            System.out.println(Thread.currentThread().getName()+"::"+i);
        }
    }
}
