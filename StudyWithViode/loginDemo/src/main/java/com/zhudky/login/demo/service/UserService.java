package com.zhudky.login.demo.service;

import com.zhudky.login.demo.entity.User;

/**
 * Created by zhu on 2018/8/19.
 */
public interface UserService {

    public User login(String id, String pwd);
}
