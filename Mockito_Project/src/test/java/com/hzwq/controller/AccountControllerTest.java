package com.hzwq.controller;

import com.hzwq.dao.AccountDao;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;

public class AccountControllerTest {

    private AccountDao accountDao;

    private HttpServletRequest request;


    @BeforeMethod
    public void setUp(){
        accountDao = Mockito.mock(AccountDao.class);
        request = Mockito.mock(HttpServletRequest.class);
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
        String login = controller.login(request);

        Assert.assertEquals("/index",login,"登录失败!");
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

        Assert.assertEquals("/index",login,"登录失败!");
    }

}