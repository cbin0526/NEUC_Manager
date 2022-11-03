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

    allCar(1, 3);
})
    /**
     * 获取所有车辆
     * @param page
     * @param size
     */
    function allCar(page, size) {

//发起ajax请求
        $.ajax({
            type: "GET",
            data:{page:page,size:size},
            dataType: "json",
            url: "selectAllPush.do",
            success: function (msg) {
                    //alert(msg);
                    var content=msg.olist;
                    var maxPage=msg.maxPage;
                    var str="";
                    for (var i=0;i<content.length;i++){
                    // alert(msg);
                    str=str+'<tr class="gradeX">' +
                        ' <td>'+content[i].push_carname+'</td>' +
                        '<td>'+content[i].push_brand+'</td>' +
                        '<td>'+content[i].push_dept+'</td>' +
                        '<td>'+content[i].push_price+'万</td>' +
                        //'<td>'+content[i].car_status+'</td>' +
                        '<td>'+content[i].push_status+'</td>' +
                        '<td style="text-align: center;">' +
                        '</a>' +
                        '<input type="hidden" value="'+content[i].push_id+'"/>' +
                        '<a title="推送"  href="pushcar.do?push_id='+content[i].push_id+'">推送' +
                        '</a>' +
                        '</td>' +
                        '</tr>' ;
                }

                    $("#mycar").html(str);

                //上一页/下一页
                var str1=
                    '<a href="javascript:allCar(1,' +size
                    + ')">首页</a>&nbsp;&nbsp;&nbsp;'+
                    '<a href="javascript:allCar('+(page-1)+',' + size
                    + ')">上一页</a>&nbsp;&nbsp;&nbsp;'+
                    // + '<span id="myspan"></span>'+
                    '<a href="javascript:allCar('+(page+1)+',' + size
                    + ')">下一页</a>&nbsp;&nbsp;&nbsp;'+
                    '<a href="javascript:allCar('+maxPage+',' + size
                    + ')">尾页</a>';

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
                                + "<option selected='selected' value='"+i+"'>第"
                                + i + "页</option>";
                        } else {
                            str3 = str3 + "<a href='javascript:allCar("
                                + i + ",4)'>第" + i
                                + "页</a>&nbsp;&nbsp;"
                            str4 = str4 + "<option  value='"+i+"'>第"
                                + i + "页</option>";
                        }
                    }
                    $("#myspan").html(str3);
                    $("#myselected").html(str4);
                }


            }
        });
    }
</script>
<script>
    //修改车辆信息
    function editcar(id) {
        location.href="getCarById.do?cid="+id;
    }
</script>
<script>
    //导出excel文件
    function exportCarExcel(){
        location.href="exportExcel.do";
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

                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>车辆名称</th>
                            <th>车辆品牌</th>
                            <th>车辆系别</th>
                            <th>预计价格</th>
                            <th>推送状态</th>
                            <th style="text-align: center;">操作</th>
                        </tr>
                        </thead>
                        <tbody id="mycar">

                        </tbody>

                    </table>
                    <div align="center" id="myindex">

                </div>
                    <div align="center">
                    <select id="myselected" onchange="allCar(this.value,3)"></select>
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
</body>

</html>

