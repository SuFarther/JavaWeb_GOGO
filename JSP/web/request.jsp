<%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/3
  Time: 1:46 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
JSP文件内置对象1
JSP文件内置对象: request
类型: HttpServletRequest
作包: 在JSP文件时读取请求包信息与servlet请求转发过程中实现数据数据共享

浏览器: Http://localhost:8080/Online/request.jsp?userName=allen&password=123
-->

<%
  //在JSP文件执行时,借助于内置request对象读取请求包参数信息
  String userName = request.getParameter("userName");
  String password = request.getParameter("password");
%>

来访到客户名字:<%=userName%><br/>
来访到客户密码:<%=password%>