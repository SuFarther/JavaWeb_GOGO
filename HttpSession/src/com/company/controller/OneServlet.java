package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description HttpSession接口
 *
 *  1.介绍：
 * 	             1）HttpSession接口来自于Servlet规范下一个接口。存在于Tomcat中servlet-api.jar
 * 		        其实现类由Http服务器提供。Tomcat提供实现类存在于servlet-api.jar
 *
 *                      2）如果两个Servlet来自于同一个网站，并且为同一个浏览器/用户提供服务，此时
 * 		        借助于HttpSession对象进行数据共享
 *
 *                      3）开发人员习惯于将HttpSession接口修饰对象称为【会话作用域对象】
 *
 *              2.HttpSession 与  Cookie 区别：【面试题】
 *
 * 	              1）存储位置:  一个在天上，一个在地下
 *
 * 		                    Cookie：存放在客户端计算机（浏览器内存/硬盘）
 * 				    HttpSession：存放在服务端计算机内存
 *
 *                       2）数据类型：
 * 		                     Cookie对象存储共享数据类型只能是String
 * 				     HttpSession对象可以存储任意类型的共享数据Object
 *
 *                       3) 数据数量:
 * 		                     一个Cookie对象只能存储一个共享数据
 * 				     HttpSession使用map集合存储共享数据，所以可以
 * 				     存储任意数量共享数据
 *
 *                       4）参照物:
 * 		                     Cookie相当于客户在服务端【会员卡】
 *
 * 				     HttpSession相当于客户在服务端【私人保险柜】
 *
 *
 *                3.命令实现:   同一个网站（myWeb）下OneServlet将数据传递给TwoServlet
 *
 * 	                      OneServlet{
 *
 * 			         public void doGet(HttpServletRequest request,HttpServletResponse response){
 *
 * 				        //1.调用请求对象向Tomcat索要当前用户在服务端的私人储物柜
 * 					     HttpSession   session = request.getSession();
 *                                         //2.将数据添加到用户私人储物柜
 * 					    session.setAttribute("key1",共享数据)
 *
 *                                  }
 *
 *                  }
 *
 * 			      浏览器访问/myWeb中TwoServlet
 *
 * 			      TwoServlet{
 *
 * 			        public void doGet(HttpServletRequest request,HttpServletResponse response){
 * 				       //1.调用请求对象向Tomcat索要当前用户在服务端的私人储物柜
 * 				        HttpSession   session = request.getSession();
 *                                        //2.从会话作用域对象得到OneServlet提供的共享数据
 * 				        Object 共享数据 = session.getAttribute("key1");                * 				}
 *
 *                  }
 *                    4.Http服务器如何将用户与HttpSession关联起来
 *
 * 		                cookie
 *
 *
 *                    5.getSession()  与  getSession(false)
 *
 * 		         1）getSession(): 如果当前用户在服务端已经拥有了自己的私人储物柜.
 * 			                  要求tomcat将这个私人储物柜进行返回
 * 					  如果当前用户在服务端尚未拥有自己的私人储物柜
 * 					  要求tocmat为当前用户创建一个全新的私人储物柜
 *
 *                          2)getSession(false):如果当前用户在服务端已经拥有了自己的私人储物柜.
 * 			                     要求tomcat将这个私人储物柜进行返回
 * 					     如果当前用户在服务端尚未拥有自己的私人储物柜
 * 					     此时Tomcat将返回null
 *
 *                  6.HttpSession销毁时机:
 *
 * 		          1.用户与HttpSession关联时使用的Cookie只能存放在浏览器缓存中.
 * 			  2.在浏览器关闭时，意味着用户与他的HttpSession关系被切断
 * 			  3.由于Tomcat无法检测浏览器何时关闭，因此在浏览器关闭时并不会
 * 			    导致Tomcat将浏览器关联的HttpSession进行销毁
 *                           4.为了解决这个问题，Tomcat为每一个HttpSession对象设置【空闲时间】
 * 			    这个空闲时间默认30分钟，如果当前HttpSession对象空闲时间达到30分钟
 * 			    此时Tomcat认为用户已经放弃了自己的HttpSession，此时Tomcat就会销毁
 * 			    掉这个HttpSession
 *
 *                  7.HttpSession空闲时间手动设置
 *
 * 		            在当前网站/web/WEB-INF/web.xml
 *
 * 			    <session-config>
 * 			           <session-timeout>5</session-timeout>  当前网站中每一个session最大空闲时间5分钟
 * 			    </session-config>
 * @createTime 2021年10月01日 21:33:33
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsName;
        //1、调用请求对象,请求请求头参数,得到用户选择商品名
        goodsName =  request.getParameter("goodsName");
        //2、调用请求对象,向Tomcat索要当前用户在服务端的私人储物柜
        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(5);
        Integer goodsNum = (Integer) session.getAttribute(goodsName);

        //3、将用户选购商品添加到用户储物柜
        if(goodsNum == null){
            session.setAttribute(goodsName,1);
        }else {
            session.setAttribute(goodsName,goodsNum+1);
        }

    }
}
