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
    <title>发件箱</title>
</head>


<body  style="background-image: url(images/background/back2.png)">
<%
    //获取后台用户数据
    Page p =  (Page) request.getAttribute("page");
    List<Email> emails = (ArrayList)(request.getAttribute("emails"));
%>
<h1 style="position:absolute;left: 42%">发件箱界面</h1>
<table border="1" style="position:absolute;left: 15%;top: 20%;table-layout:fixed;width: 1000px">
    <tr>
        <td>ID</td><td>发送邮箱</td><td>收件邮箱</td><td>主题</td><td>正文</td><td>附件</td><td>获取详情</td><td>操作</td>
    </tr>
    <%
        for(int i=0; i<emails.size(); i++) {
            Email email = emails.get(i);
    %>
    <tr>
        <td ><%= email.getId() %></td>
        <td style="overflow:hidden;white-space:nowrap;"><%= email.getSend_email() %></td>
        <td style="overflow:hidden;white-space:nowrap;"><%= email.getReceive_email()%></td>
        <td style="overflow:hidden;white-space:nowrap;"><%= email.getTitle()%></td>
        <td style="overflow:hidden;white-space:nowrap;"><%= email.getContent()%></td>
        <td><%= email.getAttachment()%></td>
        <td><a href="emaildetail?id=<%= email.getId() %>">详情</a></td>
        <td><a href="filedownload?id=<%= email.getId() %>">下载附件</a></td>
    </tr>
    <%
        }
    %>

</table>

    <div style="position:absolute;left: 30%;top: 67%;">
        共<%=p.getTotalRow()%>条
        <%=p.getPageNow() %> / <%= p.getTotalPage() %>
        <a href="findEmailPageable?pageNow=<%=  p.getPageNow() - 1 %>">上一页</a>
        <a href="findEmailPageable?pageNow=<%=  p.getPageNow() + 1 %>">下一页</a>
    <div>

</body>
</html>
