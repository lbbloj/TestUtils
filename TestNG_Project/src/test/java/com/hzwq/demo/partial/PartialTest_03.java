package com.hzwq.demo.partial;

import org.testng.annotations.Test;

/**
 * @Author: Alan
 * @Date: 2018-07-30  14:14:35
 *
 * 局部测试组
 *
 * my-group 包含one-group 和two-group
 *
 */
@Test(groups = {"my-group"})
public class PartialTest_03 {

    @Test(groups = {"one-group"})
    public void testMethod01(){

        System.out.println("This is a Method Test01!!!");

    }

    @Test(groups = {"two-group"})
    public void testMethod02(){

        System.out.println("This is a Method Test02!!!");

    }
}
