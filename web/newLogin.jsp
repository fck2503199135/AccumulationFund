<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/14 0014
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="./bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="./bootstrap/js/bootstrap-table.min.css">
    <script src="./bootstrap/js/bootstrap.js"></script>
    <script src="./bootstrap/js/bootstrap-table.min.js"></script>
    <script src="./bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
    <script src="./bootstrap/js/jquery-2.1.4.js"></script>


</head>
<body>
<form >
   <table  align="center">
       <tr>
       <td>请输入用户名：</td>
       <td>
           <input  type="text"  name="uid" id="uid" >
       </td>
       </tr>
       <tr>
           <td>请输入密码：</td>
           <td><input  type="password"  name="pwd" id="pwd"></td>
       </tr>

       <tr>
           <td><button type="button" onclick="login()">登陆</button></td>
           <td><button type="button" onclick="cl()">清除</button></td>
       </tr>
   </table>
</form>
<script type="text/javascript">
    function login() {
        var uid=$("#uid").val();
        var pwd=$("#pwd").val();
        $.ajax({
            type: "POST",//方法类型
            url: "newLoginservlet?type=init",//url
            data: {uid:uid,pwd:pwd},
            success:function (msg) {
                if (msg == "success") {
                    window.location.href = "index.jsp"
                } else if (msg == "ed") {
                    window.location.href = "epwd.jsp"
                } else if (msg == "logout") {
                    window.location.href = "newLogin.jsp"
                } else if (msg == "fail") {
                    alert("密码错误登陆失败")
                }
            }
        });
    }
    function cl(){
        $("#uid").val("");//清除
        $("#pwd").val("");
    }

</script>
</body>
</html>
