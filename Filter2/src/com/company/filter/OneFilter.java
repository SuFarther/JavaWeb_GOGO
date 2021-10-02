package com.company.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName OneFilter
 * @company 公司
 * @Description 过滤器
 * 对两个servlet的请求方式的编码就行解码翻译成一个中文
 * @createTime 2021年10月02日 16:26:26
 */
public class OneFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
