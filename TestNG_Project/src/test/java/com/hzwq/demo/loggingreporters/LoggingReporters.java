package com.hzwq.demo.loggingreporters;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = {MyLogListener.class})
public class LoggingReporters {

    @Test
    public void test(){
        System.out.println("123456");
        System.out.println(2/0);
    }
}
