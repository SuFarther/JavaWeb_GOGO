package com.company.controller;
/**
 * @author  苏东坡
 * @ClassName LoginServlet
 * @company 公司
 * @version 1.0
 * @Description 用户登陆
 *
 *
 * @createTime 2021年09月26日 21:36:36
 */

import com.company.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  userName,password;
        UserDao dao = new UserDao();
        int result = 0;
        PrintWriter out = null;

        //1、调用请求对象对请求体使用utf-8字符集进行重新编译
        request.setCharacterEncoding("utf-8");

        //2、调用请求对象拉取请求体参数信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");

        //3、调用Dao将查询验证信息推送到数据库服务器上
        result = dao.login(userName,password);

        //4、调用响应对象,根据验证结果将不同资源文件地址写入到响应头,交给浏览器
        out = response.getWriter();
        if (result == 1) {
            //用户存在
            //在判断来访用户身份合法后,通过请求对象向Tomcat申请为当前用户申请一个
            request.getSession();
            response.sendRedirect("/Online/index.html");
        } else {
            response.sendRedirect("/Online/login_error.html");
        }
    }
}
