package com.company.controller; /**
 * @ClassName ThreeServlet
 * @company 公司
 * @version 1.0
 * @Description HttpServletResponse解决中文乱码问题。
 * 在浏览器那里有个NetWork-Headers-Response Headers有一个Content-Type: text/html;charset=ISO-8859-1默认不设置请求头的字符编码是ISO-8859-1
 *
 *
 * 问题描述:
 *   JAVA<br/>MYSQL<br/>HTML浏览器在接收到响应结果时,将<br/>作为文字内容在窗口展示出来,没有将<br/>当作HTML标签命令来执行
 * 问题原因：:
 *   浏览器在接收到响应包之后,根据[响应头中content-type]属性的值,来采用对应[编译器]对[响应体中二进制内容]进行编译处理
 *
 *   在默认的情况下，content-type属性的值"text" content-type="text",此时浏览器将采用[文本编译器]对响应体二进制数据进行解析
 * 解决方案:
 *    一定要得到输出流之前,通过响应对象对响应头中content-type属性进行,一次重新赋值用于指定浏览器采用正确编译器
 *
 *   设置响应头content-type
 *   response.setContentType("text/html;charset=utf-8");
 *
 *
 * @createTime 2021年09月24日 21:50:50
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 苏东坡
 */
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        String result = "JAVA<br/>MYSQL<br/>HTML";
        String result = "我爱中国!";
        //向Tomcat索要输出流,通过输出流将结果写入到响应体中
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
