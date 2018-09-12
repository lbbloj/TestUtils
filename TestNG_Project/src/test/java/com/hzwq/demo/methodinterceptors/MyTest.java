package com.hzwq.demo.methodinterceptors;

import org.testng.*;

public class MyTest {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { MethodInterceptors.class });
        testng.addListener(tla);
        testng.setMethodInterceptor(new MyInterceptor());
        testng.run();
    }
}
