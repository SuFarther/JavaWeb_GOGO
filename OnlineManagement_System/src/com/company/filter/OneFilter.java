package com.company.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName OneServlet
 * @company 公司
 * @Description 过滤器拦截所有请求
 *
 * 过滤静态资源
 *   http://localhost:8080/Online/index.html
 * 过滤动态资源
 *    http://localhost:8080/Online/user/find
 * @createTime 2021年10月02日 20:11:11
 */
public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1、拦截后,通过请求对象向Tomcat索要当前用户对HttpSession
         HttpSession session = null;
//        //判断来访用户身份合法性
//        if(session == null){
//           request.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);
//           return;
//        }
//        //如果这个客户是有的,放行
//        filterChain.doFilter(servletRequest,servletResponse);

        //1.调用请求对象读取请求包中请求放行中URi,了解用户访问的资源文件是谁 /Online/
        String uri = request.getRequestURI();
        //2、如果本次请求资源文件与登陆相关
        if(uri.indexOf("login")!= -1 || "/Online/".equals(uri)){
            filterChain.doFilter(request,response);
            return;
        }

        //3、如果本次请求访问的是其他资源文件,需要得到用户HttpSession
        session = request.getSession(false);
        if(session!=null){
            filterChain.doFilter(request,response);
            return;
        }

        //4、做拒绝请求
        request.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);
    }
}
