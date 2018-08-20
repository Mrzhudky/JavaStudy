package com.zhudky.login.demo.web.Controller;

import com.zhudky.login.demo.entity.User;
import com.zhudky.login.demo.service.UserService;
import com.zhudky.login.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhu on 2018/8/19.
 * 登录控制器
 */
public class LoginController extends HttpServlet {

    private UserService userService = new UserServiceImpl();


    /**
     * 只用于获取
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     * 用于提交数据，post请求实际上是两次，
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginId = req.getParameter("loginId");
        String longinPwd = req.getParameter("loginPwd");

        User user = userService.login(loginId,longinPwd);

        //登录失败的处理
        if(user == null){
            req.getRequestDispatcher("/fail.jsp").forward(req,resp);
        }
        //登录成功的处理
        else{
            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }
    }
}
