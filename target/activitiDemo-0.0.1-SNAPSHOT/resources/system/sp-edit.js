/**
 * Created by zhangjh on 2015/5/27.
 */
function save(){
    //执行表单监听
    $('#defaultForm').bootstrapValidator('validate');
}

/**
 * 修改数据
 * @param name
 */
function edit(url,data) {
    sendAjax(url,data,doSuccess);
}

function doSuccess(data){
    //遮罩层的数量
    var length = $(".modal-backdrop").length;
    for (var index = 0 ;index<length ;index ++){
        $("#myModal").modal('hide');//移除模态框遮罩层
    }
    //$(".modal-backdrop").remove();//移除遮罩层
    //$('<div class="modal-backdrop"></div>').appendTo(document.body);
    table.ajax.reload();
    console.log( data.code);

}


$('#resetBtn').click(function() {
    $('#defaultForm').data('bootstrapValidator').resetForm(true);
});


$(document).ready(function() {
    //modal显示式，重置Form
    $('#myModal').on('shown.bs.modal', function (e) {
        $('#defaultForm').data('bootstrapValidator').resetForm(true);
    });


    //启动表单校验监听
    $('#defaultForm').bootstrapValidator({
            //live: 'disabled',
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
.on('success.form.bv',function(e){ //表单校验成功，ajax提交数据
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

