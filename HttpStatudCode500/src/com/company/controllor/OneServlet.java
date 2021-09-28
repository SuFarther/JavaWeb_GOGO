package com.company.controllor;
/**
 * @author 苏东坡
 * @ClassName OneServlet
 * @company 公司
 * @version 1.0
 * @Description Http状态码
 *  500:通知浏览器，在服务端已经定位到被访问的资源文件（Servlet）
 *  	这个Servlet可以接收浏览器采用请求方式，但是Servlet在处理
 *  	请求期间，由于Java异常导致处理失败
 * @createTime 2021年09月28日 21:26:26
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             Map map = new HashMap();
             //抛出NullPointException空指针异常  报500异常
            // int num = (int) map.get("key1");
             //使用引用数据类型,默认值是空,可以避免空指针异常
             Integer num = (Integer) map.get("key1");
    }
}
