<%@ page import="com.company.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: 苏东坡
  Date: 2021/10/3
  Time: 4:58 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>试题新增</title>
</head>
<body>
<%--  <%--%>
<%--      Question question = (Question) request.getAttribute("key");--%>
<%--  %>--%>
  <center>
      <form action="/Online/question/update" method="get">
          <table border="2">
              <tr>
                  <td>题目编号：</td>
<%--                  <td><input type="text" name="questionId" value="<%=question.getQuestionId()%>" readonly></td>--%>
                  <td><input type="text" name="questionId" value="${requestScope.key.questionId}" readonly></td>
              </tr>
              <tr>
                  <td>题目：</td>
<%--                  <td><input type="text" name="title" value="<%=question.getTitle()%>"></td>--%>
                  <td><input type="text" name="title" value="${requestScope.key.title}"></td>
              </tr>
              <tr>
                  <td>A：</td>
<%--                  <td><input type="text" name="optionA" value="<%=question.getOptionA()%>"></td>--%>
                  <td><input type="text" name="title" value="${requestScope.key.optionA}"></td>
              </tr>
              <tr>
                  <td>B：</td>
<%--                  <td><input type="text" name="optionB" value="<%=question.getOptionB()%>"></td>--%>
                  <td><input type="text" name="title" value="${requestScope.key.optionB}"></td>
              </tr>
              <tr>
                  <td>C：</td>
<%--                  <td><input type="text" name="optionC" value="<%=question.getOptionC()%>"></td>--%>
                  <td><input type="text" name="title" value="${requestScope.key.optionC}"></td>
              </tr>
              <tr>
                  <td>D：</td>
<%--                  <td><input type="text" name="optionD" value="<%=question.getOptionC()%>"></td>--%>
                  <td><input type="text" name="title" value="${requestScope.key.optionD}"></td>
              </tr>
              <tr>
                  <td>正确答案：</td>
                  <td>
<%--                      <input type="radio" name="answer" value="A" <%="A".equals(question.getAnswer())?"checked":""%>>A--%>
<%--                      <input type="radio" name="answer" value="B" <%="B".equals(question.getAnswer())?"checked":""%>>B--%>
<%--                      <input type="radio" name="answer" value="C" <%="C".equals(question.getAnswer())?"checked":""%>>C--%>
<%--                      <input type="radio" name="answer" value="D" <%="D".equals(question.getAnswer())?"checked":""%>>D--%>

                      <input type="radio" name="answer" value="A" ${"A" eq requestScope.key.answer?"checked":""}>A
                      <input type="radio" name="answer" value="B" ${"B" eq requestScope.key.answer?"checked":""}>B
                      <input type="radio" name="answer" value="C" ${"C" eq requestScope.key.answer?"checked":""}>C
                      <input type="radio" name="answer" value="D" ${"D" eq requestScope.key.answer?"checked":""}>D
                  </td>
              </tr>
              <tr>
                  <td><input type="submit" value="更新试题"/></td>
                  <td><input type="reset" value="重置"/></td>
              </tr>
          </table>
      </form>
  </center>
</body>
</html>
