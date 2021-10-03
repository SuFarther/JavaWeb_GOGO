<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% //在jsp文件中,只有书写在执行标记中内容才会被当做Java命令%>
<%
  //1、声明Java变量
  int num1 = 100;
  int num2 = 200;
%>

<!--在JSP文件,通过输出标记,通知JSP将Java变量的值写入到响应体-->
变量num1的值:<%=num1%><br/>
变量num2的值:<%=num2%><br/>
<!--执行标记还可以通知JSP将运算结果写入到响应体-->
num1 + num2 = <%=num1 + num2 %>
