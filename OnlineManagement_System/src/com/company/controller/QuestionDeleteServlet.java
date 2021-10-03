package com.company.controller;
/**
 * @author 试题删除delete
 * @ClassName ${NAME}
 * @company 公司
 * @version 1.0
 * @Description TODO
 * @createTime 2021年10月03日 16:03:03
 */

import com.company.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId = null;
        QuestionDao dao = new QuestionDao();
        questionId = request.getParameter("questionId");
        int result = 0;
        result = dao.delete(questionId);
        if(result == 1){
            request.setAttribute("delete_info","试题删除成功");
        }else {
            request.setAttribute("delete_info","试题删除失败");
        }
        request.getRequestDispatcher("/questionDelete_info.jsp").forward(request,response);
    }
}
