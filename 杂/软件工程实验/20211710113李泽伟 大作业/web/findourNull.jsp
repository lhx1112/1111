<%@ page import="chap09.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chap09.entity.Page" %>
<%@ page import="chap09.entity.Our" %><%--
  Created by IntelliJ IDEA.
  User: along
  Date: 2021/11/19
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询ID错误界面</title>
</head>

<body style="background-image: url(/images/background/back1.png)">
<h1 style="position:absolute;left: 42%">查询ID错误界面</h1>
<%--    <div><a href="addUser.jsp">新增用户</a></div>--%>
<form action="findOurServlet" method="post">
    <input type="text" name="id" placeholder="请输入要搜索的ID" required>
    <button style="background-color: #a6e1ec">搜寻</button>
</form>
<p style="font-size: larger"> 对不起你搜寻的用户ID不存在请重新输入</p>


</body>
</html>
