package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description  Http状态码
 *  1.介绍:
 * 	            1)由三位数字组成的一个符号。
 * 		    2)Http服务器在推送响应包之前，根据本次请求处理情况
 * 		      将Http状态码写入到响应包中【状态行】上
 *
 *                     3)如果Http服务器针对本次请求，返回了对应的资源文件。
 * 		      通过Http状态码通知浏览器应该如何处理这个结果
 *
 * 		      如果Http服务器针对本次请求，无法返回对应的资源文件
 * 		      通过Http状态码向浏览器解释不能提供服务的原因
 * 	    2.分类：
 * 	            1）组成  100---599；分为5个大类
 * 		    2）1XX :
 * 		             最有特征 100; 通知浏览器本次返回的资源文件
 * 			     并不是一个独立的资源文件，需要浏览器在接收
 * 			     响应包之后，继续向Http服务器所要依赖的其他资源文件
 *
 *                     3) 2XX：
 * 		             最有特征200，通知浏览器本次返回的资源文件是一个
 * 			     完整独立资源文件，浏览器在接收到之后不需要所要
 * 			     其他关联文件
 *
 *                     4）3xx:
 * 		             最有特征302，通知浏览器本次返回的不是一个资源文件内容
 * 			     而是一个资源文件地址，需要浏览器根据这个地址自动发起
 * 			     请求来索要这个资源文件
 *
 * 			     response.sendRedirect("资源文件地址")写入到响应头中
 * 			     location
 * 			     而这个行为导致Tomcat将302状态码写入到状态行
 *
 *                     5）4XX:
 *
 * 		             404: 通知浏览器，由于在服务端没有定位到被访问的资源文件
 * 			          因此无法提供帮助
 *
 *                              405：通知浏览器，在服务端已经定位到被访问的资源文件（Servlet）
 * 			          但是这个Servlet对于浏览器采用的请求方式不能处理
 *                     6）5xx:
 *
 * 		             500:通知浏览器，在服务端已经定位到被访问的资源文件（Servlet）
 * 			         这个Servlet可以接收浏览器采用请求方式，但是Servlet在处理
 * 				 请求期间，由于Java异常导致处理失败
 *
 *  Tomcat在推送响应包前,看到响应体是空,但是响应头location存放了一个地址
 *  此时Tomcat将302状态码写入到状态码
 *  在浏览器接收到响应包之后,因为302状态码,浏览器不会读取响应体内容,自动根据响应头中的location的地址发送二次请求
 * @createTime 2021年09月28日 20:59:59
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String address = "http://www.baidu.com";
         response.sendRedirect(address);
    }


}
