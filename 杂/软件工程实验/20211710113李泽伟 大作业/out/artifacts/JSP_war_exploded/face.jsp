<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/21
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头像编辑界面</title>
</head>
<body style="background-image: url(images/background/back3.png);background-size:100% 100%;">
<h2 style="position:absolute;left: 42%">选择头像信息</h2>
<form action="facenewServlet" method="post" enctype="multipart/form-data" style="position:absolute;left: 35%;top: 12%;" >
    选择你要的头像：<input type="file" name="face"><br>
    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
