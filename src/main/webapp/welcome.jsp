<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 基本表单</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <!-- Sweet Alert -->
    <link href="css/sweetalert.css" rel="stylesheet">
    <style type="text/css">
        .note-editable {
            height: 200px;
        }
    </style>
    <script src="js/jquery-1.7.2.min_1.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/echarts.min.js"></script>

</head>

<body class="gray-bg">

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>数据分析</h5>
                </div>
                <div style="width: 1552px;height: 710px;">
                    <div id="car_brand" style="width: 490px;height: 500px;float: left;"></div>
                    <div id="car_order" style="width: 490px;height: 500px;float: left;"></div>
                    <div style="float: left;">
                        <input type="month" onchange="car_ordertime()" id="mouth">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

    $(document).ready(function (){
        let chartDom = document.getElementById('car_brand');
        let myChart = echarts.init(chartDom);
        let xlist = new Array();
        let ylist = new Array();
        $.ajax({
            url:"queryCarBrandAndNum.do",
            dataType:"json",
            success:function (msg){
               let servicedata = [];
                for(let i = 0;i < msg.length; i++){
                    var obj=new Object();
                    obj.name=msg[i].car_brand;
                    obj.value=msg[i].car_brandnum;
                    servicedata[i]=obj;
                }
                var option = {
                    series: [
                        {
                            type: 'pie',
                            data: servicedata
                        }
                    ]
                };
                //5.将配置项设置给echarts实例对象，使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        })
    })

    $(document).ready(function (){
        car_ordertime()
    })
</script>

<script>
    function car_ordertime(){
        let mouth = $("#mouth").val();
        let chartDom = document.getElementById('car_order');
        let myChart = echarts.init(chartDom);
        let xlist = new Array();
        let ylist = new Array();
        $.ajax({
            url:"orderTimeAndBrand.do",
            data:{mouth:mouth},
            dataType:"json",
            success:function (msg){
                for(let i = 0;i < msg.length; i++){
                    xlist[i] = msg[i].car_brand;
                    ylist[i] = msg[i].car_brandnum;
                }
                var option = {
                    title: {
                        text: '每月销量'
                    },
                    //tooltip: {},
                    legend: {
                        data:['数量']
                    },
                    xAxis: {
                        data: xlist,
                    },
                    yAxis: {},
                    series: [{
                        name: '数量',
                        type: 'bar',
                        data: ylist,
                    }]
                };
                //5.将配置项设置给echarts实例对象，使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        })
    }
</script>
</body>

</html>
