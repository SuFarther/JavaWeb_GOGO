package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName 在全局作用域对象更新共享数据
 * @company 公司
 * @version 1.0
 * @Description TODO
 * @createTime 2021年10月02日 04:08:08
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        application.setAttribute("key1",100);
        application.setAttribute("key2",200);
        application.removeAttribute("key1");
    }
}
