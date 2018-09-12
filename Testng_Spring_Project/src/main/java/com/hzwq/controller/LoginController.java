package com.hzwq.controller;

import com.hzwq.pojo.User;
import com.hzwq.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Alan
 * @Date: 2018-07-31
 *
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    /**
     *  用户登录
     */
    @RequestMapping("/login")
  public String login(String username, String password){

      if (StringUtils.isEmpty(username)|| StringUtils.isEmpty(password)){
          return "/login";
      }

      User user = loginService.login(username, password);


      return user==null?"/login":"/index";
  }
}
