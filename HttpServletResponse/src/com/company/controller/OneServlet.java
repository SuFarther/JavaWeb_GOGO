package com.company.controller;
/**
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description HttpServletResponse接口1
 * 1、介绍
 * 1）HttpServletResponse接口来自于Servlet规范中,在Tomcat中存在servlet-api.jar
 * 2) HttpServletResponse接口实现类由Http服务器负责提供
 * 3) HttpServletResponse接口负责将doGet/doPos方法执行结果写入到【响应体】交给服务器
 * 4）开发人员习惯性于将HttpServletResponse接口修饰对象称为[相应对象]
 *
 * 2、主要功能:
 *    1) 将执行结果以二进制形式写入到[响应体]
 *    2）设置响应头中[content-type)属性值,从而控制浏览器使用，对应编译器将响应体二进制数据编译为【文字,图片，视频，命令】
 *
 *  3、设置响应头中到[location]属性,将一个请求地址赋值给location，从而控制浏览器向服务器发送请求
 *
 *
 * @createTime 2021年09月24日 21:10:10
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 苏东坡
 */
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 响应对象写入响应体
         *     1.通过响应对象,向Tomcat索要输出语
         *     2.通过输出流,将执行结果以二进制写入到响应体
         */
        String result = "HelloWorld!";
        PrintWriter out = response.getWriter();
        out.write(result);
    }
}
