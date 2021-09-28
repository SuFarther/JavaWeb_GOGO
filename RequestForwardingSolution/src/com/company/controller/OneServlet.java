package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description 请求转发方案
 * 十一。请求转发解决方案:
 *
 *              1.原理：   用户第一次通过手动方式要求浏览器访问OneServlet。
 * 	                OneServlet工作完毕后，通过当前的请求对象代替浏览器
 * 			向Tomcat发送请求，申请调用TwoServlet。
 * 			Tomcat在接收到这个请求之后，自动调用TwoServlet来
 * 			完成剩余任务
 *
 *              2.实现命令： 请求对象代替浏览器向Tomcat发送请求
 *
 * 	                 //1.通过当前请求对象生成资源文件申请报告对象
 * 			   RequestDispatcher  report = request.getRequestDispatcher("/资源文件名");一定要以"/"为开头
 *                          //2.将报告对象发送给Tomcat
 * 			   report.forward(当前请求对象，当前响应对象)
 *
 *              3.优点：
 *
 * 	                 1）无论本次请求涉及到多少个Servlet,用户只需要手动通过浏览器发送一次请求
 *
 * 			 2) Servlet之间调用发生在服务端计算机上，节省服务端与浏览器之间往返次数
 * 			    增加处理服务速度
 *
 *              4.特征:
 *
 * 	                1)请求次数
 *
 * 			 在请求转发过程中，浏览器只发送一次请求
 *
 *                         2）请求地址
 * 			只能向Tomcat服务器申请调用当前网站下资源文件地址
 * 			request.getRequestDispathcer("/资源文件名") ****不要写网站名****
 *
 * 			3）请求方式
 *
 * 			在请求转发过程中，浏览器只发送一个了个Http请求协议包。
 * 			参与本次请求的所有Servlet共享同一个请求协议包，因此
 * 			这些Servlet接收的请求方式与浏览器发送的请求方式保持一致
 *
 *
 * @createTime 2021年09月28日 22:04:04
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet实施麻醉");
        //1、通过当前对象生成资源文件申请报告
        RequestDispatcher report = request.getRequestDispatcher("/two");
        //2、将报告对象发送给Tomcat
        report.forward(request,response);
    }

}
