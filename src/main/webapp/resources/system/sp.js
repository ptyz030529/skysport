/**
 * Created by zhangjh on 2015/5/27.
 */
function save(){
    $('#defaultForm').bootstrapValidator('validate');
}

/**
 * 修改数据
 * @param name
 */
function edit(url,data) {

    /* var url="edit";
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
     };*/
    sendAjax(url,data,doSuccess);
}



function doSuccess(data){

    //$("#myModal").modal('hideModal');//移除模态框
    //$("#myModal").modal('removeBackdrop');//移除模态框
    var length = $(".modal-backdrop").length;
    for (var index = 0 ;index<length ;index ++){
        $("#myModal").modal('hide');//移除模态框
    }
    //$(".modal-backdrop").remove();//移除遮罩层
    //$('<div class="modal-backdrop"></div>').appendTo(document.body);
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
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '供应商名称 can only consist of alphabetical, number and underscore'
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
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,
                        message: '邮件地址格式不正确'
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
})
    .on('success.form.bv',function(e){
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

        // Use Ajax to submit form data
        var url = $form.attr('action');
        var data = $form.serialize();
        edit(url,data);
    });