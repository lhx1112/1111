<%@ page import="chap09.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chap09.entity.Page" %>
<%@ page import="chap09.entity.Email" %>
<%@ page import="chap09.entity.Notice" %><%--
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


<body  style="background-image: url(images/background/7.png)">
<%
    //获取后台用户数据
    String  content = (String) request.getAttribute("content");
%>

<h1 style="position:absolute;left: 42%">公告详情界面</h1>
<p style="position:absolute;left: 30%;top: 30%">
    公告内容：<%=content%>  <br><br> <br><br>
</p>

</body>
</html>
