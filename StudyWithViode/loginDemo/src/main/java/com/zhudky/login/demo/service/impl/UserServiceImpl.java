package com.zhudky.login.demo.service.impl;

import com.zhudky.login.demo.dao.UserDao;
import com.zhudky.login.demo.dao.impl.UserDaoImpl;
import com.zhudky.login.demo.entity.User;
import com.zhudky.login.demo.service.UserService;

/**
 * Created by zhu on 2018/8/19.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    public User login(String id, String pwd) {
        return userDao.login(id,pwd);
    }
}
