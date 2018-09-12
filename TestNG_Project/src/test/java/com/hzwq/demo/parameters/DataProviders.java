package com.hzwq.demo.parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author: Alan
 * @Date: 2018-07-30
 *
 * DataProviders参数设置
 */
public class DataProviders {

    @Test(dataProvider = "myname")
    public void test(String name,int age){

        System.out.println(name+"::"+age);
    }


    @DataProvider(name = "myname")
    public Object[][] getName(){

        return new Object[][]{{"张三",18},{"李四",22}};
    }
}
