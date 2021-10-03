package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName StudentServlet
 * @company 公司
 * @version 1.0
 * @Description TODO
 * @createTime 2021年10月03日 08:43:43
 */

import com.company.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student1 = new Student("13","张三");
        Student student2 = new Student("14","李四");
        List<Student> studentList = new ArrayList();
        studentList.add(student1);
        studentList.add(student2);

        //将处理结果添加到请求作用域对象
        request.setAttribute("key",studentList);

        //请求转发方案,向Tomcat申请调用student_show.jsp，同时将request与response通过Tomcat交给student_show.jsp
        request.getRequestDispatcher("/student_show.jsp").forward(request,response);
    }
}
