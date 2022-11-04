<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title> 新能源二手车后台管理系统</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<input style="display: none" id="usersession" value="1">
<input style="display: none" id="dlsession" value="">
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">

                                        <strong class="font-bold">咸鱼新能源二手车后台管理系统</strong>
                                    </span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">
                        admin
                    </div>
                </li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">用户管理</span>
                </li>
                <li>
                    <a class="J_menuItem" href="welcome.jsp">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">主页</span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <i class="fa fa-group"></i>
                        <span class="nav-label">用户管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="">用户账号禁用</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="">用户密码修改</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="">用户信息搜索</a>
                        </li>
                    </ul>
                </li>
                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">车辆管理</span>
                </li>
                <li>
                <li>
                    <a href="#">
                        <i class="fa fa-calendar"></i>
                        <span class="nav-label">车辆管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="addCar.jsp">添加车辆</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="carlist.jsp">车辆列表</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-pencil-square-o"></i>
                        <span class="nav-label">预约管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="sellcarreserve.jsp">卖车预约</a>
                            <a class="J_menuItem" href="lookcarreserve.jsp">看车预约</a>

                        </li>
                    </ul>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-cogs"></i>
                        <span class="nav-label">推送管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="pushcar.jsp">推送车辆</a>
                            <a class="J_menuItem" href=""></a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-cogs"></i>
                        <span class="nav-label">订单管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="">订单编辑</a>
                            <a class="J_menuItem" href="orderselect.jsp">订单查询</a>
                        </li>
                    </ul>
                </li>

                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">奖励纪录</span>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-pencil-square-o"></i>
                        <span class="nav-label">奖励纪录</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="">会员奖励记录</a></li>
                        <li><a class="J_menuItem" href="">会员每日奖励记录</a></li>
                    </ul>
                </li>


                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">劵管理</span>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-pencil-square-o"></i>
                        <span class="nav-label">会员券管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="">代金券</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="">优惠券</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="">重消券</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="">购物券</a>
                        </li>

                    </ul>
                </li>
                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">信息管理</span>
                </li>

                <li>
                    <a href="">
                        <i class="fa fa-pencil-square-o"></i>
                        <span class="nav-label">文章管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="">文章列表</a></li>
                        <li><a class="J_menuItem" href="">添加文章</a></li>
                    </ul>
                </li>

                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">提现管理</span>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-pencil-square-o"></i>
                        <span class="nav-label">提现管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="">提现记录</a></li>
                        <li><a class="J_menuItem" href="">提现设置</a></li>
                    </ul>
                </li>


                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">每日返现管理</span>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-pencil-square-o"></i>
                        <span class="nav-label">返现记录</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="">每日返现记录</a></li>

                    </ul>
                </li>

                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">支付管理</span>
                </li>

                <li>
                    <a href="">
                        <i class="fa fa-pencil-square-o"></i>
                        <span class="nav-label">支付管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="">支付宝设置</a></li>
                        <li><a class="J_menuItem" href="">微信设置</a></li>

                    </ul>
                </li>



                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">加盟店管理</span>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-pencil-square-o"></i>
                        <span class="nav-label">加盟店管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="">添加加盟店</a></li>
                        <li><a class="J_menuItem" href="">加盟店列表</a></li>
                        <li><a class="J_menuItem" href="">加盟店业绩</a></li>
                    </ul>
                </li>




                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">其他管理</span>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-pencil-square-o"></i>
                        <span class="nav-label">参数设置</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="canshushezhi.html">参数设置</a></li>

                    </ul>

                </li>

                <li>
                    <a href="#">
                        <i class="fa fa-cogs"></i>
                        <span class="nav-label">系统管理员</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="">添加管理员</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="">管理员列表</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-calendar"></i>
                        <span class="nav-label">广告管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="">banner 广告位列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="">手机banner 广告位列表</a>
                        </li>
                    </ul>
                </li>


                <li class="line dk"></li>
                <li>&nbsp;&nbsp;</li>
                <li>&nbsp;&nbsp;</li>
                <li>&nbsp;&nbsp;</li>
                <li>&nbsp;&nbsp;</li>
                <li>&nbsp;&nbsp;</li>
                <li>&nbsp;&nbsp;</li>
            </ul>
        </div>
    </nav>
<script>
//注销用户
function loginoutUser() {
    if(confirm("是否要注销此用户")){
        location.href="loginout.do";
    }
}
</script>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
                </div>

                <ul class="nav navbar-top-links navbar-right">

                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="" href="javascript:loginoutUser()" title="退出">
                            admin  <i class="fa fa-power-off"></i> <span class="label label-warning"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages" style="width: 100px;padding: 0px;">
                        </ul>
                    </li>


                </ul>
            </nav>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe id="J_iframe" width="100%" height="100%" src="welcome.jsp" frameborder="0" data-id="welcome.jsp" seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
</div>

<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/jquery.metisMenu.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<script src="js/layer.min.js"></script>

<!-- 自定义js -->
<script src="js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        var usersession=$("#usersession").val();
        var dlsession=$("#dlsession").val();
        if(usersession==null|dlsession==null){
            window.location.href="login.jsp";
        }
    });
</script>
<!-- 第三方插件 -->
<script src="js/plugins/pace/pace.min.js"></script>

</body>

</html>