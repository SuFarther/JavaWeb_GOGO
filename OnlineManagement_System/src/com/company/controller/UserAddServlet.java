package com.company.controller;
/**
 * @ClassName UserAddServlet
 * @company 公司
 * @version 1.0
 * @Description 用户注册
 * @createTime 2021年09月25日 16:58:58
 */

import com.company.dao.UserDao;
import com.company.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author 苏东坡
 */
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、【调用请求对象】读取[请求头]参数信息
        String userName, password, sex, email;
        UserDao dao = new UserDao();
        Users user = null;
        int result = 0;
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        //2、【调用UserDao】将用户信息填充到INSERT命令并借助JDBC规范发送到数据库服务器
        user = new Users(null, userName, password, sex, email);
        Date startDate = new Date();
        result = dao.add(user,request);
        Date endDate = new Date();
        System.out.println("添加消耗时间 = "+(endDate.getTime() - startDate.getTime())+"毫秒");

        //3、【调用响应对象】将[处理结果]以二进制形式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (result == 1) {
            out.print("<font style='color:red;font-size:40'>用户信息注册成功!</font>");
        } else {
            out.print("<font style='color:red;font-size:40'>用户信息注册失败!</font>");
        }

        //Tomcat负责销毁[请求对象]和[响应对象]

        //Tomcat负责将Http响应协议包推送到发起请求的浏览器上

        //浏览器根据响应头content-type指定编译器对响应体二进制内容编辑

        //浏览器将编辑后结果在窗口中展示给用户【结束】
    }
}
