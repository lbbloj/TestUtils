package com.hzwq.controller;

import com.hzwq.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

/**
 *@Author:Alan
 *
 * @Date: 2018-07-26  09:45:05
 *
 * junit与mockito的结合-注解的形式
 */

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest3OfJunit {

    @Mock
    private AccountDao accountDao;
    @Mock
    private HttpServletRequest request;

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
        assertEquals("登录失败", page, "/index");
    }

    /**
     *  模拟登录测试 期望抛出异常
     */
    @Test(expected = RuntimeException.class)
    public void testLoginException(){
        AccountController controller = new AccountController(accountDao);

        /*模拟参数接收*/
        Mockito.when(request.getParameter("username")).thenReturn(null);
        Mockito.when(request.getParameter("password")).thenReturn(null);

        /*模拟验证数据*/
        Mockito.when(accountDao.login("Alan", "123")).thenReturn(Boolean.TRUE);
        String page = controller.login(request);
        assertEquals("登录失败", page, "/index");
    }

}