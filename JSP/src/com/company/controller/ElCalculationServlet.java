package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName ELCalculationServlet
 * @company 公司
 * @version 1.0
 * @Description TODO
 * @createTime 2021年10月03日 19:40:40
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ElCalculationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setAttribute("key1","100");
       request.setAttribute("key2",18);
       request.getRequestDispatcher("/el_calculation.jsp").forward(request,response);
    }
}
