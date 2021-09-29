package com.company.controller;
/**
 * @author 苏东坡
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description Cookie
 *   1.介绍:
 *
 * 	           1)Cookie来自于Servlet规范中一个工具类，存在于Tomcat提供servlet-api.jar中
 *
 * 		   2)如果两个Servlet来自于同一个网站，并且为同一个浏览器/用户提供服务，此时
 * 		     借助于Cookie对象进行数据共享
 *
 *                    3) Cookie存放当前用户的私人数据，在共享数据过程中提高服务质量
 *
 * 		   4) 在现实生活场景中，Cookie相当于用户在服务端得到【会员卡】
 *
 *            2.原理:
 * 	            用户通过浏览器第一次向MyWeb网站发送请求申请OneServlet。
 * 		    OneServlet在运行期间创建一个Cookie存储与当前用户相关数据
 * 		    OneServlet工作完毕后，【将Cookie写入到响应头】交还给当前
 * 		    浏览器。
 * 		    浏览器收到响应响应包之后，将cookie存储在浏览器的缓存
 * 		    一段时间之后，用户通过【同一个浏览器】再次向【myWeb网站】发送请求申请TwoServlet时。
 *                     【浏览器需要无条件的将myWeb网站之前推送过来的Cookie，写入到请求头】发送过去
 * 		    此时TwoServlet在运行时，就可以通过读取请求头中cookie中信息，得到OneServlet提供的
 * 		    共享数据
 *
 *            3.实现命令:  同一个网站 OneServlet 与  TwoServlet 借助于Cookie实现数据共享
 *
 * 	                OneServlet{
 * 			    public void doGet(HttpServletRequest request,HttpServletResponse resp){
 *
 * 			            //1.创建一个cookie对象，保存共享数据（当前用户数据）
 * 				    Cookie card = new Cookie("key1","abc");
 * 				    Cookie card1= new Cookie("key2","efg");
 * 				    ****cookie相当于一个map
 * 				    ****一个cookie中只能存放一个键值对
 * 				    ****这个键值对的key与value只能是String
 * 				    ****键值对中key不能是中文
 * 				    //2.【发卡】将cookie写入到响应头，交给浏览器
 * 				    resp.addCookie(card);
 * 				    resp.addCookie(card1)
 *                                }            *
 * 			}
 *
 * 			浏览器/用户      <---------响应包 【200】
 * 			                                   【cookie: key1=abc; key2=eft】
 * 							   【】
 * 							   【处理结果】
 *
 *                         浏览器向myWeb网站发送请求访问TwoServlet---->请求包 【url:/myWeb/two method:get】
 * 			                                                     【
 * 									        请求参数：xxxx
 * 										Cookie   key1=abc;key2=efg
 * 									      】
 * 									      【】
 * 									      【】
 *                          TwoServlet{
 *
 * 			    public void doGet(HttpServletRequest request,HttpServletResponse resp){
 *
 * 			         //1.调用请求对象从请求头得到浏览器返回的Cookie
 *                                   Cookie  cookieArray[] = request.getCookies();
 *                                  //2.循环遍历数据得到每一个cookie的key 与 value
 * 				  for(Cookie card:cookieArray){
 * 				          String key =   card.getName(); 读取key  "key1"
 * 					  Strign value = card.getValue();读取value "abc"
 * 					  提供较好的服务。。。。。。。。
 * 				  }
 *                  }
 * 			 }
 *
 *               4.Cookie销毁时机:
 *
 * 	                1.在默认情况下，Cookie对象存放在浏览器的缓存中。
 * 			  因此只要浏览器关闭，Cookie对象就被销毁掉
 *
 *                         2.在手动设置情况下，可以要求浏览器将接收的Cookie
 * 			  存放在客户端计算机上硬盘上，同时需要指定Cookie
 * 			  在硬盘上存活时间。在存活时间范围内，关闭浏览器
 * 			  关闭客户端计算机，关闭服务器，都不会导致Cookie
 * 			  被销毁。在存活时间到达时，Cookie自动从硬盘上被
 * 			  删除
 *
 *                            cookie.setMaxAge(60); //cookie在硬盘上存活1分钟
 * @createTime 2021年09月29日 21:44:44
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String userName,money;
         //调用请求对象读取[请求头]参数信息
         userName = request.getParameter("userName");
         money =  request.getParameter("money");

         //开卡
         Cookie card1 = new Cookie("userName",userName);
         Cookie card2 = new Cookie("money",money);
         card1.setMaxAge(120);
         card2.setMaxAge(120);

         //3。发卡，将Cookie写入响应头交给浏览器
         response.addCookie(card1);
         response.addCookie(card2);

         //通知Tomcat将[点餐页面内容写入到响应体交给浏览器]
         request.getRequestDispatcher("/index2.html").forward(request,response);
    }
}
