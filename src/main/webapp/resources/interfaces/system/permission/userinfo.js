/**
 * Created by zhangjh on 2015/8/18.
 */
/**
 * 列表展示内容
 * @returns {*[]}
 */
var columnsName = function () {
    var columnsName = [
        {"data": "name"},
        {"data": "userType"},
        {"data": "isOnline"},
        {"data": "lockFlag"},
        {"data": "isLimit"},
        {"data": "lastLoginTime"},
        {"data": "remark"},
        {"data": null}
    ];
    return columnsName;
}


/**
 * 新增/修改校验字段描述
 * @returns {{name: {validators: {notEmpty: {message: string}}}, materialTypeId: {validators: {notEmpty: {message: string}}}}}
 */
var fieldsDesc = function () {
    var fieldsDesc =
    {
        name: {
            validators: {
                notEmpty: {
                    message: '名称为必填项'
                }
            }
        },
        aliases: {
            validators: {
                notEmpty: {
                    message: '用户别名为必填项'
                }
            }
        },
        userPwd: {
            validators: {
                notEmpty: {
                    message: '密码为必填项'
                }
            }
        },
        rptUserPwd: {
            validators: {
                notEmpty: {
                    message: '密码确认为必填项'
                }
            }
        },
        userType: {
            validators: {
                notEmpty: {
                    message: '用户类型为必填项'
                }
            }
        },
        userEmail: {
            validators: {
                notEmpty: {
                    message: '用户邮箱为必填项'
                }
            }
        },
        userMobile: {
            validators: {
                notEmpty: {
                    message: '用户手机为必填项'
                }
            }
        },
        cooperationTime: {
            validators: {
                notEmpty: {
                    message: '合作时间为必填项'
                }
            }
        }

    }
    return fieldsDesc;
}


var clientSearchUrl = "/system/userinfo/search";
$(function () {


    //$("#fileLocation").fileinput({
    //    uploadUrl: path + "/system/userinfo/add/upload", // server upload action
    //    uploadAsync: true,
    //    maxFileCount: 5
    //});


    var edit = function (userId) {
        window.location.href = "/system/userinfo/add/" + userId;
    }

    //事件传递
    $("#userinfo").on("click", "#addBtnAddListPage", function () {
        var userId = "null";
        edit(userId);
    })

})

var doSaveAction = function () {
    var formDataStr = $("#defaultForm").serialize();
    var natrualkey = $("#natrualkey").val();
    var url;
    if (natrualkey == '' || natrualkey == 'null') {
        url = path + "/system/userinfo/new";
    } else {
        url = path + "/system/userinfo/edit";
    }
    $.sendRestFulAjax(url, formDataStr, 'POST', 'json', function () {
        window.location.href = path + "/system/permission/user-tab/1";
    });

}

var saveuserinfo = function () {
    //执行表单监听
    $('#defaultForm').bootstrapValidator('validate');
}

//启动表单校验监听
$('#defaultForm').bootstrapValidator({
    //live: 'disabled',
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: fieldsDesc()
}).on('success.form.bv', function (e) { //表单校验成功，ajax提交数据
    doSaveAction();
});


$(document).on('ready', function () {
    //用户类型
    $.sendRestFulAjax(path + "/system/userinfo/usertype", null, 'GET', 'json', initSelect);

    //上传文件控制
    $("#fileLocation").fileinput({
        showCaption: false,
        uploadUrl: path + "/system/userinfo/add/fileUpload", // server upload action
        initialPreview: [
            "<img src='http://himg.bdimg.com/sys/portrait/item/ee0d6f696463674e08' class='file-preview-image' alt='Desert' title='Desert'>"
        ]
    });

});

var initSelect = function (data) {
    $("#userType").empty();
    $("<option></option>").val('').text("请选择...").appendTo($("#userType"));
    $.each(data, function (key, value) {
        $("<option></option>")
            .val(key)
            .text(value)
            .appendTo($("#userType"));
    });

}