package com.company.controller;
/**
 * @ClassName UserFindServlet
 * @company 公司
 * @version 1.0
 * @Description 用户查询界面
 * @createTime 2021年09月25日 22:13:13
 */

import com.company.dao.UserDao;
import com.company.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 苏东坡
 */
public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao  dao = new UserDao();
        PrintWriter out;

        //提供服务
        //1、【调用Dao】将查询命令推送到数据库服务器,得到所有用户信息[list]
        List<Users> usersList = dao.findAll();
        //2、【调用响应对象】将用户信息结合<table>标签命令以二进制写入到响应体中
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户名称</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        out.print("<td>操作</td>");
        out.print("<tr/>");
        for (Users users : usersList){
            out.print("<tr>");
            out.print("<td>"+users.getUserId()+"</td>");
            out.print("<td>"+users.getUserName()+"</td>");
            out.print("<td>"+users.getPassword()+"</td>");
            out.print("<td>"+users.getSex()+"</td>");
            out.print("<td>"+users.getEmail()+"</td>");
            out.print("<td><a href='/Online/user/delete?userId="+users.getUserId()+"'>删除用户</a><td>");
            out.print("<tr/>");
        }
        out.print("<table/>");
    }

}
