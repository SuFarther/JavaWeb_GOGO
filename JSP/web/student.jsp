<%@ page import="com.company.entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/2
  Time: 9:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //创建一个student对象
  Student student = new Student("002","张三");
  List list = new ArrayList();
%>

学员编号: <%=student.getSid()%>
学员名字: <%=student.getsName()%>