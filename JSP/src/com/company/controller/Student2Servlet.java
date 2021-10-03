package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName Student2Servlet
 * @company 公司
 * @version 1.0
 * @Description
 * @createTime 2021年10月03日 19:10:10
 */

import com.company.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Student2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student("18","lili");
        request.setAttribute("key",student);
        request.getRequestDispatcher("/student2.jsp").forward(request,response);
    }
}
