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
	<script src="<%=path%>/resources/js/angular/angular-1.3.9.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/util.js"></script>
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input type="text" class="form-control"  id="spId" placeholder="供应商编号">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"  id="name" placeholder="供应商名称">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="type" placeholder="供应商类型">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"  id="contact" placeholder="联系人">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="tel" placeholder="联系电话">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="email" placeholder="邮件地址">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"  id="cooperationTime" placeholder="合作时间"       data-date-format="yyyy/mm/dd">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"  id="address" placeholder="地址">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"  id="remark" placeholder="备注">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save" >保存</button>
            </div>
        </div>
    </div>
</div>

</body>
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
                $("#mytool").append('<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" >添加</button>');
            }

        });

        $("#save").click(save);
    });
    
    function save(){
    	var _spId='sp001';
    	edit(_spId);
    }
    
    /**
     * 修改数据
     * @param name
     */
    function edit(_spId) {
    	
    	var url="<%=path%>/system/sp/edit";
    	var data={
                spId: _spId,
                name:$("#name").val(),
                type:$("#type").val(),
                contact:$("#contact").val(),
                tel:$("#tel").val(),
                email:$("#email").val(),
                cooperationTime:$("#cooperationTime").val(),
                address:$("#address").val(),
                remark:$("#remark").val()
            };
		
    	sendAjax(url,data,doSuccess);
    }
     
    
    
    function doSuccess(data){
    	 $("#myModal").modal('hide');
    	 table.ajax.reload();
         console.log( data.code);
	}
       
    
    
    /**
     * 删除数据
     * @param name
     */
    function del(spId) {
        $.ajax({
            url: "<%=path%>/system/sp/del",
            data: {
                "spId": spId
            }, success: function (data) {
                table.ajax.reload();
                console.log("删除成功" + data);
            }
        });
    }
</script>

</html>
