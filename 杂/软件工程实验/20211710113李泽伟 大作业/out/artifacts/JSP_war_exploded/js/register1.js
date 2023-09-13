
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

function checkForm(){
    if(checkUserPass()&&checkphone()&&checkpassword()&&checkpostal()){
        return true;
    }else{
        return false;
    }
}
// //用户名非空验证+长度验证+合法性验证
// //密码非空验证+确认验证+长度验证
// function checkUserPass(){
//     var name = document.myform.username;
//     //用户名输入合法性验证
//     for(var i=0;i<name.value.length;i++)
//     {
//         var charTest=name.value.toLowerCase().charAt(i);
//         if( (!(charTest>='0' && charTest<='9')) &&  (!(charTest>='a' && charTest<='z')))
//         {
//             alert("用户名只能包括 a-z、0-9");
//             name.select();
//             return false;
//         }
//     }
//     var pass=document.myform.password;
//     if(pass.value.length<6||pass.value.length>12){
//         alert("密码长度需为6-12个字符");
//         pass.select();
//         return false;
//     }
//     for(var i=0;i<pass.value.length;i++)
//     {
//         var charTest=pass.value.toLowerCase().charAt(i);
//         if( (!(charTest>='0' && charTest<='9')) &&  (!(charTest>='a' && charTest<='z')))
//         {
//             alert("密码只能包括 a-z、0-9");
//             name.select();
//             return false;
//         }
//     }
//
//     return true
// }
// //20211710113李泽伟
// function checkpassword() {
//     var pass=document.myform.password;
//     var checkpass=document.myform.passworded;
//     if(pass.value!==checkpass.value){
//         alert("两次密码不一致");
//         checkpass.select();
//         return false;
//     }
//
//     return true
// }
// function checkphone(){
//     var strphone =document.myform.phone;
//     var pattern = /^(13|14|15|17|18)\d{9}$/;
//     if(!pattern.test(strphone.value))
//     {
//         alert('请输入格式正确的中国大陆11位手机号');
//         strphone.select();
//         return false;
//     }
//     return true
// }
// function checkpostal(){
//     var strpostal =document.myform.postal;
//     var pattern =/^[1-9][0-9]{5}$/;
//     if(!pattern.test(strpostal.value))
//     {
//         alert('请输入正确的邮政编码');
//         strpostal.select();
//         return false;
//     }
//     return true
// }
