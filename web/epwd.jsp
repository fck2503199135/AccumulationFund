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
    <title>Title</title>
</head>
<form action="newLoginservlet">
<body>
         <table align="center">
             <tr><td>用户名：
                 <input type="hidden" name="type" value="epwd">
                 <input type="hidden" name="uid" value="${u1.uid}">
                 <input type="hidden" name="unumber" value="${u1.unumber}">
                </td>
                <td><input type="text" name="name"  value="${u1.uname}"></td>
             </tr>

             <tr><td>第一次登陆请重置密码：</td>
                 <td><input type="password" name="pwd1"></td>
             </tr>

             <tr><td><button type="submit">提交更改</button></td><td></td></tr>
         </table>
</body>
</form>
</html>
