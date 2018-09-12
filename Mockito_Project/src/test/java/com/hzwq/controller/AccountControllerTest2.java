package com.hzwq.controller;

import com.hzwq.dao.AccountDao;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:Alan
 *
 * @Date: 2018-07-26  09:45:05
 *
 * testng与mockito的结合-注解的形式
 */

public class AccountControllerTest2 {

    @Mock
    private AccountDao accountDao;
    @Mock
    private HttpServletRequest request;


    @BeforeMethod
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    /**
     *  模拟登录测试
     */
    @Test
    public void testLogin(){
        AccountController controller = new AccountController(accountDao);

        /*模拟参数接收*/
        Mockito.when(request.getParameter("username")).thenReturn("Alan");
        Mockito.when(request.getParameter("password")).thenReturn("123");

        /*模拟验证数据*/
        Mockito.when(accountDao.login("Alan", "123")).thenReturn(Boolean.TRUE);
        String page = controller.login(request);
        System.out.println("page:"+page);
        Assert.assertEquals("/index", page, "登录失败");
    }

    /**
     *  模拟登录测试 期望抛出异常
     */
    @Test(expectedExceptions = RuntimeException.class)
    public void testLoginException(){
        AccountController controller = new AccountController(accountDao);

        /*模拟参数接收*/
        Mockito.when(request.getParameter("username")).thenReturn(null);
        Mockito.when(request.getParameter("password")).thenReturn(null);

        /*模拟验证数据*/
        Mockito.when(accountDao.login("Alan", "123")).thenReturn(Boolean.TRUE);
        String login = controller.login(request);
        Assert.assertEquals("/login","登录失败!",login);
    }

}