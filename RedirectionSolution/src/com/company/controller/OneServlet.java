package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description 重定向解决方案和多个Servlet之间调用规则
 * 多个Servlet之间调用规则:
 *
 *              1.前提条件：
 * 	                  某些来自于浏览器发送请求，往往需要服务端中多个Servlet协同处理。
 * 			  但是浏览器一次只能访问一个Servlet，导致用户需要手动通过浏览器
 * 			  发起多次请求才能得到服务。
 * 			  这样增加用户获得服务难度，导致用户放弃访问当前网站【98k,AKM】
 *
 *              2.提高用户使用感受规则：
 *
 * 	                  无论本次请求涉及到多少个Servlet,用户只需要【手动】通知浏览器发起
 * 			  一次请求即可
 *
 *              3.多个Servlet之间调用规则：
 *
 * 	                    1）重定向解决方案
 *
 * 			           2）请求转发解决方案
 *
 *
 *
 *
 *  1.工作原理: 用户第一次通过【手动方式】通知浏览器访问OneServlet。
 * 	          OneServlet工作完毕后，将TwoServlet地址写入到响应头
 * 			  location属性中，导致Tomcat将302状态码写入到状态行。
 *
 * 			  在浏览器接收到响应包之后，会读取到302状态。此时浏览器
 * 			  自动根据响应头中location属性地址发起第二次请求，访问
 * 			  TwoServlet去完成请求中剩余任务
 *
 *              2.实现命令:
 *
 * 	                  response.sendRedirect("请求地址")
 * 			  将地址写入到响应包中响应头中location属性
 *
 *
 *              3.特征:
 *
 * 	                  1)请求地址：
 * 			     既可以把当前网站内部的资源文件地址发送给浏览器 （/网站名/资源文件名）
 * 			     也可以把其他网站资源文件地址发送给浏览器(http://ip地址:端口号/网站名/资源文件名)
 *
 *                           2)请求次数
 *
 * 			     浏览器至少发送两次请求，但是只有第一次请求是用户手动发送。
 * 			     后续请求都是浏览器自动发送的。
 *
 *                           3) 请求方式：
 * 			     重定向解决方案中，通过地址栏通知浏览器发起下一次请求，因此
 * 			     通过重定向解决方案调用的资源文件接收的请求方式一定是【GET】
 *
 *              4.缺点:
 * 	                 重定向解决方案需要在浏览器与服务器之间进行多次往返，大量时间
 * 			 消耗在往返次数上，增加用户等待服务时间
 *
 * @createTime 2021年09月28日 21:44:44
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          System.out.println("OneServlet负责洗韭菜");
        /**
         * OneServlet工作完毕后,将TwoServlet地址写入到响应头location交给浏览器,
         * 然后用户也也就是浏览器接收到响应包,读取到了302状态码,立刻自动根据响应头中location发送第二次请求,第二次请求是浏览器自动发送到
         */
        response.sendRedirect("/redirection_solution/two");
    }
}
