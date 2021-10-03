<%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/3
  Time: 2:51 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String result = (String) request.getAttribute("info");
%>
<font style="color:red;font-size: 40px">
    <%=result%>
</font>