package com.company.filter;
/**
 * @author 苏东坡
 * @ClassName OneFilter
 * @company 公司
 * @version 1.0
 * @Description Servlet规范扩展-----------------Filter接口(过滤器接口)
 * @createTime 2021年10月02日 15:49:49
 *   1.介绍：
 *                1）来自于Servlet规范下接口，在Tomcat中存在于servlet-api.jar包
 *
 * 	       2）Filter接口实现类由开发人员负责提供，Http服务器不负责提供
 *
 * 	       3)Filter接口在Http服务器调用资源文件之前，对Http服务器进行拦截
 *
 *        2.具体作用：
 *
 *                 1）拦截Http服务器，帮助Http服务器检测当前请求合法性
 *
 * 		2）拦截Http服务器，对当前请求进行增强操作
 *
 *        3.Filter接口实现类开发步骤：三步
 *
 *                  1）创建一个Java类实现Filter接口
 *
 * 		 2）重写Filter接口中doFilter方法
 *
 * 		 3）web.xml将过滤器接口实现类注册到Http服务器
 *
 *        4.Filter拦截地址格式
 *
 *                  1) 命令格式:
 * 		             <filter-mapping>
 * 			        <filter-name>oneFilter</filter-name>
 * 				<url-pattern>拦截地址</url-pattern>
 * 			     </filter-mapping>
 *                  2) 命令作用：
 * 		               拦截地址通知Tomcat在调用何种资源文件之前需要调用OneFilter过滤进行拦截
 *
 *
 *                  3）要求Tomcat在调用某一个具体文件之前，来调用OneFilter拦截
 * 		               <url-pattern>/img/mm.jpg</url-pattern>
 *
 *                  4）要求Tomcat在调用某一个文件夹下所有的资源文件之前，来调用OneFilter拦截
 * 		                <url-pattern>/img/*</url-pattern>
 *
 *                  5）要求Tomcat在调用任意文件夹下某种类型文件之前，来调用OneFilter拦截
 * 		                <url-pattern>*.jpg</url-pattern>
 *
 *                  6)要求Tomcat在调用网站中任意文件时，来调用OneFilter拦截
 * 		                <url-pattern>/*</url-pattern>
 *
 * 		                访问地址  http://localhost:8080/filter/mm.jpeg?age=70
 */

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class OneFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //1、通过拦截请求对象得到请求包参数信息,从而得到来访用户真实年龄
        String age = request.getParameter("age");
        //2、根据年龄,帮助Http服务器判断本次请求合法性
        if(Integer.valueOf(age) < 70){
            //将拦截请求对象和响应对象交还给Tomcat,由Tomcat继续调用资源文件
            chain.doFilter(request,response);
        }else {
            //过滤器代替Http服务器拒绝本次请求
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<center><font style='color:red;font-size:40px'>大爷珍爱生命呀</font></center>");
        }
    }
}
