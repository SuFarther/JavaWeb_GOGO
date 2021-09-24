package com.company.controller;
/**
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description HttpServletRequest接口1
 * 1）HttpServletRequest接口来自于Servlet规范中,在Tomcat中存在servlet-api.jar
 * 2) HttpServletRequest接口实现类由Http服务器负责提供
 * 3) HttpServletRequest接口负责将doGet/doPos方法执行结果写入到【响应体】交给服务器
 * 4）开发人员习惯性于将HttpServletRequest接口修饰对象称为[请求对象]
 *
 * 2.作用:
 * 1) 可以读取Http请求协议包中[请求头]信息
 * 2）可以读取保有在Http请求协议包中[请求头]或则【请求头】中请求参数信息
 * 3）可以代替浏览器向Http服务器申请资源文件调用
 *
 *
 * @createTime 2021年09月24日 22:31:31
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
        //通过请求对象,请求[请求行]中[url]信息
        String url = request.getRequestURL().toString();
        //通过请求对象,读取[请求行]中的[method]信息
        String method = request.getMethod();
        //通过请求对象,读取[请求行]中的uri信息
        String uri = request.getRequestURI();
        System.out.println("URL:"+url);
        System.out.println("URI:"+uri);
        System.out.println("method:"+method);
    }
}
