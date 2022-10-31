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
</head>
<script>


</script>
<script>
    /**
 * 页面加载后显示
 */
$(document).ready(function () {

    allCar(1, 1);
})
    /**
     * 获取所有车辆
     * @param page
     * @param size
     */
    function allCar(page, size) {
        var car_name=document.getElementById("car_name").value;
        var car_brand=document.getElementById("car_brand").value;
        var car_dept=document.getElementById("car_dept").value;
        var car_adress=document.getElementById("car_adress").value;
        var car_regist=document.getElementById("car_regist").value;
        var car_endurance=document.getElementById("car_endurance").value;
        var car_color=document.getElementById("car_color").value;
        var car_producetime=document.getElementById("car_producetime").value;
        var car_power=document.getElementById("car_power").value;
        var car_status=document.getElementById("car_status").value;
//发起ajax请求
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "getCar.do",
            data: {car_name: car_name,car_brand:car_brand,car_dept:car_dept,car_adress:car_adress,
                car_endurance:car_endurance,car_regist:car_regist,car_color:car_color,car_producetime:car_producetime,
                car_power:car_power,car_status:car_status,
                page: page, size: size},
            success: function (msg) {
                  // alert(msg);
                    var content=msg.olist;
                    var maxPage=msg.maxPage;
                    var str="";
                    for (var i=0;i<content.length;i++){


                    // alert(msg);
                    str=str+'<tr class="gradeX">' +
                        ' <td>'+content[i].car_name+'</td>' +
                        '<td>'+content[i].car_brand+'</td>' +
                        '<td>'+content[i].car_dept+'</td>' +
                        '<td>'+content[i].car_color+'</td>' +
                        '<td>'+content[i].car_status+'</td>' +
                        '<td>'+content[i].car_producetime+'</td>' +
                        '<td>'+content[i].car_regist+'</td>' +
                        '<td>'+content[i].car_adress+'</td>' +
                        '<td>'+content[i].car_power+'</td>' +
                        '<td style="text-align: center;">' +
                        '<a class="btn btn-white btn-bitbucket" title="编辑" href="javascript:editcar(\''+content[i].car_id+'\')">' +
                        '<i class="fa fa-pencil-square-o" aria-hidden="true"></i>' +
                        '</a>' +
                        '<input type="hidden" value="123"/>' +
                        '<a class="btn btn-white btn-bitbucket delete" title="删除"  href="#">' +
                        '<i class="fa fa-trash-o" aria-hidden="true" ></i>' +
                        '</a>' +
                        '</td>' +
                        '</tr>' ;
                }

                    $("#mycar").html(str);

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
                // //选择页数
                // let str3 = "";
                // let str4 = "";
                // if (page != "&&maxPage!=") {
                //     page = parseInt(page);
                //     maxPage = parseInt(maxPage);
                //     for (var i = 1; i <= maxPage; i++) {
                //         if (i == page) {
                //             str3 = str3 + "第" + i + "页</a>&nbsp;&nbsp;";
                //             str4 = str4
                //                 + "<option selected='selected' value='"+i+"'>第"
                //                 + i + "页</option>";
                //         } else {
                //             str3 = str3 + "<a href='javascript:allSession("
                //                 + i + ",4)'>第" + i
                //                 + "页</a>&nbsp;&nbsp;"
                //             str4 = str4 + "<option  value='"+i+"'>第"
                //                 + i + "页</option>";
                //         }
                //     }
                //     $("#myspan").html(str3);
                //     $("#myselected").html(str4);
                // }
                //

            }
        });
    }
</script>
<script>
    function editcar(id) {
        location.href="getCarById.do?cid="+id;
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
                                <input  id="car_name" placeholder="车辆名称" name="car_name" style="height: 29px;width: 120px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text"  id="car_brand" placeholder="车辆品牌" name="car_brand" style="height: 29px;width: 120px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="车辆系别" id="car_dept" name="car_dept" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text"  placeholder="车辆地址" id="car_adress" name="car_adress"  style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="车辆颜色"  id="car_color" name="car_color" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="车辆生产日期" id="car_producetime" name="car_producetime" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text"  placeholder="车辆总功率"  id="car_power" name="car_power" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="车辆续航里程" id="car_endurance" name="car_endurance" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="车辆上牌时间" id="car_regist" name="car_regist" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="form-group" style="padding-right: 5px;padding-left: 5px;">
                            <div class="col-sm-10" style="margin-bottom: 5px; margin-top:5px;padding-right: 0px;padding-left: 0px;">
                                <input type="text" placeholder="车辆状态" id="car_status" name="car_status" style="height: 29px;width: 150px;padding: 6px 5px;" class="form-control">
                            </div>
                        </div>
                        <div class="checkbox m-l m-r-xs" style="margin-left: 0px; margin-top:5px;">
                            <input class="btn btn-white" type="button" onclick="javascript:allCar(0,1)" value="查询"></input>
                        </div>
                    </form>
                </div>
                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>车辆名称</th>
                            <th>车辆品牌</th>
                            <th>车辆系别</th>
                            <th>车辆颜色</th>
                            <th>车辆状态</th>
                            <th>车辆上牌时间</th>
                            <th>车辆生产日期</th>
                            <th>车辆地址</th>
                            <th>车辆续航里程</th>
                            <th style="text-align: center;">操作</th>
                        </tr>
                        </thead>
                        <tbody id="mycar">

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

