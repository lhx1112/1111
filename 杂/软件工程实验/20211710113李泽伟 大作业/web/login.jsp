<%--
  Created by IntelliJ IDEA.
  User: along
  Date: 2021/11/11
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <script type="text/javascript" src="js/login1.js?v=<%=System.currentTimeMillis()%>"></script>
    <link rel="stylesheet" href="css/my_style.css?v=<%=System.currentTimeMillis()%>">
    <script type="text/javascript">
        //20211710113李泽伟
        function checkForm(){
            var password=document.myform.password;
            if(password.value.length<6||password.value.length>12){
                alert("密码格式不正确(6-12)");
                password.select();
                return false;
            }
            return true
        }
        </script>
</head>

<body class="body">
<form action="loginServlet" method="post" name="myform" onsubmit="return checkForm()">
    <div class="container">
        <div class="header">
            <h1>用户登录界面</h1>
            <%
                String sessionerror=(String)session.getAttribute("loginError");
                if (sessionerror==null)
                    sessionerror="";
            %>
            <a style="color: #afd9ee"><%=sessionerror%></a><br><br>
        </div>
        <div class="main">
                <span>
                    <input type="text" name="username" placeholder="账号" required>
                </span>
            <span>
                    <input id=password type="password" name="password" placeholder="密码" required>
                </span>
            <span>
                    <input type="text" id="my_text" name="check" placeholder="验证码" required>
                </span>
            <img id="checkCode" src="checkCodeServlet"/>
            <a id="change" href="">看不清换一张？</a>
            <button style="background-color: #a6e1ec">登&nbsp&nbsp&nbsp&nbsp录</button>

            <br>
            <a style="color: yellow; position: absolute;left: 45%;" href="register.jsp">我还没有账号，注册</a>
        </div>
    </div>
</form>

</body>

</html>
