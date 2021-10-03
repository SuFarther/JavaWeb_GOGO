<%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/3
  Time: 2:10 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
/**
* ServletContext application: 全局作用域对象
* 同一个网站中servlet与jsp都可以通过当前网站的全局作用域对象实现数据共享
*/
  application.setAttribute("key1","HelloWorld");
%>
