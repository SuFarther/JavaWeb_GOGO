package com.conpany.controller;
/**
 * @author 苏东坡
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description HttpServletRequest接口实现数据共享
 * 1.介绍：
 *
 * 	  1） 在同一个网站中，如果两个Servlet之间通过【请求转发】方式进行调用，
 * 		彼此之间共享同一个请求协议包。而一个请求协议包只对应一个请求对象
 * 		 因此servlet之间共享同一个请求对象，此时可以利用这个请求对象在两个
 * 		Servlet之间实现数据共享
 *
 *   2） 在请求对象实现Servlet之间数据共享功能时，开发人员将请求对象称为【请求作用域对象】
 *
 *  2.命令实现： OneServlet通过请求转发申请调用TwoServlet时，需要给TwoServlet提供共享数据
 * @createTime 2021年10月01日 22:46:46
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("key1",200);
        request.getRequestDispatcher("/two").forward(request,response);
    }
}
