package com.hzwq.controller;

import com.hzwq.dao.AccountDao;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:Alan
 *
 * @Date: 2018-07-26  08:48:12
 * 用户访问控制层
 */
public class AccountController {
    private AccountDao accountDao;

    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     *  用户登录操作
     * @param req  HttpServletRequest对象
     */
    public String login(HttpServletRequest req){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username==null||password==null) {
            throw new RuntimeException("接收参数为null");
        }

        boolean volid = accountDao.login(username,password);
        return volid ? "/index" : "/login";
    }

}
