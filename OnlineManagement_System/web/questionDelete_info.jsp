<%--
  Created by IntelliJ IDEA.
  User: zairensuyi
  Date: 2021/10/3
  Time: 4:09 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String deleteInfo = (String) request.getAttribute("delete_info");
%>
<font style="color:red;font-size: 40px">
    删除的试题:<%=deleteInfo%>
</font>
