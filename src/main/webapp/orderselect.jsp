<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/10/29
  Time: 17:03
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
    <link rel="stylesheet" href="js/jsuggest.css">
    <script src="js/jSuggest.js"></script>
</head>
<%--<script>--%>
<%--$(document).ready(function () {--%>
   <%--$("#car_name").jSuggest({--%>
       <%--minchar:1,--%>
       <%--opactiy:1.0,--%>
       <%--zindex:20000,--%>
       <%--delay:2500,--%>
       <%--url:"getCar.do",--%>
       <%--type:"GET",--%>
       <%--data:"car",--%>
       <%--autoChange:true--%>
   <%--})--%>

<%--})--%>

<%--</script>--%>
<script>
    /**
 * 页面加载后显示
 */
$(document).ready(function () {
    allOrder(1,5);
})
    /**
     * 获取所有订单
     * @param page
     * @param size
     */
    function allOrder(page,size) {
        var order_code=$("#order_code").val();
        var order_datetime=$("#order_datetime").val();
        var car_name = $("#car_name").val();
        var user_name = $("#user_name").val();
        var order_status = $("#order_status").val();
        var order_price = $("#order_price").val();
//发起ajax请求
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "allOrder.do",
            data: {
                  order_code : order_code,
                  order_datetime:order_datetime,
                  car_name :  car_name,
                  user_name: user_name,
                  order_status :order_status,
                  order_price : order_price,
                  page: page,
                  size: size},
            success: function (msg) {
                if (msg.flag == 0) {
                    //表示没有数据
                    $("indexcontent").html(msg.info);
                }else{
                   var content = msg.data.olist;
                   var maxPage = msg.data.maxPage;
                   var page = msg.data.page;
                   var size = msg.data.size;
                   var str = "";
                   for (var i = 0; i < content.length; i++) {
                    // alert(msg);
                      str = str + '<tr class="gradeX">' +
                        '<td>' + content[i].order_code + '</td>' +
                        '<td>' + content[i].order_datetime + '</td>' +
                        '<td>' + content[i].car_name + '</td>' +
                        '<td>' + content[i].user_name + '</td>' +
                        '<td>' + content[i].order_status + '</td>' +
                        '<td>' + content[i].order_price + '</td>' +
                        '<td style="text-align: center;">' +
                        '<a class="btn btn-white btn-bitbucket" title="编辑" href="javascript:editcar(' + content[i].order_id + ')">' +
                        '<i class="fa fa-pencil-square-o" aria-hidden="true"></i>' +
                        '</a>' +
                        '<input type="hidden" value="123"/>' +
                        '<a class="btn btn-white btn-bitbucket delete" title="删除"  href="#">' +
                        '<i class="fa fa-trash-o" aria-hidden="true" ></i>' +
                        '</a>' +
                        '</td>' +
                        '</tr>';
                      }

                   $("#myorder").html(str);

                //上一页/下一页
                var str1 =
                    '<a href="javascript:allOrder(1,5)">首页</a>&nbsp;&nbsp;&nbsp;' +
                    '<a href="javascript:allOrder(' + (msg.data.page - 1) + ',5)">上一页</a>&nbsp;&nbsp;&nbsp;' +
                    // + '<span id="myspan"></span>'+
                    '<a href="javascript:allOrder(' + (msg.data.page + 1) + ',5)">下一页</a>&nbsp;&nbsp;&nbsp;' +
                    '<a href="javascript:allOrder(' + (msg.data.maxPage) + ',5)">尾页</a>';

                $("#myindex").html(str1);
                // //选择页数
                let str3 = "";
                let str4 = "";
                if (page != "&&maxPage!=") {
                    page = parseInt(page);
                    maxPage = parseInt(maxPage);
                    for (var i = 1; i <= maxPage; i++) {
                        if (i == page) {
                            str3 = str3 + "第" + i + "页</a>&nbsp;&nbsp;";
                            str4 = str4
                                + "<option selected='selected' value='" + i + "'>第"
                                + i + "页</option>";
                        } else {
                            str3 = str3 + "<a href='javascript:allCar("
                                + i + ",5)'>第" + i
                                + "页</a>&nbsp;&nbsp;"
                            str4 = str4 + "<option  value='" + i + "'>第"
                                + i + "页</option>";
                        }
                    }
                    $("#myspan").html(str3);
                    $("#myselected").html(str4);
                }
            }

            }
        });
    }
</script>
<script>
    //导出excel文件
    function exportCarExcel(){
        location.href="exportOrderExcel.do";
    }
</script>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>订单列表</h5>

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
                                <input  id="order_code" placeholder="订单编号" name="order_code" style="height: 29px;width: 120px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text"  id="order_datetime" placeholder="订单生成时间" name="order_datetime" style="height: 29px;width: 120px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="交易车辆" id="car_name" name="car_name" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text"  placeholder="下单用户" id="user_name" name="user_name"  style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="订单状态"  id="order_status" name="order_status" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="订单交易金额" id="order_price" name="order_price" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="checkbox m-l m-r-xs" style="margin-left: 0px; margin-top:5px;">
                            <input class="btn btn-white" type="button" onclick="javascript:allOrder(0,5)" value="查询"></input>
                        </div>
                        <div class="checkbox m-l m-r-xs" style="margin-left: 0px; margin-top:5px;">
                            <input class="btn btn-white" type="button" onclick="javascript:exportCarExcel()" value="导出文件"></input>
                        </div>
                    </form>
                </div>
                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>订单生成时间</th>
                            <th>交易车辆</th>
                            <th>下单用户</th>
                            <th>订单状态</th>
                            <th>订单交易金额</th>
                            <th style="text-align: center;">操作</th>
                        </tr>
                        </thead>
                        <tbody id="myorder">

                        </tbody>

                    </table>
                    <div align="center" id="myindex">

                </div>
                    <div align="center">
                    <select id="myselected" onchange="allOrder(this.value,5)"></select>
                </div>
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

