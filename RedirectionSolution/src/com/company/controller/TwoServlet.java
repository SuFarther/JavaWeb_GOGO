package com.company.controller;
/**
 * @author
 * @ClassName TwoServlet
 * @company 公司
 * @version 1.0
 * @Description 重定向解决方案
 * @createTime 2021年09月28日 21:45:45
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TwoServlet负责炒韭菜");
    }
}
