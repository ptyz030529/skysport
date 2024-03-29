/**
 * 列表展示内容
 * @returns {*[]}
 */
var columnsName = function(){
    var columnsName  =[
        {"data": "natrualkey"},
        {"data": "name"},
        {"data": "fullName"},
        {"data": "address"},
        {"data": "email"},
        {"data": "tel"},
        {"data": "corTime"},
        {"data": null}
    ];
    return columnsName;
}


/**
 * 新增/修改校验字段描述
 * @returns {{name: {validators: {notEmpty: {message: string}}}, fullName: {validators: {notEmpty: {message: string}}}, email: {validators: {notEmpty: {message: string}}}, corTime: {validators: {notEmpty: {message: string}}}, address: {validators: {notEmpty: {message: string}}}, contact: {validators: {notEmpty: {message: string}}}, tel: {validators: {notEmpty: {message: string}}}}}
 */
var fieldsDesc = function(){
    var fieldsDesc =
    {
        name: {
            validators: {
                notEmpty: {
                    message: '客户名称为必填项'
                }
            }
        },
        fullName: {
            validators: {
                notEmpty: {
                    message: '客户全称为必填项'
                }
            }
        },
        email: {
            validators: {
                notEmpty: {
                    message: '邮箱为必填项'
                }
            }
        },
        corTime: {
            validators: {
                notEmpty: {
                    message: '合作时间为必填项'
                },
                date: {
                    format: 'YYYY-MM-DD',
                    message: '合作时间格式无效'
                }
            }
        },
        address: {
            validators: {
                notEmpty: {
                    message: '地址为必填项'
                }
            }
        }
    ,
        contact: {
            validators: {
                notEmpty: {
                    message: '联系人为必填项'
                }
            }
        },
        tel: {
            validators: {
                notEmpty: {
                    message: '联系电话为必填项'
                }
            }
        }
    }
    return fieldsDesc;
}


