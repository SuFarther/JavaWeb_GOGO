package com.company.controller;
/**
 * @request 苏东坡
 * @ClassName ElServlet01
 * @company 公司
 * @version 1.0
 * @Description 演示传统的JSP对象
 * @createTime 2021年10月03日 18:26:26
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ElServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ServletContext application = request.getServletContext();
      HttpSession session = request.getSession();

      application.setAttribute("sid",10);
      session.setAttribute("sname","mike");
      request.setAttribute("home","新囤积");
      request.getRequestDispatcher("/el.jsp").forward(request,response);
    }
}
