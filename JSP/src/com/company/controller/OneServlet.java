package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description TODO
 * @createTime 2021年10月03日 02:12:12
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        String value = (String) application.getAttribute("key1");
        System.out.println("value ="+value);
    }
}
