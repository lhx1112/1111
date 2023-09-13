<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/19
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发送邮件</title>
</head>
<body style="background-image: url(/images/background/back2.png)">
<h1 style="position:absolute;left: 42%">发送邮件界面</h1>
<%--enctype="multipart/form-data"注意此属性设置,此属性是表单上传文件必不可少的参数--%>
<form action="sendEmailServlet" method="post" enctype="multipart/form-data" style="position:absolute;left: 38%;top: 16%;" >
    收件人：<input type="text" name="receive_email"/><br><br>
    主标题：<input type="text" name="title"><br><br>
    添加附件：<input type="file" name="attachment"><br>
    正文：<input type="text" style="width: 300px;height: 320px"  name="content"><br>

    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
