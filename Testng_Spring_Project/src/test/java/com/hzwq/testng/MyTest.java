package com.hzwq.testng;

import com.hzwq.controller.LoginController;
import com.hzwq.dao.LoginDao;
import com.hzwq.pojo.User;
import com.hzwq.service.LoginService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @Author: Alan
 * @Date: 2018-07-31
 * <p>
 * 测试类
 */

@ContextConfiguration(locations = "classpath*:*.xml")
public class MyTest extends MockUtils {

    private MockMvc mockMvc;

    @InjectMocks
    private LoginController loginController;

    @InjectMocks
    private LoginService loginService;

    @Mock
    private LoginDao loginDao;

    public MockMvc getMockMvc() {
        return mockMvc;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public LoginDao getLoginDao() {
        return loginDao;
    }

    @BeforeMethod
    public void init() {
        mockMvc= MockMvcBuilders.standaloneSetup(loginController).build();
    }

    /**
     *  测试访问
     */
    @Test
    public void test() throws Exception {

        Mockito.when(loginDao.login("alan","123")).thenReturn(new User());


        /*将控制器和服务层的字段注入为mock字段*/
//        ReflectionTestUtils.setField(loginController, "loginService", loginService);
//        ReflectionTestUtils.setField(loginService, "loginDao", loginDao);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/login?username=alan&password=123"))
                .andExpect(MockMvcResultMatchers.view().name("/index")).andReturn();

    }




}
