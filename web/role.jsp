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
        $(function () {
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
                    title: '权限编号',
                    align: 'center',
                }, {
                    field: 'name',
                    title: '角色名称',
                    align: 'center',
                }, {
                    field: 'jName',
                    title: '角色权限',
                    align: 'center',
                }, {
                    field: 'jS',
                    title: '角色描述',
                    align: 'center',

                }, {
                    field: 'id',
                    title: '操作',
                    align: 'center',
                    formatter: function (value, row, index) {
                        return '<button class="btn btn-primary btn-lg" type="button"  onclick="seleteone(' + value + ')">修改</button>' +
                            '<button class="btn btn-primary btn-lg  col-sm-offset-1" type="button" onclick="deletone(' + value + ')">删除</button>'
                    }

                }]
            });

        });

        function updateone() {
            var id = $("#id").val();
            var rid = $("#name1").val();
            var name = $("#name2").val();
            var jName = $("#jName").val();
            var jS = $("#jS").val();
            $('.close').click();
            $.ajax({
                type: "POST",
                url: "newLoginservlet?type=updateone",
                data: {id: id, rid: rid, name: name, jName: jName, jS: jS},
                // dataType: "JSON",
                success: function (msg) {
                    $("#tab1").bootstrapTable("refresh");
                    $("#tab2").bootstrapTable("refresh");
                }
            });

        }


        function seleteone(id) {
            $("#myModal").modal("show");
            $.ajax({
                type: "POST",
                url: "newLoginservlet",
                data: 'type=seleteone&id=' + id,
                dataType: "JSON",
                success: function (msg) {
                    console.log(msg);
                    // alert(msg.length);
                    $("#id").val(msg.id);
                    $("#name1").val(msg.rid);
                    $("#name2").val(msg.name);
                    $("#jName").val(msg.jName);
                    $("#jS").val(msg.jS);
                    // $("#img").val(msg.img);
                }
            });
        }


        function deletone(id) {
            $.ajax({
                type: "POST",
                url: "newLoginservlet",
                data: 'type=deletone&id='+id,
                success: function (msg) {
                    $("#tab1").bootstrapTable("refresh");
                    $("#tab2").bootstrapTable("refresh");
                }
            });
        }

        function showAll() {
            $("#div2").html('');
            var tab1 = document.createElement('table');
            tab1.id = 'tab1';
            tab1.className = 'table table-bordered';
            $("#div1").append(tab1);
            $("#tab1").bootstrapTable({
                url: "newLoginservlet?type=getAllroles",    //请求后台的URL（*）
                method: 'post',                                      //请求方式（*）
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                search: false,
                showColumns: false,                //是否显示所有的列
                pageSize: 5,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）

                columns: [{
                    field: 'rid',
                    title: '权限编号',
                    align: 'center',
                }, {
                    field: 'name',
                    title: '角色名称',
                    align: 'center',
                }, {
                    field: 'jName',
                    title: '角色权限',
                    align: 'center',
                }, {
                    field: 'jS',
                    title: '角色描述',
                    align: 'center',

                }, {
                    field: 'id',
                    title: '操作',
                    align: 'center',
                    formatter: function (value, row, index) {
                        return '<button class="btn btn-primary btn-lg" type="button"  onclick="seleteone(' + value + ')">修改</button>' +
                            '<button class="btn btn-primary btn-lg  col-sm-offset-1" type="button" onclick="deletone(' + value + ')">删除</button>'
                    }
                }]
            });
        }


        function search() {
            var j = 0;
            var rid = $("#rid").val();

            var rids = ["R001", "R002", "R003", "R004", "R005", "R006", "R007"];
            for (var i = 0; i < rids.length; i++) {
                if (rid == rids[i])
                    j = 1;
            }
            // if(rids.includes(rid)){}
            if (j == 1) {

                $("#div1").html('');
                $("#div2").html('');

                var tab2 = document.createElement('table');
                tab2.id = 'tab2';
                tab2.className = 'table table-bordered';
                $("#div2").append(tab2);
                $("#tab2").bootstrapTable({
                    url: "newLoginservlet?type=search&rid="+ rid,    //请求后台的URL（*）
                    method: 'post',                                      //请求方式（*）
                    cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                    pagination: true,                   //是否显示分页（*）
                    sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                    search: false,
                    showColumns: false,                //是否显示所有的列
                    pageSize: 5,                       //每页的记录行数（*）
                    pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）

                    columns: [{
                        field: 'rid',
                        title: '权限编号',
                        align: 'center',
                    }, {
                        field: 'name',
                        title: '角色名称',
                        align: 'center',
                    }, {
                        field: 'jName',
                        title: '角色权限',
                        align: 'center',
                    }, {
                        field: 'jS',
                        title: '角色描述',
                        align: 'center',

                    }, {
                        field: 'id',
                        title: '操作',
                        align: 'center',
                        formatter: function (value, row, index) {
                            return '<button class="btn btn-primary btn-lg" type="button"  onclick="seleteone(' + value + ')">修改</button>' +
                                '<button class="btn btn-primary btn-lg  col-sm-offset-1" type="button" onclick="deletone(' + value + ')">删除</button>'
                        }
                    }]
                });

            } else {
                alert("角色编码输入错误无法查询！");

            }
        }
    </script>
</head>

<body>

<div align="center" id="div0"><p align="center">
    <h1><strong>权限数据表</strong></h1>
    <button type="button" name="showAll" id="showAll" onclick="showAll()">查询全部</button>
    </p> </div>
<p align="left"><label name="">角色编号：</label>
    <input type="text" name="rid" id="rid">
    <button type="button" name="search" id="search" onclick="search()">查询</button>
</p>
<div align="center" id="div1">
    <table class="table table-bordered" id='tab1' align="center">
    </table>
</div>
<div align="center" id="div2">
        <table class="table table-bordered" id='tab2' align="center">
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

                <form id="form11" name="" method="post">
                    <div class="modal-body">
                        <label></label>
                        <input id="id" name="id" type="hidden">
                    </div>
                    <div class="modal-body">
                        <label>权限编号：</label>
                        <input id="name1" name="name1" type="text">
                    </div>
                    <div class="modal-body">
                        <label>角色名称：</label>
                        <input id="name2" name="name2" type="text">
                    </div>
                    <div class="modal-body">
                        <label>角色权限：</label>
                        <input id="jName" name="jName" type="text">
                    </div>
                    <div class="modal-body">
                        <label>权限描述：</label>
                        <input id="jS" name="jS" type="text">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default closee" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="updateone()">提交更改</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
</body>
</html>
