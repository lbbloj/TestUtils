package com.hzwq.demo.expectedexceptions;

import org.testng.annotations.Test;

/**
 * @Author: Alan
 * @Date: 2018-07-30  15:16:40
 *
 * 期望测试出异常代码
 */
public class ExpectedExceptions {


    @Test(expectedExceptions = {NullPointerException.class})
    public void test(){

        throw new NullPointerException();
    }
}
