
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Leave Application</title>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">
    <style>
        /*表单容器*/
        .ns-container {
            position: absolute;
            width: 500px;
            height: 450px;
            top: 150px;
            left: 50%;
            margin-left: -250px;
            padding: 20px;
            box-sizing: border-box;
            border: 1px solid #cccccc;
        }
    </style>
</head>
<body>
<div class="layui-row">
    <blockquote class="layui-elem-quote">
        <h2>Leave Application</h2>
    </blockquote>
    <table id="grdNoticeList" lay-filter="grdNoticeList"></table>
</div>
<div class="ns-container">
    <h1 style="text-align: center;margin-bottom: 20px">Leave Application Form</h1>
    <form class="layui-form">
        <!--基本信息-->
        <div class="layui-form-item">
            <label class="layui-form-label">Department</label>
            <div class="layui-input-block">
                <div class="layui-col-md12" style="padding-top: 10px;">
                    ${current_department.departmentName}
                </div>

            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">Applicant</label>
            <div class="layui-input-block">
                <div class="layui-col-md12" style="padding-top: 10px;">
                    ${current_employee.name}[${current_employee.title}]
                </div>

            </div>
        </div>
        <!--请假类型下拉框-->
        <div class="layui-form-item">
            <label class="layui-form-label">Leave Type</label>
            <div class="layui-input-block layui-col-space5">
                    <select name="formType" lay-verify="required" lay-filter="cityCode">
                        <option value="0">Sickness</option>
                        <option value="1">Marriage</option>
                        <option value="2">Labor</option>
                        <option value="3">Personal Affairs</option>
                    </select>
            </div>
        </div>
        
        <!--请假时长日期选择框-->
        <div class="layui-form-item">
            <label class="layui-form-label">Leave Time</label>
            <div class="layui-input-block layui-col-space5">
                    <input name="leaveRange" type="text" class="layui-input" id="daterange" placeholder=" - ">
                    <input id="startTime" name="startTime" type="hidden">
                    <input id="endTime" name="endTime" type="hidden">
            </div>
        </div>

        <!--请假事由-->
        <div class="layui-form-item">
            <label class="layui-form-label">Application Reason</label>
            <div class="layui-input-block layui-col-space5">
                    <input name="reason" type="text"  lay-verify="required|mobile" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>

        <!--提交按钮-->
        <div class="layui-form-item " style="text-align: center">
                <button class="layui-btn" type="button" lay-submit lay-filter="sub">Submit</button>
        </div>
    </form>
</div>

<script src="/resources/layui/layui.js"></script>
<script src="/resources/sweetalert2.all.min.js"></script>

<script>

        var layDate = layui.laydate; //Layui日期选择框JS对象
        var layForm = layui.form; //layui表单对象
        var $ = layui.$; //jQuery对象
        //日期时间范围
        layDate.render({
            elem: '#daterange'
            ,type: 'datetime'
            ,range: true
            ,format: 'yyyy year M Month d Day H Hour'
            ,done: function(value, start, end){
                //选择日期后出发的时间,设置startTime与endTime隐藏域
                var startTime = start.year + "-" + start.month + "-" + start.date + "-" + start.hours;
                var endTime = end.year + "-" + end.month + "-" + end.date + "-" + end.hours;
                console.info("请假开始时间",startTime);
                $("#startTime").val(startTime);
                console.info("请假结束时间",endTime);
                $("#endTime").val(endTime);
            }
        });

        //表单提交时间
        layForm.on('submit(sub)', function(data){
            console.info("向服务器提交的表单数据",data.field);
            $.post("/leave/create",data.field,function (json) {
                console.info(json);
                if(json.code == "0"){
                    /*SweetAlert2确定对话框*/
                    swal({
                        type: 'success',
                        html: "<h2>Submitted,please wait for further approval</h2>",
                        confirmButtonText: "Confirm"
                    }).then(function (result) {
                        window.location.href="/forward/notice";
                    });
                }else{
                    swal({
                        type: 'warning',
                        html: "<h2>" + json.message + "</h2>",
                        confirmButtonText: "Confirm"
                    });
                }
            },"json");
            return false;
        });

</script>
</body>
</html>