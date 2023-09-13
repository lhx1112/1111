<%@ page import="chap09.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/21
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
</head>
<%
    User user = (User) request.getAttribute("user");
%>

<body style="background-image: url(images/background/back3.png);background-size:100% 100%;">
<h2 style="position:absolute;left: 42%">修改个人信息</h2>
    <form action="updateUser2" method="post" style="position:absolute;left: 38%;top: 20%;">
        <input type="hidden" name="id" value="<%= user.getId()%>">
        输入姓名： <input type="text" name="name" value="<%= user.getName()%>"/> <br> <br>
        输入手机号： <input type="text" name="phone" value="<%= user.getPhone()%>"/> <br> <br>
        输入邮箱：<input type="text" name="email" value="<%= user.getEmail()%>"/> <br> <br>
        输入部门： <input type="text" name="department" value="<%= user.getDepartment()%>"/> <br> <br>
        输入地区码： <input type="text" name="postalcode" value="<%= user.getPostalcode()%>"/> <br><br><br>
        <input type="submit" value="更新">
    </form>
</body>
</html>
