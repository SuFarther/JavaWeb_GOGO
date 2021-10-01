package com.conpany.controller;
/**
 * @author 苏东坡
 * @ClassName TwoServlet
 * @company 公司
 * @version 1.0
 * @Description HttpServletRequest接口实现数据共享
 * @createTime 2021年10月01日 22:47:47
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer key1 = (Integer) request.getAttribute("key1");
        System.out.println(key1);
    }
}
