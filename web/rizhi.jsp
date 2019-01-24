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
          },
          // }, {
          //   field: 'img',
          //   title: '图片',
          //   align: 'center',
          //   formatter: function (value, row, index) {
          //
          //     return '<img src=' + value + ' height=' + 40 + '>'
          //   }
          {
            field: 'uname',
            title: '操作',
            align: 'center',
            formatter: function (value, row, index) {

              return '<button class="btn btn-primary btn-lg" type="button"  onclick="seletesm(this)">查看详情</button>'
            }
          }]
        });
      });



      function seletesm(btn) {
          var uname = btn.parentNode.parentNode.children[1].innerHTML;
          alert(uname);
          $("#myModal").modal("show");

        $("#div3").html('');
        var tab3 = document.createElement('table');
        tab3.id = 'tab3';
        tab3.className = 'table table-bordered';
        $("#div3").append(tab3);
        $("#tab3").bootstrapTable("refresh");
          $("#tab3").bootstrapTable({
          url: "newLoginservlet?type=seletesm&uname="+uname,    //请求后台的URL（*）
          method: 'post',                                      //请求方式（*）
          cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
          pagination: true,                   //是否显示分页（*）
          sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
          search: false,
          showColumns: false,                //是否显示所有的列
          pageSize: 5,                       //每页的记录行数（*）
          pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
          columns: [{
            field: 'uid',
            title: '登陆编号',
            align: 'center',
          }, {
            field: 'uname',
            title: '用户名称',
            align: 'center',
          },{
            field: 'starttime',
            title: '登陆开始时间',
            align: 'center',
          }, {
            field: 'endtime',
            title: '登陆结束时间',
            align: 'center',
          }, {
            field: 'ipaddress',
            title: 'IP地址',
            align: 'center',
            // formatter: function (value, row, index) {
            //  console.log(row)
            // }

          }]
        });


      }
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

  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">登陆详情</h4>
        </div>
        <div class="modal-body" id="div3">

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" id="close1" data-dismiss="modal">关闭</button>

        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal -->
  </div>
  </body>
</html>
