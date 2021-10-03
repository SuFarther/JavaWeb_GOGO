<%@ page import="com.company.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/3
  Time: 7:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
     //传统写法
    Student stu = (Student) request.getAttribute("key");
%>
学生ID:<%=stu.getSid()%>
学生姓名:<%=stu.getsName()%>

<hr/>
学生ID: ${requestScope.key.sid}
学生姓名:${requestScope.key.sName}

<hr/>
学生ID: ${key.sid}
学生姓名:${key.sName}