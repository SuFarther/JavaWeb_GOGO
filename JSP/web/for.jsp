<%@ page import="com.company.entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 苏东坡1
  Date: 2021/10/2
  Time: 10:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--制造数据-->
<%
  Student stu1 = new Student("19","张三1");
  Student stu2 = new Student("20","张三2");
  Student stu3 = new Student("39","张三3");
  List<Student> list = new ArrayList();
  list.add(stu1);
  list.add(stu2);
  list.add(stu3);
%>

<!--数据输出-->
<table border="2" align="center">
  <tr>
    <td>学员编号</td>
    <td>学员姓名</td>
  </tr>

   <%
      for (Student stu:list){
   %>
  <tr>
    <td><%=stu.getSid()%></td>
    <td><%=stu.getsName()%></td>
  </tr>
   <%
      }
   %>
</table>