package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName QuestionRandServlet
 * @company 公司
 * @version 1.0
 * @Description 参加考试
 * @createTime 2021年10月03日 22:18:18
 */

import com.company.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        List questionList = null;
        HttpSession session = request.getSession(false);
        //1.调用Dao对象随机从question表拿出4道题目
        questionList=dao.findRand();
        //2.将4道题目添加到request作为共享数据
        session.setAttribute("key", questionList);
        //3.请求转发，申请掉exam.jsp将4道题目写入到响应体
        request.getRequestDispatcher("/exam.jsp").forward(request, response);
    }
}
