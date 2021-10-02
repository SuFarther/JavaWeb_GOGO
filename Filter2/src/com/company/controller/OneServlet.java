package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description 过滤器对拦截请求进行增强
 * @createTime 2021年10月02日 16:24:24
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        System.out.println("OneServlet请求的参数是:"+userName);
    }
}
