package com.hzwq.testng;

import com.hzwq.controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @Author: Alan
 * @Date: 2018-07-31
 * <p>
 * 测试类
 */

@ContextConfiguration(locations = "classpath*:*.xml")
public class MyTest2 extends MockUtils {

  //  private MockMvc mockMvc;

    //@InjectMocks
    @Autowired
    private LoginController loginController;

    @BeforeMethod
    public void init() {

//        mockMvc= MockMvcBuilders.standaloneSetup(loginController).build();
    }



    @Test
    public void test0(){
        System.out.println(1234);

    }

}
