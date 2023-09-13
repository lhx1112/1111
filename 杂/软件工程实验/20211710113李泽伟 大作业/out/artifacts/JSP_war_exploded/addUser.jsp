<%--
  Created by IntelliJ IDEA.
  User: along
  Date: 2021/11/19
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-image: url(images/background/back1.png)">
<h1 style="position:absolute;left: 42%">新增联系人界面</h1>
    <form action="addUser" method="post" style="position:absolute;left: 40%;top: 30%;">
        输入用户名： <input type="text" name="username" /> <br/>
        <br>
        输入姓名： <input type="text" name="name" /> <br/>
        <br>
        输入电话号： <input type="text" name="phone" /> <br/>
        <br>
        输入邮箱：<input type="text" name="email" /> <br/>
        <br>
        输入部门： <input type="text" name="department" /> <br/>
        <br>
        输入地区码： <input type="text" name="postalcode" /> <br/>
        <br>
        <input type="submit" value="新增">
    </form>
</body>
</html>
