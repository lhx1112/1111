<%@ page import="chap09.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chap09.entity.Page" %>
<%@ page import="chap09.entity.Our" %><%--
  Created by IntelliJ IDEA.
  User: along
  Date: 2021/11/19
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通讯录查询界面</title>
</head>

<script>
    function deleteUser(id) {
        if (confirm("确定要删除嘛？")) {
            location.href = "userDelete?id=" + id;
        }
    }
</script>

<body style="background-image: url(/images/background/back1.png)">
    <%
        //获取后台用户数据
        List<Our> ours = (ArrayList)(request.getAttribute("ours"));
        Page p =  (Page) request.getAttribute("page");
    %>
<h1 style="position:absolute;left: 42%">通讯录查询界面</h1>
    <table border="1" style="position:absolute;left: 30%;top: 20%;">
        <tr>
            <td>ID</td><td>用户名</td><td>真实姓名</td><td>电话号码</td><td>邮箱</td><td>部门</td><td>地区号</td><td>操作</td>
        </tr>
        <%
            for(int i=0; i<ours.size(); i++) {
                Our our = ours.get(i);
        %>
        <tr>
            <td><%= our.getId() %></td>
            <td><%= our.getUsername() %></td>
            <td><%= our.getTruename() %></td>
            <td><%= our.getPhone() %></td>
            <td><%= our.getEmail() %></td>
            <td><%= our.getDepartment() %></td>
            <td><%= our.getPostalcode() %></td>
            <td><a href="findUserById?id=<%=our.getId()%>"> 更新 </a>  <a href="javascript:deleteUser(<%= our.getId() %>)">删除</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <div style="position:absolute;left: 30%;top: 67%;">
        共<%=p.getTotalRow()%>条
        <%=p.getPageNow() %> / <%= p.getTotalPage() %>
        <a href="findUserPageable?pageNow=<%=  p.getPageNow() - 1 %>">上一页</a>
        <a href="findUserPageable?pageNow=<%=  p.getPageNow() + 1 %>">下一页</a>
    </div>

</body>
</html>
