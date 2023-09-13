$(function() {
    /*密码验证*/
    $("#password").blur(function () {
        console.log(1);
        var reg = /^[a-zA-Z0-9]{6,12}$/;
        if($(this).val()!=""){
            if (reg.test($(this).val()) == false){
                $("#password_pro").html("密码格式不正确，请重新输入")
            } else {
                $("#password_pro").html("")
            }
        }else {
            $("#password_pro").html("密码由英文字母和数字组成的6—12位字符")
        }
    });
})
