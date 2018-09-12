package com.hzwq.demo.timeout;

import org.testng.annotations.Test;

/**
 * @Author: Alan
 * @Date: 2018-07-30  15:21:39
 *
 * 超时异常
 */
public class TimeoutTest {


    @Test(timeOut = 1000)
    public void test(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
