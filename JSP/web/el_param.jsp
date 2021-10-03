<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--http://localhost:8080/JSP_war_exploded/el_param.jsp?userName=zhangsan&password=123-->
来访者姓名: ${param.userName}<br/>
来访者密码: ${param.password}


<!--http://localhost:8080/JSP_war_exploded/el_param.jsp?dept=1&dept=2&dept=3-->
第一个部门编号: ${paramValues.dept[0]}
第二个部门编号: ${paramValues.dept[1]}
第三个部门编号: ${paramValues.dept[2]}