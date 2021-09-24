package com.company.controller;
/**
 * @ClassName FourServlet
 * @company 公司
 * @version 1.0
 * @Description HttpServletResponse接口对象
 * 浏览器在接收到响应包之后,如果发现响应头存在location属性
 * 自动通过地址向location指定网站发送请求sendRedirect方法远程控制浏览器请求行为[请求地址,请求方式,请求参数]
 * @createTime 2021年09月24日 22:12:12
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 苏东坡
 */
public class FourServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //通过响应对象,将地址赋值给响应头中location属性
            String result = "http://www.baidu.com";
            response.sendRedirect(result);
    }

}
