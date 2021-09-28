package com.company.controller;
/**
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description 多个Servlet之间数据共享实现方案
 *
 * 十二。多个Servlet之间数据共享实现方案：
 *
 *                1.数据共享：OneServlet工作完毕后，将产生数据交给TwoServlet来使用
 *
 * 	       2.Servlet规范中提供四种数据共享方案
 *
 * 	         1.ServletContext接口
 *
 * 		 2.Cookie类
 *
 * 		 3.HttpSession接口
 *
 * 		 4.HttpServletRequest接口
 *
 * @createTime 2021年09月28日 22:17:17
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 苏东坡
 */
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过【请求对象】向Tomcat索要当前网站中【全局作用域对象】
        ServletContext application = request.getServletContext();
        //2.将数据添加到全局作用域对象作为【共享数据】
        application.setAttribute("key1",100);
    }

}
