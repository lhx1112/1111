<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/register.css?v=<%=System.currentTimeMillis()%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="js/register1.js"></script>
    <script type="text/javascript">
        $(function() {

            // 初始化省市区
            initAddress();

            // 更改省份后的操作
            $("select[name='province']").change(function() {

                var provCode = $("select[name='province']").val();

                getCity(provCode);

            });

            // 更改城市后的操作
            $("select[name='city']").change(function() {
                var cityCode = $("select[name='city']").val();
                getArea(cityCode);
            });

        });

        function initAddress() {

            var firstProvCode;
            // ajax请求所有省份
            $.get("AddressServlet", {
                method : "initProvince"
            }, function(data) {

                $.each(data, function(i, d) {
                    $("select[name='province']").append(
                        "<option value='"+d.code+"'>" + d.name
                        + "</option>");
                });

                // 获取第一个省份的code
                firstProvCode = data[0].code;
                console.log(firstProvCode)
                // 根据第一个省份code获取对应城市列表
                getCity(firstProvCode);
            }, 'json');

        }

        //获取对应城市列表（里面包括获取第一个城市的区县列表）
        function getCity(provCode) {

            var firstCityCode;

            // ajax请求所有市级单位
            $.get("AddressServlet", {
                method : "getCity",
                provCode : provCode
            }, function(data) {

                // 先清空城市下拉框
                $("select[name='city']").empty();

                $.each(data, function(i, d) {
                    $("select[name='city']").append(
                        "<option value='"+d.code+"'>" + d.name
                        + "</option>");
                });

                // 获取第一个城市的code
                firstCityCode = data[0].code;
                // 根据第一个城市code获取对应区县列表
                getArea(firstCityCode);

            }, 'json');
        }

        function getArea(cityCode) {

            // ajax请求所有区县单位
            $.get("AddressServlet", {
                method : "getArea",
                cityCode : cityCode
            }, function(data) {

                // 先清空区县下拉框
                $("select[name='area']").empty();
                $.each(data, function(i, d) {
                    $("select[name='area']").append(
                        "<option value='"+d.code+"'>" + d.name
                        + "</option>");
                });
            }, 'json');
        }

        $(function() {
            $("#pwd").blur(function () {
                var reg = /^[a-zA-Z0-9]{6,12}$/;
                if($(this).val()!=""){
                    if (reg.test($(this).val()) == false){
                        $("#pwd_prompt").html("密码格式不正确，请重新输入")
                    } else {
                        $("#pwd_prompt").html("")
                    }
                }else {
                    $("#pwd_prompt").html("密码由英文字母和数字组成的6—12位字符")
                }
            });
            $("#re").blur(function () {

                if ($(this).val() != $("#pwd").val()){
                    $("#repwd_prompt").html("两次输入的密码不一致")
                } else {
                    $("#repwd_prompt").html("")
                }
            });
            /*验证手机号码*/
            $("#phone").blur(function () {
                var reg=/^1[3-9]\d{9}$/;
                $("#phone_prompt").html("");
                if (reg.test($(this).val())==false) {
                    $("#phone_prompt").html("手机号码不正确，请重新输入")
                }
            });
        })
    </script>
</head>
<body class="body" background="images/background/back.jpg">
<div class="container">
    <form action="registerServlet" method="post" >
        <div class="header"style=" position: absolute;left: 40%">
            <h1 style="color: #a6e1ec;">用户注册界面</h1>
            <%
                String sessionerror=(String)session.getAttribute("registerError");
                if (sessionerror==null)
                    sessionerror="";
            %>
            <a style="color: yellow"><%=sessionerror%></a><br><br>
        </div>

        <div class="main"  style="position:absolute;left: 40%;top: 15%">
            <form style="color: black">
                <span><p id="input"></p></span>
                <span>
                    <input id= "user" type="text" name="user" placeholder="用户名" style="color: black" required></span>
                <br>
                <br>
                <span>
                    <input id="truename" type="text" name="truename" placeholder="真实姓名" style="color: black" required></span>
                <br>
                <br>
                <span>
                    <input id="sex" type="number" name="sex" placeholder="性别"  style="color: black" required><div id="sex_prompt"></div></span>
                <br>

                <span>
                    <input id="email" type="email" name="email" placeholder="邮箱" style="color: black" required><div id="email_prompt" ></div></span>
                <br>

                <span>
                    <input id="phone" type="text" name="phone" placeholder="手机号" style="color: black" required><div id="phone_prompt" ></div></span>
                <br>
                <select name="province"  style="color: black">
                    <option value="">--请选择省份--</option>
                </select>
                <select name="city"  style="color: black">
                    <option value="">--请选择城市--</option>
                </select>
                <select name="area"  style="color: black">
                    <option value="">--请选择区/县--</option>
                </select>
                <br>
                <br>
                <span>
                    <input id="postalcode" type="text" name="postalcode" placeholder="地区码"  style="color: black" required><div id="postalcode_prompt"></div></span>
                <br>

                <span>
                    <input id="pwd" type="password" name="pwd" placeholder="密码"  style="color: black" required><div id="pwd_prompt" ></div></span>
                <br>

                <span>
                    <input id="re" type="password" name="re" placeholder="确认密码" style="color: black" required><div id="repwd_prompt" ></div></span>
                <br>
                <br>

                <button  style="width:158px;height:40px;background-color: #8a6d3b">注 册</button>
                <br>
            </form>
        </div>
    </form>
    <div class="skip"><a href="login.jsp" style="color: yellow;position: absolute;left: 1px;top: 2px; font-size: 20px;" >我要返回登录</a></div>

</div>
</body>

</html>