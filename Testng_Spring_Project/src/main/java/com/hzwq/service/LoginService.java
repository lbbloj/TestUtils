package com.hzwq.service;

import com.hzwq.dao.LoginDao;
import com.hzwq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;
    public User login(String username, String password) {

       return  loginDao.login(username,password);
    }
}
