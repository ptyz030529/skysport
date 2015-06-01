<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../../base/path.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>查询供应商信息</title>
    <jsp:include page="../../base/common.jsp" flush="true"></jsp:include>
    <jsp:include page="../../base/commonTable.jsp" flush="true"></jsp:include>
    <link rel="stylesheet" href="<%=path%>/resources/css/page-header.css"/>
    <!--<script type="text/javascript" src="/dt-page/extjs.js"></script>-->
</head>
<body>
<div class="page-content">
    <%--<%@ include file="base/ace-setting.jsp"%>--%>
    <div class="page-header">
        <h1>
            系统管理
            <small><i class="icon-double-angle-right"></i> 供应商信息</small>
        </h1>
    </div>
    <!-- PAGE CONTENT BEGINS -->
    <div class="row">
        <div class="col-xs-12">
            <table id="example" class="table table-striped table-bordered table-hover">
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
    </div>
        <%@ include file="edit2.jsp"%>
</div>
<jsp:include page="../../base/footCommon.jsp"></jsp:include>
<!--定义操作列按钮模板-->
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="btn btn-{{this.type}} btn-sm" onclick="{{this.fn}}">{{this.name}}</button>
    {{/each}}
</script>


<script type="text/javascript" >
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
            order: [[ 0, "desc" ]],/*默认第一列倒序*/
            columnDefs: [
                {
                    targets: 6,
                    render: function (data, type, row, meta) {
                        var context =
                        {
                            func: [
                                {"name": "修改", "fn": "info(\'" + data.spId + "\')", "type": "primary"},
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
                "info": "第 _PAGE_ 页 ( 共 _PAGES_ 页 )",
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
                $("#mytool").append('<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" >ADD</button>');
            }

        });

        $("#save").click(save);
    });

</script>

<script type="text/javascript">
    var spId="";
    var info = function(_spId){
        spId = _spId;
        sendRestFulAjax("spinfo/"+_spId,null,'GET','json',doSuccess);
    }

    var doSuccess= function(_data){
        var data = _data;
        console.info(data);
        var myTemplate = Handlebars.compile($("#info-template").html());
        $('#defaultForm').html(myTemplate(data));
    }

    var del = function(spId){
        sendRestFulAjax("del/"+spId,null,'DELETE','json',doSuccess);
    }


</script>
</body>



</html>
