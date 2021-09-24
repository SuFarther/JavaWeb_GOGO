package com.company.controller;
/**
 * @ClassName ThreeServlet
 * @company 公司
 * @version 1.0
 * @Description HttpServletRequest接口
 * 问题：
 *  以GET方式发送中文参数内容"我是中国"时,得到正常结果
 *  以POST方式发送中文参数内容"我是中国"时,得到乱码
 *
 *  原因:
 *    浏览器以GET方式发送请求,请求参数保存在[请求头],在Http请求协议包到达Http服务器之后,第一件事就是解码
 *    请求头二进制内容由Tomcat负责解码,Tomcat9.0默认默认使用utf-8字符集,可以解释国际语言
 *
 *    浏览器以POST方式发送请求,请求参数保存在[请求体],在Http请求协议包到达Http服务器之后,第一件事就是解码
 *    请求体二进制内容由当前请求(request)负责解码。request默认使用【ISO-8859-1】字符集,一个东欧语言字符集,此时如果请求体参数内容是中文
 *    ,则无法解码只能得到乱码
 *
 *    解决方案:
 *    在post请求方式下,在读取请求体内容之前，应该通知请求对象使用utf-8字符集对请求体内容进行一次重新解码
 *
 *    应该通知请求对象使用utf-8字符集对请求体内容进行一次重新解码
 *    request.setCharacterEncoding("utf-8");
 *
 * @createTime 2021年09月24日 23:03:03
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 苏东坡
 */
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过请求对象,读取[请求头]参数信息
        String username = request.getParameter("username");
        System.out.println("从请求头得到参数值："+username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //通过请求对象,读取[请求体]参数信息
        String username = request.getParameter("username");
        System.out.println("从请求头得到参数值："+username);
    }
}
