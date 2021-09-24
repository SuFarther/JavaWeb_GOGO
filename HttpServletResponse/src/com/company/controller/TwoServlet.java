package com.company.controller; /**
 * @ClassName TwoServlet
 * @company 公司
 * @version 1.0
 * @Description HttpServletResponse接口
 * 问题描述: 浏览器接收到数据2,不是50
 * 问题原因:
 *  out.writer方法可以将[字符],[字符串],[ASCII码]写入到响应体
 *  ASCII码:
 *     a----------97
 *     2----------50
 *
 *  问题解决方案: 在实际开发过程,都是通过out.print()将真实数据写入到响应体中
 * @createTime 2021年09月24日 21:40:40
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 苏东坡
 */
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int money = 50;
        PrintWriter out = response.getWriter();
        out.print(money);
    }
}
