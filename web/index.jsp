<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/1/21
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="杭州公积金，杭州公积金">
    <meta name="keywords" content="杭州公积金 杭州 公积金 ">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>杭州公积金后台管理</title>
    <script src="web/js/jquery.min.js"></script>
    <script src="web/js/bootstrap.min.js"></script>
    <script>
        $(function () {


            $("#userName").click(function () {

                $("#logout").slideToggle()

            })

            $("#management").click(function () {

                $(".manage").slideToggle(600);
            })


            $("#cout").click(function () {

                $(".rc").slideToggle(500);



            })


            $("#show").click(function () {


                $(".sow").slideToggle(500);



            })


            $(".meun-item").click(function () {
                $(".meun-item").removeClass("meun-item-active");
                $(this).addClass("meun-item-active");
                var itmeObj = $(".meun-item").find("img");
                itmeObj.each(function () {
                    var items = $(this).attr("src");
                    items = items.replace("_grey.png", ".png");
                    items = items.replace(".png", "_grey.png")
                    $(this).attr("src", items);
                });
                var attrObj = $(this).find("img").attr("src");
                ;
                attrObj = attrObj.replace("_grey.png", ".png");
                $(this).find("img").attr("src", attrObj);
            });
            $("#topAD").click(function () {
                $("#topA").toggleClass(" glyphicon-triangle-right");
                $("#topA").toggleClass(" glyphicon-triangle-bottom");
            });
            $("#topBD").click(function () {
                $("#topB").toggleClass(" glyphicon-triangle-right");
                $("#topB").toggleClass(" glyphicon-triangle-bottom");
            });
            $("#topCD").click(function () {
                $("#topC").toggleClass(" glyphicon-triangle-right");
                $("#topC").toggleClass(" glyphicon-triangle-bottom");
            });
            $(".toggle-btn").click(function () {
                $("#leftMeun").toggleClass("show");
                $("#rightContent").toggleClass("pd0px");
            })
        })


    </script>
    <!--[if lt IE 9]>
    <script src="web/js/html5shiv.min.js"></script>
    <script src="web/js/respond.min.js"></script>
    <![endif]-->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="web/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="web/css/slide.css"/>
    <link rel="stylesheet" type="text/css" href="web/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="web/css/flat-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="web/css/jquery.nouislider.css">
    <link rel="stylesheet" type="text/css" href="web/css/style.css">
</head>

<body>
<div id="wrap">


    <!-- 左侧菜单栏目块 -->
    <div class="leftMeun" id="leftMeun">
        <div id="logoDiv">
            <p id="logoP"><img id="logo" alt="杭州公积金" src="images/logo.png"><span>杭州公积金</span></p>
        </div>

        <div class="meun-title">账号管理</div>


        <!-- 审核 -->
        <p style="margin-left: 20px">
            <a class="meun-item" aria-controls="char" target="right" id="show">
                <img src="images/icon_chara_grey.png">主页</a></p>

        <p style="margin-left: 30px;display: none" class="sow">
            <a class="meun-item" href="credit.html" aria-controls="char" target="right">
                <img src="images/icon_chara_grey.png">征信查询</a></p>
        <p style="margin-left: 30px;display: none" class="sow">
            <a class="meun-item" href="review.html" aria-controls="char" target="right">
                <img src="images/icon_chara_grey.png">审核查询</a></p>


        <p style="margin-left: 20px">
            <a class="meun-item" href="Organization.html" aria-controls="char" target="right" id="management">
                <img src="images/icon_chara_grey.png">组织机构管理</a></p>

        <p style="margin-left: 30px;display: none" class="manage">
            <a class="meun-item" href="Dept.html" aria-controls="char" target="right">
                <img src="images/icon_chara_grey.png">部门管理</a></p>
        <p style="margin-left: 30px;display: none" class="manage">
            <a class="meun-item" href="post.html" aria-controls="char" target="right">
                <img src="images/icon_chara_grey.png">岗位管理</a></p>
        <p style="margin-left: 30px;display: none" class="manage">
            <a class="meun-item" href="member.html" aria-controls="char" target="right">
                <img src="images/icon_chara_grey.png">岗位成员管理</a></p>

        <p style="margin-left: 20px">
            <a class="meun-item" href="#user" aria-controls="user" role="tab" data-toggle="tab"><img
                    src="images/icon_user_grey.png">用户管理
            </a></p>
        <p style="margin-left: 20px">
            <a class="meun-item" href="" ><img
                    src="images/icon_change_grey.png">修改密码
            </a>
        </p>


        <!-- 统计数据 -->
        <p style="margin-left: 20px">
            <a class="meun-item" href="#data" aria-controls="user" role="tab" data-toggle="tab" id="cout">
                <img src="images/icon_user_grey.png">统计数据
            </a>
        </p>
        <p style="margin-left: 30px;display: none" class="rc">
            <a class="meun-item" href="count.html" aria-controls="char" target="right">
                <img src="images/icon_chara_grey.png">统计查询报表</a></p>


        <!--<div class="meun-title">地区管理</div>-->
        <!--<div class="meun-item" href="#scho" aria-controls="scho" role="tab" data-toggle="tab"><img-->
        <!--src="images/icon_house_grey.png">地区管理-->
        <!--</div>-->
        <!--<div class="meun-item" href="#regu" aria-controls="regu" role="tab" data-toggle="tab"><img-->
        <!--src="images/icon_rule_grey.png">规则管理-->
        <!--</div>-->
        <!--<div class="meun-item" href="#stud" aria-controls="stud" role="tab" data-toggle="tab"><img-->
        <!--src="images/icon_card_grey.png">人员信息-->
        <!--</div>-->
        <!--<div class="meun-item" href="#sitt" aria-controls="sitt" role="tab" data-toggle="tab"><img-->
        <!--src="images/icon_char_grey.png">座位管理-->
        <!--</div>-->
    </div>
    <!-- 右侧具体内容栏目 -->
    <div id="rightContent">
        <a class="toggle-btn" id="nimei">
            <i class="glyphicon glyphicon-align-justify"></i>
        </a>

        <div class="tab-content tab-nav">
            <div id="personInfor" class="dropdown-toggle">

                <p id="userName">
                    欢迎用户: AAA
                    <img src="images/boy-3.png" alt="头像图片" height="46" class="img-circle">
                    <span class="caret"></span>
                </p>

                <p id="logout" style="display: none">
                    <a href="login.jsp">退出登录</a> <br>
                    <a href="#">注销</a> <br>
                </p>

            </div>
        </div>
        <!-- Tab panes -->
        <div class="tab-content">

            <iframe src="a.html" name="right" class="" style="width: 100%;height:1000px"></iframe>


        </div>
    </div>
