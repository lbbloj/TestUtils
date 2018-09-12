package com.hzwq.controller;

import com.hzwq.dao.AccountDao;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * @Author:Alan
 *
 * @Date: 2018-07-26  09:45:05
 *
 * testng与mockito的结合-注解的形式
 *
 * mockito进阶-参数接收
 */

public class AccountControllerTest4 {

    @Mock
    private AccountDao accountDao;
    @Mock
    private HttpServletRequest request;


    @BeforeMethod
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    /**
     *@todo  参数接收
     */
    @Test
    public void testLogin(){
        AccountController controller = new AccountController(accountDao);

        /*模拟参数接收1*/
//        Mockito.when(request.getParameter("username")).thenReturn("Alan");
//        Mockito.when(request.getParameter("password")).thenReturn("123");

        /*模拟参数接收2*/
//        Mockito.when(request.getParameter(Mockito.anyString())).thenReturn("Alan","123");

        /*模拟参数接收3*/
          when(request.getParameter(Mockito.anyString())).thenReturn("Alan").thenReturn("123");



        /*模拟验证数据*/
        when(accountDao.login("Alan", "123")).thenReturn(Boolean.TRUE);
        String page = controller.login(request);
        System.out.println("page:"+page);
        assertEquals("/index", page, "登录失败");
    }

    /**
     * @todo 参数传递
     */
    @Test
    public void testLogin2(){
        AccountController controller = new AccountController(accountDao);

        /*模拟参数接收1*/
//        Mockito.when(request.getParameter("username")).thenReturn("Alan");
//        Mockito.when(request.getParameter("password")).thenReturn("123");

        /*模拟参数接收2*/
//        Mockito.when(request.getParameter(Mockito.anyString())).thenReturn("Alan","123");

        /*模拟参数接收3*/
          when(request.getParameter(Mockito.anyString())).thenReturn("Alan").thenReturn("123");



        /*模拟验证数据*/
        when(accountDao.login("Alan", "123")).thenReturn(Boolean.TRUE);
        String page = controller.login(request);
        System.out.println("page:"+page);
        assertEquals("/index", page, "登录失败");
    }

    /**
     * @TOdo 校验对象
     */
    @Test
    public void verify_behaviour(){
        //模拟创建一个List对象
        List mock = mock(List.class);
        //使用mock的对象
        mock.add(1);
        mock.clear();
        //验证add(1)和clear()行为是否发生
        Mockito.verify(mock).add(1);
        Mockito.verify(mock).clear();
    }


    /**
     * @Todo 模拟我们所期望的结果
     */
    @Test
    public void when_thenReturn(){
        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        //预设当iterator调用next()时第一次返回hello，第n次都返回world
        when(iterator.next()).thenReturn("hello").thenReturn("world");
        //使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        //验证结果
        assertEquals("hello world world",result);
    }

    /**
     *  @TODO 模拟我们所期望的结果:抛出异常
     */
    @Test(expectedExceptions = IOException.class)
    public void when_thenThrow() throws IOException {
        OutputStream outputStream = mock(OutputStream.class);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        //预设当流关闭时抛出异常
        doThrow(new IOException()).when(outputStream).close();
        outputStream.close();
    }

    /**
     * @Todo 参数匹配
     */
    @Test
    public void with_arguments(){
        Comparable comparable = mock(Comparable.class);
        //预设根据不同的参数返回不同的结果
        when(comparable.compareTo("Test")).thenReturn(1);
        when(comparable.compareTo("Omg")).thenReturn(2);
        assertEquals(1, comparable.compareTo("Test"));
        assertEquals(2, comparable.compareTo("Omg"));
        //对于没有预设的情况会返回默认值
        assertEquals(0, comparable.compareTo("Not stub"));
    }

    /**
     *  @Todo 匹配任意参数
     */
    @Test
    public void with_unspecified_arguments(){
        List list = mock(List.class);
        //匹配任意参数
        when(list.get(anyInt())).thenReturn(1).thenReturn(2).thenReturn(3);
        //限定参数
        when(list.contains(argThat(new IsValid()))).thenReturn(true);
        /*注意:对于thenReturn()的返回值,是方法依次执行所的到的结果,如下:*/
        assertEquals(1,list.get(0),"期望值与实际值不匹配");
        assertEquals(2,list.get(1),"期望值与实际值不匹配");
        assertEquals(3,list.get(2),"期望值与实际值不匹配");
        assertTrue(list.contains(1));
        assertTrue(list.contains(9));
    }

    private class IsValid implements ArgumentMatcher<Integer> {

        public boolean matches(Integer i) {
            return i<10;
        }
    }


/**
 *  @Todo void Method
 */
@Test
public void voidMethod(){
    TempTestClass mock = mock(TempTestClass.class);
    //匹配任意参数

    mock.say("Hello,mockito!");
}

    /**
     *  @Todo void Method
     */
    @Test
    public void voidMethod3(){
        TempTestClass mock = spy(TempTestClass.class);
        //匹配任意参数
        doNothing().doCallRealMethod().when(mock).say("");
        mock.say("Hello,mockito!");
    }


}