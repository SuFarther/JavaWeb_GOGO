package com.company.controller;
/**
 * @author
 * @ClassName 试题修改
 * @company 公司
 * @version 1.0
 * @Description 试题修改
 * @createTime 2021年10月03日 17:42:42
 */

import com.company.dao.QuestionDao;
import com.company.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class QuestionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title, optionA, optionB, optionC, optionD, answer, questionId;
        QuestionDao dao = new QuestionDao();
        Question question = null;
        int result = 0;
        //1、调用请求对象获取请求头参数信息
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        questionId = request.getParameter("questionId");
        question = new Question(Integer.valueOf(questionId), title, optionA, optionB, optionC, optionD, answer);
        result = dao.update(question);
        //3、通过请求转发,向Tomcat索要question_info.jsp将处理结果写入到响应体
        if (result == 1) {
            request.setAttribute("info", "试题更新改成功");
        } else {
            request.setAttribute("info", "试题更新成功");
        }
        request.getRequestDispatcher("/question_info.jsp").forward(request, response);
    }

}
