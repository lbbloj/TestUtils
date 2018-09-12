package com.hzwq.demo.dependencies;

import org.testng.annotations.Test;

/**
 * @Author: Alan
 * @Date: 2018-07-30  14:38:20
 *
 * 依赖测试
 */
public class DependenciesTest {

    @Test(groups = "before",dependsOnGroups = "before2")
    public void testMethod1(){
        System.out.println("This is DependenciesTest1!!!");
    }
    @Test(groups = "before")
    public void testMethod2(){
        System.out.println("This is DependenciesTest2!!!");
    }
    @Test(groups = "before2")
    public void testMethod3(){
        System.out.println("This is DependenciesTest3!!!");
    }




    /**
     *  方法级别依赖
     */
    @Test(dependsOnMethods = "testMethod1")
    public void test1(){
        System.out.println("测试成功1");

    }

    /**
     *  组级别依赖
     */
    @Test(dependsOnGroups = "before",groups = "test")
    public void test2(){
        System.out.println("测试成功2");

    }

    @Test
    public void test3(){
        System.out.println("测试成功3");

    }

}
