package com.hzwq.demo.groups;

import org.testng.annotations.Test;

/**
 * @Author: Alan
 * @Date: 2018-07-30  15:03:57
 *
 * 分组测试
 */
public class GroupTest {


    @Test(groups = "g1")
    public void test01(){
        System.out.println("g1-1");
    }
    @Test(groups = "g1")
    public void test02(){
        System.out.println("g1-2");
    }


    @Test(groups = "g2")
    public void test03(){
        System.out.println("g2-1");
    }
    @Test(groups = "g2")
    public void test04(){
        System.out.println("g2-2");
    }

}