</div>
<!-- 滑块js -->
<!--	<script type="text/javascript">
        scale = function(btn, bar, title, unit) {
                this.btn = document.getElementById(btn);
                this.bar = document.getElementById(bar);
                this.title = document.getElementById(title);
                this.step = this.bar.getElementsByTagName("div")[0];
                this.unit = unit;
                this.init();
        };
        scale.prototype = {
                init: function() {
                        var f = this,
                                g = document,
                                b = window,
                                m = Math;
                        f.btn.onmousedown = function(e) {
                                var x = (e || b.event).clientX;
                                var l = this.offsetLeft;
//						var max = f.bar.offsetWidth - this.offsetWidth;
                                var max = f.bar.offsetWidth-20 ;
                                g.onmousemove = function(e) {
                                        var thisX = (e || b.event).clientX;
                                        var to = m.min(max, m.max(-2, l + (thisX - x)));
                                        f.btn.style.left = to+ 'px';
                                        f.ondrag(m.round(m.max(0, to / max) * 100), to);
                                        b.getSelection ? b.getSelection().removeAllRanges() : g.selection.empty();
                                };
                                g.onmouseup = new Function('this.onmousemove=null');
                        };
                },
                ondrag: function(pos, x) {
                        this.step.style.width = Math.max(0, x) +2+ 'px';
                        this.title.innerHTML = pos / 10 + this.unit + "";
                }
        }
        new scale('btn0', 'bar0', 'title0', "分钟");
        new scale('btn1', 'bar1', 'title1', "分钟");
        new scale('btn2', 'bar2', 'title2', "天");
        new scale('btn3', 'bar3', 'title3', "次");
</script>
-->
<script src="js/jquery.nouislider.js"></script>

<!-- this page specific inline scripts -->
<script>
    //min/max slider
    function huadong(my, unit, def, max) {
        $(my).noUiSlider({
            range: [0, max],
            start: [def],
            handles: 1,
            connect: 'upper',
            slide: function () {
                var val = Math.floor($(this).val());
                $(this).find(".noUi-handle").text(
                    val + unit
                );
                console.log($(this).find(".noUi-handle").parent().parent().html());
            },
            set: function () {
                var val = Math.floor($(this).val());
                $(this).find(".noUi-handle").text(
                    val + unit
                );
            }
        });
        $(my).val(def, true);
    }

    huadong('.slider-minmax1', "分钟", "5", 30);
    huadong('.slider-minmax2', "分钟", "6", 15);
    huadong('.slider-minmax3', "分钟", "10", 60);
    huadong('.slider-minmax4', "次", "2", 10);
    huadong('.slider-minmax5', "天", "3", 7);
    huadong('.slider-minmax6', "天", "8", 10);
</script>
</body>

</html>
