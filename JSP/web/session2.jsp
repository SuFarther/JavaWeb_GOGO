<%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/3
  Time: 2:08 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /**
     * session_1.jsp与session2.jsp为同一个用户/浏览器提供服务,因此可以使用用户在服务端的私人储物柜进行数据共享
     */
    Integer value = (Integer) session.getAttribute("key1");
%>

session2.jsp读取当前用户session中的数据:<%=value%>