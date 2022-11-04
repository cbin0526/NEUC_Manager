<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2022/10/31
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>卖车预约</title>
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

    $(document).ready(function () {
        getsell(1,3);
    });

    function getsell(page,size) {
          var sell_phone=document.getElementById("sell_phone").value;
          var sell_address=document.getElementById("sell_address").value;
          var sell_carname=document.getElementById("sell_carname").value;
          var sell_cardept=document.getElementById("sell_cardept").value;
          var sell_status=document.getElementById("sell_status").value;

          $.ajax({
              url:"getSellByKeys.do",
              type:"POST",
              data:{page:page,size:size,sell_phone:sell_phone ,sell_address:sell_address,sell_carname:sell_carname,sell_cardept:sell_cardept,sell_status:sell_status},
              dataType:"json",
              success:function (msg) {
                 if(msg.flag==1){
                     var str='';
                     var datalist=msg.data.olist;
                     for (var i=0;i<datalist.length;i++){
                         // alert(msg);
                         str=str+'<tr class="gradeX">' +
                             '<td>'+datalist[i].sell_phone+'</td>' +
                             '<td>'+datalist[i].sell_address+'</td>' +
                             '<td>'+datalist[i].sell_carname+'</td>' +
                             '<td>'+datalist[i].sell_cardept+'</td>' +
                             '<td>'+datalist[i].sell_status+'</td>' +
                             '<td style="text-align: center;">' +
                             '<a class="btn btn-white btn-bitbucket" title="沟通" href="javascript:communicate('+datalist[i].sell_id+')">' +
                             '<i class="fa fa-pencil-square-o" aria-hidden="true"></i>' +
                             '</a>' +
                             '<input type="hidden" value="123"/>' +
                             '<a class="btn btn-white btn-bitbucket delete" title="删除"  href="#">' +
                             '<i class="fa fa-trash-o" aria-hidden="true" ></i>' +
                             '</a>' +
                             '</td>' +
                             '</tr>' ;
                     }


                     var str1 = '<a href="javascript:getsell(1,' +msg.data.size
                         + ')">首页</a>&nbsp;&nbsp;&nbsp;'+
                         '<a href="javascript:getsell('+(msg.data.page-1)+',' + msg.data.size
                         + ')">上一页</a>&nbsp;&nbsp;&nbsp;'+
                         // + '<span id="myspan"></span>'+
                         '<a href="javascript:getsell('+(msg.data.page+1)+',' + msg.data.size
                         + ')">下一页</a>&nbsp;&nbsp;&nbsp;'+
                         '<a href="javascript:getsell('+msg.data.maxPage+',' + msg.data.size
                         + ')">尾页</a>'+
                         '<div>共&nbsp;&nbsp;'+msg.data.maxPage+'&nbsp;&nbsp;页&nbsp;&nbsp;当前第&nbsp;&nbsp;'+msg.data.page+'&nbsp;&nbsp;页'+
                         '</div>' ;

                     $("#selllist").html(str);
                     $("#pageandsize").html(str1);
                 }else if(msg.flag==0){
                     $("#selllist").html("查无数据！");
                 }
              }




          });
    }



</script>
<script>
    function communicate(sellid) {
        location.href="updateStatusById.do?sellid="+sellid;
    }
</script>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>卖车预约列表</h5>

                    <div class="ibox-tools">
                        <a href="">
                            <button type="button"  class="btn btn-default btn-xs">添加</button>
                        </a>
                    </div>
                </div>
                <div class="ibox-tools" style="margin-top: 0px;float: left;">
                    <form   method="post" role="form" class="form-inline">
                        <input type="hidden" name="" value=""/>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input  id="sell_phone" placeholder="联系电话" name="sell_phone" style="height: 29px;width: 120px;" class="form-control">
                            </div>
                        </div>

                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="卖车地址"  id="sell_address" name="sell_address" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="车辆描述/汽车名称" id="sell_carname" name="sell_carname" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text"  placeholder="车系"  id="sell_cardept" name="sell_cardept" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="沟通状态" id="sell_status" name="sell_status" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>

                        <div class="checkbox m-l m-r-xs" style="margin-left: 0px; margin-top:5px;">
                            <input class="btn btn-white" type="button" onclick="getsell(1,3)" value="查询"></input>
                        </div>
                    </form>
                </div>
                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>联系电话</th>
                            <th>卖车地址</th>
                            <th>车辆描述/汽车名称</th>
                            <th>车系</th>
                            <th>沟通状态</th>
                            <th style="text-align: center;">操作</th>
                        </tr>
                        </thead>
                        <tbody id="selllist">

                        </tbody>

                    </table>
                    <div align="center" id="pageandsize">

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

