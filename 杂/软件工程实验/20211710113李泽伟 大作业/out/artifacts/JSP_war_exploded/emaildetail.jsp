<%@ page import="chap09.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chap09.entity.Page" %>
<%@ page import="chap09.entity.Email" %><%--
  Created by IntelliJ IDEA.
  User: along
  Date: 2021/11/19
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情界面</title>
</head>


<body  style="background-image: url(images/background/back2.png)">
<%
    //获取后台用户数据
    Email emails = (Email)request.getAttribute("emails");
%>

<h1 style="position:absolute;left: 42%">邮件详情界面</h1>
<p style="position:absolute;left: 30%;top: 30%">
    发件方：<%= emails.getSend_email() %>   <br><br> <br><br>
    收件方：<%= emails.getReceive_email() %>  <br><br> <br><br>
    邮件主题：<%= emails.getTitle() %>   <br><br> <br><br>
    邮件内容：<%= emails.getContent() %>  <br><br> <br><br>
</p>

</body>
</html>
