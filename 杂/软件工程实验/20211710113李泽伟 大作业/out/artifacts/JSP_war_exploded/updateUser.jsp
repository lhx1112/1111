<%@ page import="chap09.entity.User" %>
<%@ page import="chap09.entity.Our" %><%--
  Created by IntelliJ IDEA.
  User: along
  Date: 2021/11/19
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-image: url(images/background/back1.png)">

<%
        Our our = (Our) request.getAttribute("our");
%>
<h2 style="position:absolute;left: 42%">更新用户界面</h2>
<form action="updateUser" method="post" style="position:absolute;left: 38%;top: 20%;">

    <input type="hidden" name="id" value="<%= our.getId()%>">

    输入姓名： <input type="text" name="name" value="<%= our.getUsername()%>"/> <br/><br>
    输入真实姓名： <input type="text" name="truename" value="<%= our.getTruename()%>"/> <br/><br>
    输入手机号： <input type="text" name="phone" value="<%= our.getPhone()%>"/> <br/><br>
    输入邮箱：<input type="text" name="email" value="<%= our.getEmail()%>"/> <br/><br>
    输入部门： <input type="text" name="department" value="<%= our.getDepartment()%>"/> <br/><br>
    输入地区码： <input type="text" name="postalcode" value="<%= our.getPostalcode()%>"/> <br/><br>
    <input type="submit" value="更新">
</form>
</body>
</html>
