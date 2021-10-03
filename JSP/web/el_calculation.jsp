<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String num1 = (String) request.getAttribute("key1");
    Integer num2 = (Integer)request.getAttribute("key2");
    int sum = Integer.valueOf(num1)+num2;
%>
两个数的和:<%=sum%>

<hr/>
两个数的和:${key1+key2}


<hr/>

EL表达式输出关系运算: ${key2 > 18?"欢迎光临":"谢绝入内"};