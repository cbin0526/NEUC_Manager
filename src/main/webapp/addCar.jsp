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


</head>

<body class="gray-bg">
<%--<script>--%>//单张图片
    <%--function previewFile() {--%>
        <%--var preview =document.querySelector('img[id=carmain]');--%>
        <%--// var preview2 = document.getElementById("appeal1");--%>
        <%--// var preview3 = document.getElementById("appeal2");--%>
        <%--// var preview4 = document.getElementById("interior2");--%>
        <%--// var preview5 = document.getElementById("interior1");--%>
        <%--var file  = document.querySelector('input[type=file]').files[0];--%>
        <%--var reader = new FileReader();--%>
        <%--reader.onloadend = function () {--%>
            <%--preview.src = reader.result;--%>
            <%--// preview2.src = reader.result;--%>
            <%--// preview3.src = reader.result;--%>
            <%--// preview4.src = reader.result;--%>
            <%--// preview5.src = reader.result;--%>

        <%--}--%>
        <%--if (file) {--%>
            <%--reader.readAsDataURL(file);--%>
        <%--} else {--%>
            <%--preview.src = "";--%>
            <%--// preview2.src = "";--%>
            <%--// preview3.src = "";--%>
            <%--// preview4.src = "";--%>
            <%--// preview5.src = "";--%>

        <%--}--%>
    <%--}--%>

<%--</script>--%>
<script>//多张图片
    function showImg(fileid,target){//给2个参数，其他位置的参数名一致，值就进去了
        var preview = document.querySelector('#'+target);//获取img元素,显示图片位置，根据el表达式('#'+target)
        var file = document.querySelector('#'+fileid).files[0];//根据id拿到文件选择框里面的文件，
        var reader = new FileReader();//创建FileReader接口（把文件放到图片预览框里面）
        reader.onloadend = function () {
            preview.src = reader.result;
        }
        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.src = "";
        }
    }
