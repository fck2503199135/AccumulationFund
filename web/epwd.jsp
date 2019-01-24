<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/14 0014
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新用户修改密码</title>

    <link rel="stylesheet" type="text/css" href="bootstrap/js/bootstrap-table.min.css"/>


    <script src="bootstrap/js/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="bootstrap/js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>

    <link href="web/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="web/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="web/css/slide.css"/>
    <link rel="stylesheet" type="text/css" href="web/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="web/css/flat-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="web/css/jquery.nouislider.css">
</head>


<form action="newLoginservlet">
<body>
         <table align="center" style="margin-top: 40px;">

             <h4 align="center">新用户修改默认密码</h4>
             <tr><td>用户名：
                 <input type="hidden" name="type" value="epwd">
                 <input type="hidden" name="uid" value="${u1.uid}">
                 <input type="hidden" name="unumber" value="${u1.unumber}">
                </td>
                <td><input type="text" class="form-control" name="name"  value="${u1.uname}"></td>
             </tr>

             <tr><td>第一次登陆请重置密码：</td>
                 <td><input type="password" class="form-control" name="pwd1"></td>
             </tr>

             <tr><td></td><td></td>
                 <td><br><button type="submit" class="btn btn-primary btn-sm">提交更改</button></td></tr>
         </table>
</body>
</form>
</html>
