<%@ page import="java.util.List" %>
<%@ page import="com.company.entity.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/3
  Time: 8:49 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
 //从请求作用域对象得到StudentServlet添加进去到集合
    List<Student> studentList = (List) request.getAttribute("key");
%>


<!--将处理结果写入到响应体-->
<table border="2" align="center">
    <tr>
        <td>用户编号</td>
        <td>用户姓名</td>
    </tr>
    <tr>
        <%
            for (Student student:studentList){
        %>
            <tr>
                <td><%=student.getSid()%></td>
                <td><%=student.getsName()%></td>
            </tr>
        <%
            }
        %>
    </tr>
</table>