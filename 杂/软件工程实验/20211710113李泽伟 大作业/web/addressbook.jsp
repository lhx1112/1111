<%@ page import="chap09.entity.Page" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chap09.entity.Subs" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <!-- 引入Boostrap javascript插件 -->
    <script src="js/jquery-3.4.1.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <style type="text/css">
        .top-buffer {
            margin-top: 40px;
        }
    </style>
    <link rel="stylesheet" href="css/users.css">
</head>

<script>
    function deleteUser(id) {
        if (confirm("确定要删除嘛？")) {
            location.href = "userDelete?id=" + id;
        }
    }
    // function add_allUser() {
    //     if (confirm("请输入需要添加的条数")) {
    //         location.href = "userDelete?id=" + id;
    //     }
    // }
</script>


<body>
<%
    //获取后台用户数据
    List<Subs> subss = (ArrayList)(request.getAttribute("subss"));
    Page p = (Page) request.getAttribute("page");
%>

<div class="row">
    <div class="col-md-6">
        <h1>WenZhou University-SSM</h1>
        <a>当前在线人数：${applicationScope.count}</a>
        <a href="<%= request.getContextPath()%>/logout">注销</a>
        <%--            <h1>当前在线人数：${sessionScope.size()}人<button class="btn btn-default" onclick=location.href="logout">注销</button></h1>--%>
    </div>
    <div class="col-md-6">
        <h4 class="text-right">欢迎您：${sessionScope.loginName}</h4>
    </div>
</div>
<div class="row top-buffer">
    <div class="col-md-2">
        <%--            添加li样式并改为垂直--%>
        <ul class="nav nav-pills nav-stacked">
            <li role="presentation" class="active"><a href="findUserPageable">显示员工</a></li>
            <li role="presentation" class="active" style="padding-bottom: 8px"><a class="dropdown-toggle" data-toggle="collapse" href="#section1">通讯管理</a></li>
            <ul id="section1" class="collapse nav nav-pills nav-stacked" style="padding-left: 10px">
                <%--                        <li><a href="#" class="menu2">通讯录管理</a></li>--%>
                <li role="presentation" class="active" style="padding-bottom: 4px"><a class="dropdown-toggle" data-toggle="collapse" href="#section1_1">通讯管理</a></li>
                <ul id="section1_1" class="collapse nav nav-pills nav-stacked" style="padding-left: 10px">
                    <li><a href="findUserPageable" class="menu2">查看通讯录</a></li>
                    <li><a href="subsadd.jsp" class="menu2">新增联系人</a></li>
                </ul>
                <%--                        <li><a href="#" class="menu2">邮件管理</a></li>--%>
                <li role="presentation" class="active" style="padding-bottom: 4px"><a class="dropdown-toggle" data-toggle="collapse" href="#section1_2">邮件管理</a></li>
                <ul id="section1_2" class="collapse nav nav-pills nav-stacked" style="padding-left: 10px">
                    <li><a href="recemail" class="menu2" target="myIframe">收件箱</a></li>
                    <li><a href="sendemail" class="menu2">发件箱</a></li>
                    <li><a href="newemail.jsp" class="menu2">新增邮件</a></li>
                </ul>
            </ul>
            <li role="presentation" class="active" style="padding-bottom: 8px"><a class="dropdown-toggle" data-toggle="collapse" href="#section2">个人管理</a></li>
            <ul id="section2" class="collapse nav nav-pills nav-stacked" style="padding-left: 10px">
                <li><a href="person" class="menu2">个人信息查询</a></li>
                <li><a href="person" class="menu2">头像编辑</a></li>
                <li><a href="person.jsp" class="menu2">信息修改</a></li>
            </ul>
            <li role="presentation" class="active" style="padding-bottom: 8px"><a class="dropdown-toggle" data-toggle="collapse" href="#section3">企业管理</a></li>
            <ul id="section3" class="collapse nav nav-pills nav-stacked" style="padding-left: 10px">
                <li><a href="#" class="menu2">公司公告</a></li>
                <li><a href="#" class="menu2">工作会议</a></li>`
            </ul>
        </ul>
    </div>

        <c:if test="${empty subss}">
        <div class="col-md-10">
            <span><img src="images/background/louvre.jpg"></span>
        </div>
        </c:if>
        <c:if test="${not empty subss}">
            <div class="col-md-10">
                <form action="subssearch" method="post">
                    <div class="form-group email_style">
                        <label for="input2" class="col-sm-2 control-label email_form">输入用户名查询:</label>
                        <div class="col-sm-6">
                            <input type="text" name="checkusername" class="form-control" id="input2" placeholder="请输入用户名开始查询">
                        </div>
                        <button class="btn btn-sm btn-danger deleteBtn">查询</button>
                    </div>
                </form>
                <div class="row">
                    <div class="col-md-4 col-md-offset-10">
                            <%--                        onclick=location.href="addUser.jsp"--%>
                        <button class="btn btn-primary" id="emp_add_modal_btn" onclick=location.href="subsadd.jsp">新增</button>
                        <button class="btn btn-danger" id="emp_add_all_btn">批量添加</button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-hover" id="emps_table">
                                <%--                            thread用于分组，其中一定要有tr--%>
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>姓名</th>
                                <th>姓名</th>
                                <th>邮箱</th>
                                <th>电话</th>
                                <th>邮编</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                for(int i=0; i<subss.size(); i++) {
                                Subs subs = subss.get(i);
                            %>
                            <tr style="height: 40px">
                                <td><%= subs.getId() %></td>
                                <td><%= subs.getUsername() %></td>
                                <td><%= subs.getRealname() %></td>
                                <td><%= subs.getEmail() %></td>
                                <td><%= subs.getPhone() %></td>
                                <td><%= subs.getPostal() %></td>
                                    <%--                                <td><a href="findUserById?id=<%=subs.getId()%>"> 更新 </a>  <a href="javascript:deleteUser(<%= subs.getId() %>)">删除</a></td>--%>
                                <td>
                                        <%--                                        <form action=--%>
                                    <button class="btn btn-primary" id="emp_edit_modal_btn" onclick=location.href="findsubsbyid?id=<%=subs.getId()%>">更新</button>
                                    <button class="btn btn-sm btn-danger deleteBtn" onclick=location.href="subsdelete?id=<%= subs.getId() %>">删除</button>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="text-center">
                共<%=p.getTotalRow()%>条
                <%=p.getPageNow() %> / <%= p.getTotalPage() %>
                <a href="findUserPageable?pageNow=<%=  p.getPageNow() - 1 %>">上一页</a>
                <a href="findUserPageable?pageNow=<%=  p.getPageNow() + 1 %>">下一页</a>
            </div>
        </c:if>
</div>

</body>
</html>
