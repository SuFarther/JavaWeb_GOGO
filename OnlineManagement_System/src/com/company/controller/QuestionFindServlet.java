package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName QuestionFindServlet
 * @company 公司
 * @version 1.0
 * @Description 试题查询
 * @createTime 2021年10月03日 15:09:09
 */

import com.company.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        //1、调用DAO推送查询命令得到偶有到试题
        List questionsList = dao.findAll();
        //2、将得到试题添加到请求作用域对象作为共享数据
        request.setAttribute("key", questionsList);
        //3、请求转发向tomcat调用questions.jsp将结果与html标签吸入到响应体
        request.getRequestDispatcher("/question_list.jsp").forward(request, response);
    }
}
