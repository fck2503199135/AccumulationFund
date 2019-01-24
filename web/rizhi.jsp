<%--
  Created by IntelliJ IDEA.
  User: Ss.Polaris
  Date: 2019/1/14
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="./bootstrap/js/bootstrap-table.min.css">
    <link rel="stylesheet" href="./bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="./bootstrap/css/bootstrap.css">

    <script src="./jq/jquery-3.2.0.min.js"></script>
    <script src="./bootstrap/js/bootstrap.js"></script>
    <script src="./bootstrap/js/bootstrap-table.min.js"></script>
    <script src="./bootstrap/js/bootstrap-table-zh-CN.min.js"></script>

    <script type="text/javascript">
      function logout() {
        var uid=$("#uid").val();
        $.ajax({
          type: "POST",//方法类型
          url: "newLoginservlet?type=logout",//url
          data:{uid:uid},
          success:function (msg){
                 window.location.href="Login.jsp";
          }
        });
      }

      $(function() {
        $("#tab").bootstrapTable({
          url: "newLoginservlet?type=getAll",    //请求后台的URL（*）
          method: 'post',                      //请求方式（*）
          cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
          pagination: true,                   //是否显示分页（*）
          sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
          pageSize: 5,                       //每页的记录行数（*）
          pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
          columns: [{
            field: 'uid',
            title: '编号',
            align: 'center',
          }, {
            field: 'uname',
            title: '访客名称',
            align: 'center',
          }, {
            field: 'unumber',
            title: '登陆次数',
            align: 'center',
          },{
            field: 'logintime',
            title: '访客开始时间',
            align: 'center',
          // }, {
          //   field: 'img',
          //   title: '图片',
          //   align: 'center',
          //   formatter: function (value, row, index) {
          //
          //     return '<img src=' + value + ' height=' + 40 + '>'
          //   }
          }, {
            field: 'logouttime',
            title: '访客结束时间',
            align: 'center',
          }, {
            field: 'uid',
            title: '操作',
            align: 'center',
            formatter: function (value, row, index) {

              return '<button class="btn btn-primary btn-lg" type="button"  onclick="seleteone(' + value + ')">查看详情</button>'


            }

          }]
        });

      });
    </script>
  </head>

  <body>

  <div class="container">
    <p align="center"><strong>登陆数据表</strong></p>
      <table class="table table-bordered" id='tab' align="center">

      </table>
  </div>

  <form>
  <div align="center">
    <button type="button" id="id1" onclick="logout()">
      退出</button>
    <input type="hidden" name="UserId" id="uid" value="${u1.uid}">
  </div>
  </form>
  </body>

</html>
