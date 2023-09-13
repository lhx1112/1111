<%@ page import="chap09.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chap09.entity.Page" %>
<%@ page import="chap09.entity.Our" %>
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
    <title>企业公告界面</title>
</head>
//20211710113李泽伟
<body style="background-image: url(/images/background/7.png)">
<%
    //获取后台用户数据
    List<Notice> notices = (ArrayList)(request.getAttribute("notices"));
    Page p =  (Page) request.getAttribute("page");
%>
<h1 style="position:absolute;left: 42%">企业公告界面</h1>
<table border="1" style="position:absolute;left: 40%;top: 20%;">
    <tr>
        <td>ID</td><td>标题</td><td>发表时间</td><td>公告内容</td>
    </tr>
    <%
        for(int i=0; i<notices.size(); i++) {
            Notice notice = notices.get(i);
    %>
    <tr>
        <td><%= notice.getNoticeid() %></td>
        <td><%= notice.getNoticetopic() %></td>
        <td><%= notice.getNoticetime() %></td>
        <td><a href="noticedetail?content=<%= notice.getNoticecontent() %>">详情</a></td>
    </tr>
    <%
        }
    %>
</table>
<div style="position:absolute;left: 30%;top: 67%;">
    共<%=p.getTotalRow()%>条
    <%=p.getPageNow() %> / <%= p.getTotalPage() %>
    <a href="findNoticePageable?pageNow=<%=  p.getPageNow() - 1 %>">上一页</a>
    <a href="findNoticePageable?pageNow=<%=  p.getPageNow() + 1 %>">下一页</a>
</div>

</body>
</html>
