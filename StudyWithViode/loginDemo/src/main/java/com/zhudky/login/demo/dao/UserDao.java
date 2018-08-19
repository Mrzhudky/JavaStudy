package com.zhudky.login.demo.dao;

import com.zhudky.login.demo.entity.User;

/**
 * Created by zhu on 2018/8/19.
 *
 *  数据访问层
 */
public interface UserDao {
    public User login(String id, String pwd);

}
