package com.company.controller;
/**
 * @author
 * @ClassName TwoServlet
 * @company 公司
 * @version 1.0
 * @Description ServletContext接口
 * 		 十三。ServletContext接口:
 *
 *                   1.介绍：
 * 		          1）来自于Servlet规范中一个接口。在Tomcat中存在servlet-api.jar
 * 			     在Tomcat中负责提供这个接口实现类
 *
 *                           2）如果两个Servlet来自于同一个网站。彼此之间通过网站的ServletContext
 * 			     实例对象实现数据共享
 *
 *                           3）开发人员习惯于将ServletContext对象称为【全局作用域对象】
 *
 *
 *                   2.工作原理：
 *
 * 		          每一个网站都存在一个全局作用域对象。
 * 			  这个全局作用域对象【相当于】一个Map.
 * 			  在这个网站中OneServlet可以将一个数据
 * 			  存入到全局作用域对象，当前网站中其他
 * 			  Servlet此时都可以从全局作用域对象得到
 * 			  这个数据进行使用
 *
 *                   3.全局作用域对象生命周期：
 *
 * 		           1）在Http服务器启动过程中，自动为当前网站在内存中创建
 * 			      一个全局作用域对象
 *                            2）在Http服务器运行期间时，一个网站只有一个全局作用域对象
 *
 * 			   3）在Http服务器运行期间，全局作用域对象一直处于存活状态
 *
 * 			   4）在Http服务器准备关闭时，负责将当前网站中全局作用域对象
 * 			      进行销毁处理
 *                            *****全局作用域对象生命周期贯穿网站整个运行期间***
 *
 *                   4.命令实现： 【同一个网站】OneServlet将数据共享给TwoServlet
 *
 * 		                 OneServlet{
 *
 * 				    public void doGet(HttpServletRequest request,HttpServletResponse response){
 *
 *                                               //1.通过【请求对象】向Tomcat索要当前网站中【全局作用域对象】
 * 					       ServletContext application = request.getServletContext();
 *                                               //2.将数据添加到全局作用域对象作为【共享数据】
 * 					       application.setAttribute("key1",数据)
 *
 *                                        }
 *
 * 				 }
 *
 * 				 TwoServlet{
 *
 * 				   public void doGet(HttpServletRequest request,HttpServletResponse response){
 *
 * 				        //1.通过【请求对象】向Tomcat索要当前网站中【全局作用域对象】
 * 					ServletContext application = request.getServletContext();
 * 					//2.从全局作用域对象得到指定关键字对应数据
 * 		                	Object 数据 =  application.getAttribute("key1");
 *                   *                 }
 *
 * 				 }
 * @createTime 2021年09月28日 22:19:19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过【请求对象】向Tomcat索要当前网站中【全局作用域对象】
        ServletContext application = request.getServletContext();
        //2.从全局作用域对象得到指定关键字对应数据
        Integer key1 = (Integer) application.getAttribute("key1");
        System.out.println(key1);
    }
}