</script>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>添加车辆</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal" action="addCar.do" method="post" id="form" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="hidden" name="admin.id" id="guanliyuanid" value="">
                            <label class="col-sm-3 control-label"></label>
                            <div class="col-sm-8" style="color: red;font-size: 15px">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆名称：</label>
                            <div class="col-sm-8">
                                <input id="car_name" name="car_name" value="" placeholder=" 请输入车辆名称" type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆品牌：</label>
                            <div class="col-sm-8">
                                <input id="car_brand" name="car_brand" value="" placeholder=" 请输入车辆品牌" type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                        <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆系别：</label>
                        <div class="col-sm-8">
                            <input id="car_dept" name="car_dept" value="" placeholder=" 请输入车辆品牌" type="text" class="form-control">
                            <span class="help-block m-b-none"></span>
                        </div>
                </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆价格：</label>
                            <div class="col-sm-8">
                                <input id="car_price" name="car_price" value="" placeholder=" 请输入车辆价格" type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>上牌时间：</label>
                            <div class="col-sm-8">
                                <input  name="car_regist" id="car_regist" placeholder=" 请输入上牌时间" type="date" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆表总里程：</label>
                            <div class="col-sm-8">
                                <input id="car_mile" name="car_mile" value="" placeholder=" 请输入车辆表总里程" type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆变速箱：</label>
                            <div class="col-sm-8">
                                <input id="car_at" name="car_at" value="" placeholder=" 请输入车辆变速箱" type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆排量：</label>
                            <div class="col-sm-8">
                                <input id="car_dc" name="car_dc" value="" placeholder=" 请输入车辆排量" type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆新车价格：</label>
                            <div class="col-sm-8">
                                <input id="car_newprice" name="car_newprice" value="" placeholder=" 车辆新车价格" type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆过户次数：</label>
                            <div class="col-sm-8">
                                <input id="car_transfer" name="car_transfer" value="" placeholder=" 请输入车辆过户次数" type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆总功率：</label>
                            <div class="col-sm-8">
                                <input id="car_power" name="car_power" value="" placeholder=" 请输入车辆总功率" type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                        <label class="col-sm-3 control-label"><span style="color:red;">*</span>联系电话：</label>
                        <div class="col-sm-8">
                            <input id="phone" name="phone" value="" placeholder=" 请输入联系电话" type="text" class="form-control">
                            <span class="help-block m-b-none"></span>
                        </div>
                </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车牌地址：</label>
                            <div class="col-sm-8">
                                <style type="text/css">
                                    body {
                                        background: #EEEEEE;
                                        margin: 0;
                                        padding: 0;
                                        font-family: "微软雅黑", Arial, Helvetica, sans-serif;
                                    }

                                    a {
                                        color: #006600;
                                        text-decoration: none;
                                    }

                                    a:hover {
                                        color: #990000;
                                    }

                                    .top {
                                        margin: 5px auto;
                                        color: #990000;
                                        text-align: center;
                                    }

                                    .info select {
                                        border: 1px #993300 solid;
                                        background: #FFFFFF;
                                    }

                                    .info {
                                        margin: 5px;

                                    }

                                    .info #show {
                                        color: #3399FF;
                                    }

                                    .bottom {
                                        text-align: right;
                                        font-size: 12px;
                                        color: #CCCCCC;
                                        width: 1000px;
                                    }
                                </style>
                                <div class="info">
                                    <div>
                                        <select id="s_province" name="s_province"></select>&nbsp;&nbsp;
                                        <select id="s_city" name="s_city"></select>
                                        <script class="resources library" src="js/area.js" type="text/javascript"></script>

                                        <script type="text/javascript">
                                            _init_area();
                                        </script>
                                    </div>
                                    <div id="show"></div>
                                </div>
                                <script type="text/javascript">
                                    var Gid = document.getElementById;
                                    var showArea = function() {
                                        Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" +
                                            "</h3>"
                                    }
                                    // Gid('s_county').setAttribute('onchange', 'showArea()');
                                </script>
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆续航里程：</label>
                            <div class="col-sm-8">
                                <input id="car_endurances" name="car_endurance" placeholder=" 请输入车辆续航里程" class="form-control" type="text">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆电池容量：</label>
                            <div class="col-sm-8">
                                <input id="car_capacity" name="car_capacity" placeholder=" 请输入车辆电池容量" class="form-control" type="text">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆颜色：</label>
                            <div class="col-sm-8">
                                <input id="car_color" name="car_color" placeholder=" 请输入车辆颜色" class="form-control" type="text">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆生产时间：</label>
                            <div class="col-sm-8">
                                <input  name="car_producetime" id="car_producetime" placeholder=" 请输入车辆生产时间" type="date" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆钥匙数：</label>
                            <div class="col-sm-8">
                                <input id="car_keynum" name="car_keynum" placeholder=" 请输入车辆钥匙数" class="form-control" type="text">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆上架时间：</label>
                            <div class="col-sm-8">
                                <input  name="car_time" id="car_time" placeholder=" 请输入车辆上架时间" type="date" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆状态：</label>
                            <div class="col-sm-8">
                                <select  class="form-control" id="car_status" name="car_status">
                                    <option value="上架">上架</option>
                                    <option value="下架">下架</option>
                                </select>
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆主图：</label>
                            <div class="col-sm-8">
                                <input id="pic_main" name="pic_main" class="" type="file" onchange="showImg('pic_main','carmain')">
                                <span class="help-block m-b-none">
                                    <img src="images/login-background.jpg" width="200"  height="200" id="carmain">
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆外观1：</label>
                            <div class="col-sm-8">
                                <input id="pic_appea1" name="pic_appea1" class="" type="file" onchange="showImg('pic_appea1','appeal1')">
                                <span class="help-block m-b-none">
                                    <img src="images/login-background.jpg" width="200" height="200" id="appeal1">
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆外观2：</label>
                            <div class="col-sm-8">
                                <input id="pic_appea2" name="pic_appea2" class="" type="file" onchange="showImg('pic_appea2','appeal2')">
                                <span class="help-block m-b-none">
                                    <img src="images/login-background.jpg" width="200" height="200"id="appeal2">
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆内饰1：</label>
                            <div class="col-sm-8">
                                <input id="pic_interior1" name="pic_interior1" class="" type="file" onchange="showImg('pic_interior1','interior1')">
                                <span class="help-block m-b-none">
                                    <img src="images/login-background.jpg" width="200" height="200" id="interior1">
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>车辆内饰2：</label>
                            <div class="col-sm-8">
                                <input id="pic_interior2" name="pic_interior2" class="" type="file" onchange="showImg('pic_interior2','interior2')">
                                <span class="help-block m-b-none">
                                    <img src="images/login-background.jpg" width="200" height="200 " id="interior2">
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-8">
                                <button id="submit" class="btn btn-sm btn-info" type="submit">确认保存</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
