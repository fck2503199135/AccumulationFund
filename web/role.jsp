<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/19 0019
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./bootstrap/js/bootstrap-table.min.css">
    <link rel="stylesheet" href="./bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
    <script src="./jq/jquery-3.2.0.min.js"></script>
    <script src="./bootstrap/js/bootstrap.js"></script>
    <script src="./bootstrap/js/bootstrap-table.min.js"></script>
    <script src="./bootstrap/js/bootstrap-table-zh-CN.min.js"></script>

    <script type="text/javascript">
        $(function() {
            $.post('newLoginservlet?type=getAllroles',data => {
                console.log(data);
            },'json');
            $("#tab1").bootstrapTable({
                url: "newLoginservlet?type=getAllroles",    //请求后台的URL（*）
                method: 'post',                      //请求方式（*）
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                search: false,
                showColumns: false,                //是否显示所有的列
                pageSize: 5,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                columns: [{
                    field: 'rid',
                    title: '编号',
                    align: 'center',
                }, {
                    field: 'name',
                    title: '角色名称',
                    align: 'center',
                }, {
                    field: 'jName',
                    title: '角色权限',
                    align: 'center',
                },{
                    field: 'jS',
                    title: '角色描述',
                    align: 'center',

                },{
                    field: 'id',
                    title: '操作',
                    align: 'center',
                    formatter: function (value, row, index) {
                        return '<button class="btn btn-primary btn-lg" type="button"  onclick="seleteone(' + value + ')">修改</button>'
                    }

                }]
            });

        });
    </script>

</head>

<body>
<div align="center">
    <p align="center"><h1><strong>权限数据表</strong></h1></p>
<table class="table table-bordered" id='tab1' align="center">
</table>
</div>




<div class="container">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">需要修改的数据</h4>
                </div>

                <form  id="form11" name="" method="post" enctype="multipart/form-data">
                    <div class="modal-body">
                        <label></label>
                        <input id="id" name="id" type="hidden">
                    </div>
                    <div class="modal-body">
                        <label>角色名：</label>
                        <input id="name1" name="name" type="text">
                    </div>
                    <div class="modal-body">
                        <label>权限名称：</label>
                        <input id="price" name="jname" type="text">
                    </div>
                    <div class="modal-body">
                        <label>权限描述：</label>
                        <input id="img"  name="js" type="text">
                    </div>
                    <div class="modal-footer">
                        <button type="button"  class="btn btn-default closee" data-dismiss="modal">关闭</button>

                        <button type="button" class="btn btn-primary" onclick="updateone()">提交更改</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
</body>
</html>
