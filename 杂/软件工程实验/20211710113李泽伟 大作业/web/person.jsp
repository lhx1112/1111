<%@ page import="com.jsp.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: along
  Date: 2021/11/11
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>个人管理界面</title>
    <%--    <link rel="stylesheet" href="main.css?v=<%=System.currentTimeMillis()%>">--%>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.js"></script>
    <!-- 引入Boostrap javascript插件 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <style type="text/css">
        .top-buffer {
            margin-top: 40px;
        }
    </style>

</head>

<body style="background-image: url(images/main.gif);background-repeat:no-repeat; background-attachment: fixed;background-size:100% 100%;">

<%

%>

<!-- 搭建显示页面 -->
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h1>个人管理</h1>
        </div>
        <div class="col-md-6">
            <h4 class="text-right">欢迎你：${sessionScope.loginName}</h4>
        </div>
    </div>


    <div class="row top-buffer">
        <div class="col-md-2">
            <ul class="nav nav-pills nav-stacked ">
                <li role="presentation" class="active"><a href="personServlet">个人信息查询</a></li>
                <li role="presentation" class="active"><a href="face.jsp">头像编辑</a></li>
            </ul>
        </div>

            <div class="col-md-10">
                <span><img src="images/background/5.png"></span>
            </div>
    </div>
</div>
</body>
</html>

