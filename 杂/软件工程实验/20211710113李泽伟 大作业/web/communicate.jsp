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
    <title>通讯管理界面</title>
    <%--    <link rel="stylesheet" href="main.css?v=<%=System.currentTimeMillis()%>">--%>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.js"></script>
    <!-- 引入Boostrap javascript插件 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $(".first").click(function () {
                $(this).next().show().end().parent().siblings().children("ul").hide();
            })
        })

    </script>
    <style type="text/css">
        .top-buffer {
            margin-top: 40px;
        }
    </style>

</head>

<body style="background-image: url(images/main.gif);background-repeat:no-repeat; background-attachment: fixed;background-size:100% 100%;">

<%
    List<Employee> emps = (ArrayList<Employee>) request.getAttribute("emps");
%>

<!-- 搭建显示页面 -->
<div class="container">

    <div class="row">
        <div class="col-md-6">
            <h1>通讯管理</h1>
        </div>
        <div class="col-md-6">
            <h4 class="text-right">欢迎你：${sessionScope.loginName}</h4>
        </div>
    </div>
    <div class="row top-buffer">
        <div class="col-md-2">
            <ul class="nav nav-pills nav-stacked ">
                <li role="presentation" class="active" style="display: block">
                    <a class="first">通讯录管理</a>
                       <ul class="second" style="display: none">
                           <a href="findUserPageable" style="display: block;background-color: #9d9d9d">通讯录查询</a>
                           <a href="addUser.jsp" style="display: block;background-color: #9d9d9d">新增联系人</a>
                           <a href="findOur.jsp" style="display: block;background-color: #9d9d9d">查询联系人</a>
                       </ul>
                </li>
                <li role="presentation" class="active" style="display: block">
                    <a href="#" class="first">邮件管理</a>
                       <ul class="second">
                            <a  href="receiveServlet" style="display: block;background-color: #9d9d9d">收件箱</a>
                            <a  href="sendServlet" style="display: block;background-color: #9d9d9d">发件箱</a>
                            <a  href="sendemail.jsp" style="display: block;background-color: #9d9d9d">新增邮件</a>
                       </ul>
                </li>
            </ul>
        </div>
            <div class="col-md-10">
                <span><img src="images/background/6.png"></span>

    </div>
</div>
</body>
</html>
