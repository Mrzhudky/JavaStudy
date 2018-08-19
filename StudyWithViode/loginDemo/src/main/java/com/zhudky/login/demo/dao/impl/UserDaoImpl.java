package com.zhudky.login.demo.dao.impl;

import com.zhudky.login.demo.dao.UserDao;
import com.zhudky.login.demo.entity.User;

/**
 * Created by zhu on 2018/8/19.
 */
public class UserDaoImpl implements UserDao {

    /**
     * 用户登录
     * @param id 登录ID
     * @param pwd 登录密码
     * @return String ：登录结果
     */
    public User login(String id, String pwd) {
        User user = null;

        // 先根据ID查询用户信息
        if("admin".equals(id) ){
            //再根据传入密码匹配，防注入的一种思想
            if("admin".equals(pwd)){
                user = new User();
                user.setLoginId("admin");
                user.setLoginPwd("admin");
                user.setUserName("zhu");
            }
        }
        return user;
    }
}
