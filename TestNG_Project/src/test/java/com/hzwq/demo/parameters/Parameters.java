package com.hzwq.demo.parameters;

import org.testng.annotations.Test;

/**
 * @Author: Alan
 * @Date: 2018-07-30  15:58:06
 *
 *  参数供应
 *  参数注入与参数驱动
 */
public class Parameters {

    @Test
    @org.testng.annotations.Parameters({"testData1"})
    public void test(String testData){
        System.out.println("This is :"+testData);
    }

    @Test
    @org.testng.annotations.Parameters({"name","age"})
    public void test2(String name,int age){
        System.out.println("name:"+name);
        System.out.println("age:"+age);
    }
}
