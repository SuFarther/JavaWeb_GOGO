<%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/3
  Time: 6:31 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer sid = (Integer) application.getAttribute("sid");
    String sname = (String) session.getAttribute("sname");
    String home = (String) request.getAttribute("home");
    pageContext.setAttribute("sex","男");
%>
全局作用域对象:<%=sid%><br/>
会话作用域对象:<%=sname%><br/>
请求作用域对象: <%=home%>

<hr/>
学员ID:${applicationScope.sid}<br/>
学员姓名:${sessionScope.sname}<br/>
学员地址:${requestScope.home}<br/>
性别:${pageScope.sex}