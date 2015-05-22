<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../../base/path.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>查询供应商信息</title>
    <jsp:include page="../../base/common.jsp"></jsp:include>
    <jsp:include page="../../base/commonTable.jsp"></jsp:include>
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
            <form id="defaultForm" method="post" class="form-horizontal" >
            <div class="modal-body">
                <div class="form-group">
                    <label class="col-lg-3 control-label">供应商编号</label>
                    <div class="col-lg-7">
                        <input type="text" class="form-control"  id="spId" name="spId" placeholder="供应商编号"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">供应商名称</label>
                    <div class="col-lg-7">
                    <input type="text" class="form-control"  id="name" name="name"  placeholder="供应商名称">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">供应商类型</label>
                    <div class="col-lg-7">
                    <input type="text" class="form-control" id="type" name="type" placeholder="供应商类型">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">"联系人</label>
                    <div class="col-lg-7">
                    <input type="text" class="form-control"  id="contact" name="contact" placeholder="联系人">
                    </div>
                </div>
                <div class="form-group">

                    <label class="col-lg-3 control-label">联系电话</label>
                    <div class="col-lg-7">
                    <input type="text" class="form-control" id="tel" name="tel" placeholder="联系电话">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">邮件地址</label>
                    <div class="col-lg-7">
                    <input type="text" class="form-control" id="email" name="email" placeholder="邮件地址">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">合作时间</label>
                    <div class="col-lg-7">
                    <input type="text" class="form-control"  id="cooperationTime" name="cooperationTime" placeholder="合作时间"       data-date-format="yyyy/mm/dd">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">地址</label>
                    <div class="col-lg-7">
                    <input type="text" class="form-control"  id="address" name="address" placeholder="地址">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">备注</label>
                    <div class="col-lg-7">
                    <input type="text" class="form-control"  id="remark" name="remark" placeholder="备注"/>
                        </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save" >保存</button>
            </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../../base/footCommon.jsp"></jsp:include>
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
        $('#defaultForm').bootstrapValidator('validate');
    	var _spId=$("spId").val();
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


    $(document).ready(function() {

        $('#defaultForm').bootstrapValidator({
//        live: 'disabled',
                    message: 'This value is not valid',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        spId: {
                            validators: {
                                notEmpty: {
                                    message: '供应商编号 is required and cannot be empty'
                                }
                            }
                        },
                        name: {
                            validators: {
                                notEmpty: {
                                    message: '供应商名称  is required and cannot be empty'
                                }
                            }
                        },
                        type: {
                            validators: {
                                notEmpty: {
                                    message: '供应商类型  is required and cannot be empty'
                                }
                            }
                        },
                        contact: {
                            validators: {
                                notEmpty: {
                                    message: '联系人  is required and cannot be empty'
                                }
                            }
                        },
                        tel: {
                            validators: {
                                notEmpty: {
                                    message: '联系电话  is required and cannot be empty'
                                }
                            }
                        },
                        email: {
                            validators: {
                                notEmpty: {
                                    message: '邮件地址  is required and cannot be empty'
                                }
                            }
                        },
                        cooperationTime: {
                            validators: {
                                notEmpty: {
                                    message: '合作时间  is required and cannot be empty'
                                }
                            }
                        },
                        address: {
                            validators: {
                                notEmpty: {
                                    message: '地址  is required and cannot be empty'
                                }
                            }
                        }

                    }
                }
        );



    });
</script>

</html>
