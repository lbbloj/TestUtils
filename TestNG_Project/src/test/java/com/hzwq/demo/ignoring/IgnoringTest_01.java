package com.hzwq.demo.ignoring;

import org.testng.annotations.Test;

/**
 * @Author: Alan
 * @Date: 2018-07-30  14:32:39
 *
 * 忽略测试
 */
@Test
public class IgnoringTest_01 {


    @Test(enabled = false)
    public void test01(){
        System.out.println(01);
    }

    public void test02(){
        System.out.println(02);
    }

    public void test03(){
        System.out.println(03);
    }

    @Test(enabled = false)
    public void test04(){
        System.out.println(04);
    }


    public void test05(){
        System.out.println(05);
    }
}
