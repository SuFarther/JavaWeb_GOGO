<%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/3
  Time: 2:06 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  /**
   * JSP文件内置对象: session
   * 类型: HttpSession
   * 指向当前用户私人储物柜,添加共享数据,则读取共享数据
   *
   * 将共享数据添加到当前用户私人储物柜
   */
  HttpSession session1 = request.getSession();
  session1.setAttribute("key1",200);
%>