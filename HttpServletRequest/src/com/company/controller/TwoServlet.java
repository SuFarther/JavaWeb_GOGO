package com.company.controller;
/**
 * @ClassName TwoServlet
 * @company 公司
 * @version 1.0
 * @Description HttpServletRequest接口1
 * @createTime 2021年09月24日 22:46:46
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 苏东坡
 */
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1、通过请求对象获取[请求头]中[所有请求参数]request.getParameterNames();将所有请求参数名称保存到一个枚举对象进行返回
         *
         */
        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameterName = (String) parameterNames.nextElement();
            //通过请求对象读取指定到请求参数值
            String value = request.getParameter(parameterName);
            System.out.println("请求参数名: "+parameterName+",请求参数值:"+value);
        }
    }
}
