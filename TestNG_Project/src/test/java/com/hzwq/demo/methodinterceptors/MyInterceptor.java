package com.hzwq.demo.methodinterceptors;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.List;
import java.util.ListIterator;

public class MyInterceptor implements IMethodInterceptor {
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        System.out.println("启动拦截器....");
        for (ListIterator<IMethodInstance> iterator = methods.listIterator(); iterator.hasNext(); ) {
            IMethodInstance next =  iterator.next();
            String methodName = next.getMethod().getMethodName();
            if ("test01".contains(methodName)) {
                iterator.remove();
            }
        }
            return methods;
    }
}
