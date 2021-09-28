package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName TwoServlet
 * @company 公司
 * @version 1.0
 * @Description 请求转发方案
 * @createTime 2021年09月28日 22:04:04
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TwoServlet实施割包皮手术");
    }
}
