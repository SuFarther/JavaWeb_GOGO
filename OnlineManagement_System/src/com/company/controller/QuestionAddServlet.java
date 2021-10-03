package com.company.controller;
/**
 *  @author 苏东坡
 * @ClassName QuestionAddServlet
 * @company 公司
 * @version 1.0
 * @Description 自动出试卷
 * @createTime 2021年10月03日 13:46:46
 */

import com.company.dao.QuestionDao;
import com.company.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class QuestionAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String title,optionA,optionB,optionC,optionD,answer;
       QuestionDao dao = new QuestionDao();
       Question question = null;
       int  result = 0;
        //调用请求对象读取请求信息,得到新增信息内容
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");

        //2、调用Dao对象将INSERT命令提送到数据库,并得到处理结果
        question = new Question(null,title,optionA,optionB,optionC,optionD,answer);
        result = dao.add(question,request);
        //3、通过请求转发,向Tomcat索要question_info.jsp将处理结果写入到响应体
        if(result ==1){
            request.setAttribute("info","试题添加成功");
        }else{
            request.setAttribute("info","试题添加失败");
        }
        request.getRequestDispatcher("/question_info.jsp").forward(request,response);
    }

}
