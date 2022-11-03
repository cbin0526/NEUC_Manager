<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2022/10/31
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 数据表格</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- Data Tables -->
    <link href="css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- Sweet Alert -->
    <link href="css/sweetalert.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/laydate.css">
    <link type="text/css" rel="stylesheet" href="css/laydate1.css">
    <script src="js/jquery-1.7.2.min_1.js"></script>
</head>
<script>


</script>
<script>
    /**
     * 页面加载后显示
     */
    $(document).ready(function () {

        allReserve(1, 3);
    })
    /**
     * 获取所有车辆
     * @param page
     * @param size
     */
    function allReserve(page, size) {
        var user_name=document.getElementById("user_name").value;
        var reserve_phone=document.getElementById("reserve_phone").value;
        var reserve_date=document.getElementById("reserve_date").value;
        var car_name=document.getElementById("car_name").value;
        var reserv_status=document.getElementById("reserv_status").value;

//发起ajax请求
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "getReserve.do",
            data: {user_name:user_name,reserve_phone:reserve_phone,reserve_date:reserve_date,car_name:car_name,reserv_status:reserv_status,
                page: page, size: size},
            success: function (msg) {
                // alert(msg);
                var content=msg.olist;
                var maxPage=msg.maxPage;
                var str="";
                for (var i=0;i<content.length;i++){


                    // alert(msg);
                    str=str+'<tr class="gradeX">' +
                        ' <td>'+content[i].user_name+'</td>' +
                        '<td>'+content[i].reserve_phone+'</td>' +
                        '<td>'+content[i].reserve_date+'</td>' +
                        '<td>'+content[i].car_name+'</td>' +
                        '<td>'+content[i].reserv_status+'</td>' +

                        '<td style="text-align: center;">' +
                        '<a class="btn btn-white btn-bitbucket" title="编辑" href="javascript:editReserve(\''+content[i].reserve_id+'\')">' +
                        '<i class="fa fa-pencil-square-o" aria-hidden="true"></i>' +
                        '</a>' +
                        '<input type="hidden" value="123"/>' +
                        '<a class="btn btn-white btn-bitbucket delete" title="删除"  href="#">' +
                        '<i class="fa fa-trash-o" aria-hidden="true" ></i>' +
                        '</a>' +
                        '</td>' +
                        '</tr>' ;
                }

                $("#myreserve").html(str);

                //上一页/下一页
                var str1=
                    '<a href="javascript:allSession(1,' +size
                    + ')">首页</a>&nbsp;&nbsp;&nbsp;'+
                    '<a href="javascript:allSession('+(page-1)+',' + size
                    + ')">上一页</a>&nbsp;&nbsp;&nbsp;'+
                    // + '<span id="myspan"></span>'+
                    '<a href="javascript:allSession('+(page+1)+',' + size
                    + ')">下一页</a>&nbsp;&nbsp;&nbsp;'+
                    '<a href="javascript:allSession('+maxPage+',' + size
                    + ')">尾页</a>';

                $("#myindex").html(str1);


            }
        });
    }
</script>
<script>
    function editReserve(id) {
        location.href="getReserveById.do?rid="+id;
    }
</script>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>车辆列表</h5>

                    <div class="ibox-tools">
                        <a href="product_edit.jsp">
                            <button type="button"  class="btn btn-default btn-xs">添加</button>
                        </a>
                    </div>
                </div>
                <div class="ibox-tools" style="margin-top: 0px;float: left;">
                    <form   method="post" role="form" class="form-inline">
                        <input type="hidden" name="" value=""/>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input  id="user_name" placeholder="预约用户" name="user_name" style="height: 29px;width: 120px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text"  id="reserve_phone" placeholder="预约电话" name="reserve_phone" style="height: 29px;width: 120px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="预约时间" id="reserve_date" name="reserve_date" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text"  placeholder="预约车辆" id="car_name" name="car_name"  style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="预约状态"  id="reserv_status" name="reserv_status" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="checkbox m-l m-r-xs" style="margin-left: 0px; margin-top:5px;">
                            <input class="btn btn-white" type="button" onclick="javascript:allReserve(1,3)" value="查询"></input>
                        </div>
                    </form>
                </div>
                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>预约用户</th>
                            <th>预约电话</th>
                            <th>预约时间</th>
                            <th>预约车辆</th>
                            <th>预约状态</th>

                            <th style="text-align: center;">操作</th>
                        </tr>
                        </thead>
                        <tbody id="myreserve">

                        </tbody>

                    </table>
                    <div align="center" id="myindex">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/jquery.jeditable.js"></script>
<!-- Data Tables -->
<!-- 页面 分页 -->

<script src="js/dataTables.bootstrap.js"></script>
<!-- 自定义js -->
<script src="js/content.js?v=1.0.0"></script>
<!-- Page-Level Scripts -->


</body>

</html>