<!-- Sweet alert -->
<script src="js/sweetalert.min.js"></script>
<%--<script>--%>
    <%--$(document).ready(function () {--%>
        <%--$(".delete").click(function () {--%>
            <%--var id=$(this).prev().val();--%>
            <%--if(confirm("确定删除吗？删除后将无法恢复！")){--%>
                <%--window.location.href="admin_guanlilyuan_del.action?guanlilyuan.id="+id;--%>
                <%--return true;--%>
            <%--}else{--%>
                <%--return false;--%>
            <%--}--%>
        <%--});--%>

        <%--$('.dataTables-example').dataTable();--%>
        <%--/* Init DataTables */--%>
        <%--var oTable = $('#editable').dataTable();--%>

        <%--/* Apply the jEditable handlers to the table */--%>
        <%--oTable.$('td').editable('../example_ajax.php', {--%>
            <%--"callback": function (sValue, y) {--%>
                <%--var aPos = oTable.fnGetPosition(this);--%>
                <%--oTable.fnUpdate(sValue, aPos[0], aPos[1]);--%>
            <%--},--%>
            <%--"submitdata": function (value, settings) {--%>
                <%--return {--%>
                    <%--"row_id": this.parentNode.getAttribute('id'),--%>
                    <%--"column": oTable.fnGetPosition(this)[2]--%>
                <%--};--%>
            <%--},--%>

            <%--"width": "90%",--%>
            <%--"height": "100%"--%>
        <%--});--%>


    <%--});--%>

    <%--function fnClickAddRow() {--%>
        <%--$('#editable').dataTable().fnAddData([--%>
            <%--"Custom row",--%>
            <%--"New row",--%>
            <%--"New row",--%>
            <%--"New row",--%>
            <%--"New row"]);--%>

    <%--}--%>
<%--</script>--%>
<%--<script src="js/laydate.js"></script>--%>
<%--<script>--%>
    <%--//外部js调用--%>
    <%--laydate({--%>
        <%--elem: '#hello', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'--%>
        <%--event: 'focus', //响应事件。如果没有传入event，则按照默认的click--%>
        <%--format: 'YYYY-MM-DD hh:mm:ss', //日期格式--%>
        <%--istime: true, //是否开启时间选择--%>
        <%--isclear: true, //是否显示清空--%>
        <%--istoday: true, //是否显示今天--%>
        <%--issure: true, //是否显示确认--%>
        <%--festival: true, //是否显示节日--%>
        <%--min: '', //最小日期--%>
        <%--max: '2099-12-31 23:59:59', //最大日期--%>
        <%--start: '',    //开始日期--%>
    <%--});--%>
    <%--//外部js调用--%>
    <%--laydate({--%>
        <%--elem: '#hello2', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'--%>
        <%--event: 'focus', //响应事件。如果没有传入event，则按照默认的click--%>
        <%--format: 'YYYY-MM-DD hh:mm:ss', //日期格式--%>
        <%--istime: true, //是否开启时间选择--%>
        <%--isclear: true, //是否显示清空--%>
        <%--istoday: true, //是否显示今天--%>
        <%--issure: true, //是否显示确认--%>
        <%--festival: true, //是否显示节日--%>
        <%--min: '', //最小日期--%>
        <%--max: '2099-12-31 23:59:59', //最大日期--%>
        <%--start: '',    //开始日期--%>
    <%--});--%>
    <%--//日期范围限制--%>
    <%--var start = {--%>
        <%--elem: '#start',--%>
        <%--format: 'YYYY/MM/DD hh:mm:ss',--%>
        <%--min: laydate.now(), //设定最小日期为当前日期--%>
        <%--max: '2099-06-16 23:59:59', //最大日期--%>
        <%--istime: true,--%>
        <%--istoday: false,--%>
        <%--choose: function (datas) {--%>
            <%--end.min = datas; //开始日选好后，重置结束日的最小日期--%>
            <%--end.start = datas   //将结束日的初始值设定为开始日--%>
        <%--}--%>
    <%--};--%>
    <%--var end = {--%>
        <%--elem: '#end',--%>
        <%--format: 'YYYY/MM/DD hh:mm:ss',--%>
        <%--min: laydate.now(),--%>
        <%--max: '2099-06-16 23:59:59',--%>
        <%--istime: true,--%>
        <%--istoday: false,--%>
        <%--choose: function (datas) {--%>
            <%--start.max = datas; //结束日选好后，重置开始日的最大日期--%>
        <%--}--%>
    <%--};--%>
    <%--laydate(start);--%>
    <%--laydate(end);--%>
<%--</script>--%>
</body>

</html>

