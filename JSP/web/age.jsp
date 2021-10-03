<%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/2
  Time: 10:03 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   int  age = 15;
%>

<%
    if(age >= 18){
%>
<font style="color:red;font-size: 40px">热烈欢迎</font>
<%
    }else{
%>
<font style="color:red;font-size: 40px">谢绝入内</font>
<%
    }
%>
