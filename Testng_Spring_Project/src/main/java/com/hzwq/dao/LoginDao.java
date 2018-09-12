package com.hzwq.dao;

import com.hzwq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @Author: Alan
 * @Date: 2018-07-31
 * dao
 */
@Repository
public class LoginDao  extends JdbcTemplate {

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }


    public User login(String username, String password) {

        String sql = "select * from \"user\" where username= ? and password = ?";
        return this.queryForObject(sql, new Object[]{username, password}, new BeanPropertyRowMapper<User>(User.class));
    }



}
