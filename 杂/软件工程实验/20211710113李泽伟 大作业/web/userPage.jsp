<%@ page import="chap09.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chap09.entity.Page" %><%--
  Created by IntelliJ IDEA.
  User: along
  Date: 2021/11/19
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<script>
    function deleteUser(id) {
        if (confirm("确定要删除嘛？")) {
            location.href = "userDelete?id=" + id;
        }
    }
</script>


<body background="images/background/back.jpg">
<%
    //获取后台用户数据
    List<User> users = (ArrayList)(request.getAttribute("users"));
    Page p =  (Page) request.getAttribute("page");
%>


<div><a href="addUser.jsp">新增用户</a></div>

<table border="1">
    <tr>
        <td>ID</td><td>用户名</td><td>密码</td><td>邮箱</td><td>操作</td>
    </tr>
    <%
        for(int i=0; i<users.size(); i++) {
            User user = users.get(i);
    %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getSex() %></td>
        <td><%= user.getPhone() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getDepartment() %></td>
        <td><%= user.getPostalcode() %></td>
        <td><a href="findUserById?id=<%=user.getId()%>"> 更新 </a>  <a href="javascript:deleteUser(<%= user.getId() %>)">删除</a></td>
    </tr>
    <%
        }
    %>

</table>

共<%=p.getTotalRow()%>条
<%=p.getPageNow() %> / <%= p.getTotalPage() %>
<a href="findUserPageable?pageNow=<%=  p.getPageNow() - 1 %>">上一页</a>
<a href="findUserPageable?pageNow=<%=  p.getPageNow() + 1 %>">下一页</a>


</body>
</html>
