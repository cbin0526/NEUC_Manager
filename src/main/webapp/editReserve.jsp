<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> 预约表单</title>
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


<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>修改预约信息</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal" action="updateReserve.do" method="post" id="form">
                        <input type="hidden" value="${requestScope.ReserveDto.reserve_id}" name="reserve_id" >
                        <div class="form-group">
                            <label class="col-sm-3 control-label"></label>
                            <div class="col-sm-8" style="color: red;font-size: 15px">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>用户名称：</label>
                            <div class="col-sm-8">
                                <input id="user_name" name="user_name" value="${requestScope.ReserveDto.user_name}" readonly type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>预约电话：</label>
                            <div class="col-sm-8">
                                <input id="reserve_phone" name="reserve_phone" value="${requestScope.ReserveDto.reserve_phone}" placeholder=" 请输入预约电话" type="text" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>预约时间：</label>
                            <div class="col-sm-8">
                                <input  name="reserve_date" id="reserve_date" value="${requestScope.ReserveDto.reserve_date}" placeholder=" 请输入预约时间" type="date" class="form-control">
                                <span class="help-block m-b-none"></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color:red;">*</span>预约状态：</label>
                            <div class="col-sm-8">
                                <select  class="form-control" id="reserv_status" name="reserv_status">
                                    <c:if test="${requestScope.ReserveDto.reserv_status=='已看车'}">
                                        <option value="已看车" selected="selected">已看车</option>
                                        <option value="未看车">未看车</option>
                                    </c:if>
                                    <c:if test="${requestScope.ReserveDto.reserv_status=='未看车'}">
                                        <option value="已看车" >已看车</option>
                                        <option value="未看车"selected="selected">未看车</option>
                                    </c:if>
                                </select>
                                <span class="help-block m-b-none"></span>
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
