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
    <title>个人信息查询界面</title>
</head>


<body style="background-image: url(images/background/back3.png);background-size:100% 100%;">
<%
    //获取后台用户数据
    List<User> users = (ArrayList)(request.getAttribute("users"));
    String url =(String)session.getAttribute("url");
    String username=(String)session.getAttribute("loginName");
%>
<h1 style="position:absolute;left: 42%">个人信息查询界面</h1>
    <table border="1" style="position:absolute;left: 40%;top: 20%;width: 300px;height: 450px;">
        <%
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    User u =user;
//                    String url = "/images/"+u.getFace();
                    System.out.println(url);
            %>
        <tr><td style="text-align: center">用户名</td><td style="text-align: center"><%= u.getUsername()%></td> <td style="text-align: center;" rowspan="4"><img src="<%=(String)session.getAttribute("url")%>" width="100px" height="100px"></td></tr>
        <tr><td style="text-align: center">姓名</td> <td style="text-align: center"><%= u.getName()%></td>
        <tr><td style="text-align: center">部门</td> <td style="text-align: center"><%= u.getDepartment()%></td>
        <tr><td style="text-align: center">地区码</td> <td style="text-align: center"><%= u.getPostalcode()%></td>
        <tr><td style="text-align: center">手机</td> <td style="text-align: center" colspan="2"><%= u.getPhone()%></td>
        <tr><td style="text-align: center">邮箱</td> <td style="text-align: center" colspan="2"><%= u.getEmail()%></td></tr>
        <td colspan="4" style="text-align: center"><a href="findUserById2?id=<%=user.getId()%>"> 修改信息 </a></td>
        <%
                }
        }
        %>

    </table>

</body>
</html>
