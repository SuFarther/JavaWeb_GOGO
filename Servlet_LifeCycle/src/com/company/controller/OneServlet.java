package com.company.controller;
/**
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description Servlet生命周期
 * 在第一个用户访问时创建实例对象
 * 例如:  http://localhost:8080/servlet_lifecycle/one
 * @createTime 2021年09月23日 22:09:09
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 苏东坡
 */
public class OneServlet extends HttpServlet {

    public OneServlet(){
        System.out.println("OneServlet访问时创建实例对象");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet do run");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
