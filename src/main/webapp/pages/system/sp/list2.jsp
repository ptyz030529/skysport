<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../../base/path.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>查询供应商信息</title>
    <link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.css"/>
    <script src="http://cdn.gbtags.com/datatables/1.10.5/js/jquery.js"></script>
    <script src="http://cdn.gbtags.com/datatables/1.10.5/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" language="javascript"    src="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="<%=path%>/resources/js/date/bootstrap-datetimepicker.min.js"></script>
    <script src="<%=path%>/resources/js/handlebars-v3.0.1.js"></script>

    <!--<script type="text/javascript" src="/dt-page/extjs.js"></script>-->
</head>
<body>
<div class="container">
    <table id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>供应商编号</th>
            <th>供应商名称</th>
            <th>供应商类型</th>
            <th>合作时间</th>
            <th>地址</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody></tbody>
        <!-- tbody是必须的 -->
    </table>
</div>
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input type="text" class="form-control" id="name" placeholder="姓名">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="position" placeholder="位置">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="salary" placeholder="薪资">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="start_date" placeholder="时间"
                           data-date-format="yyyy/mm/dd">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="office" placeholder="工作地点">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="extn" placeholder="编号">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" id="initData">添加模拟数据</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
<!--定义操作列按钮模板-->
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="btn btn-{{this.type}} btn-sm" onclick="{{this.fn}}">{{this.name}}</button>
    {{/each}}
</script>

<script>
    var table;
    var editFlag = false;
    $(function () {

        $('#start_date').datetimepicker();

        var tpl = $("#tpl").html();
        //预编译模板
        var template = Handlebars.compile(tpl);

        table = $('#example').DataTable({
            ajax: {
                url: "search"
            },
            serverSide: true,
            columns: [
                {"data": "spId"},
                {"data": "name"},
                {"data": "type"},
                {"data": "cooperationTime"},
                {"data": "address"},
                {"data": "remark"},
                {"data": null}
            ],
            columnDefs: [
                {
                    targets: 6,
                    render: function (data, type, row, meta) {
                        var context =
                        {
                            func: [
                                {"name": "修改", "fn": "edit(\'" + data.spId + "\')", "type": "primary"},
                                {"name": "删除", "fn": "del(\'" + data.spId + "\')", "type": "danger"}
                            ]
                        };
                        var html = template(context);
                        return html;
                    }
                }

            ],
            "language": {
                "lengthMenu": "_MENU_ 条记录每页",
                "zeroRecords": "没有找到记录",
                "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                "infoEmpty": "无记录",
                "infoFiltered": "(从 _MAX_ 条记录过滤)",
                "paginate": {
                    "previous": "上一页",
                    "next": "下一页"
                }
            },
            "dom": "<'row'<'col-xs-2'l><'#mytool.col-xs-4'><'col-xs-6'f>r>" +
                    "t" +
                    "<'row'<'col-xs-6'i><'col-xs-6'p>>",
            initComplete: function () {
                $("#mytool").append('<button id="datainit" type="button" class="btn btn-primary btn-sm">增加基础数据</button>&nbsp');
                $("#mytool").append('<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal">添加</button>');
                $("#datainit").on("click", initData);
            }

        });

        $("#save").click(add);

        $("#initData").click(initSingleData);

    });

    /**
     * 初始化基础数据
     */
    function initData() {
        var flag = confirm("本功能将添加数据到数据库，你确定要添加么？");
        if (flag) {
            $.get("objects.txt", function (data) {
                var jsondata = JSON.parse(data);
                $(jsondata.data).each(function (index, obj) {
                    ajax(obj);
                });
            });
        }
    }

    /**
     * 初始化基础数据
     */
    function initSingleData() {
        $("#name").val("http://dt.thxopen.com");
        $("#position").val("ShiMen");
        $("#salary").val("1");
        $("#start_date").val("2015/04/01");
        $("#office").val("Home");
        $("#extn").val("001");
    }

    /**
     * 清除
     */
    function clear() {
        $("#name").val("").attr("disabled",false);
        $("#position").val("");
        $("#salary").val("");
        $("#start_date").val("");
        $("#office").val("");
        $("#extn").val("");
        editFlag = false;
    }

    /**
     * 添加数据
     **/
    function add() {
        var addJson = {
            "name": $("#name").val(),
            "position": $("#position").val(),
            "salary": $("#salary").val(),
            "start_date": $("#start_date").val(),
            "office": $("#office").val(),
            "extn": $("#extn").val()
        };

        ajax(addJson);
    }

    /**
     *编辑方法
     **/
    function edit(name,position,salary,start_date,office,extn) {
        console.log(name);
        editFlag = true;
        $("#myModalLabel").text("修改");
        $("#name").val(name).attr("disabled",true);
        $("#position").val(position);
        $("#salary").val(salary);
        $("#start_date").val(start_date);
        $("#office").val(office);
        $("#extn").val(extn);
        $("#myModal").modal("show");
    }

    function ajax(obj) {
        var url ="add.jsp" ;
        if(editFlag){
            url = "edit.jsp";
        }
        $.ajax({
            url:url ,
            data: {
                "name": obj.name,
                "position": obj.position,
                "salary": obj.salary,
                "start_date": obj.start_date,
                "office": obj.office,
                "extn": obj.extn
            }, success: function (data) {
                table.ajax.reload();
                $("#myModal").modal("hide");
                $("#myModalLabel").text("新增");
                clear();
                console.log("结果" + data);
            }
        });
    }


    /**
     * 删除数据
     * @param name
     */
    function del(name) {
        $.ajax({
            url: "del.jsp",
            data: {
                "name": name
            }, success: function (data) {
                table.ajax.reload();
                console.log("删除成功" + data);
            }
        });
    }
</script>