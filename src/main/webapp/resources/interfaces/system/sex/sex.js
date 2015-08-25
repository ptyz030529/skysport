/**
 * Created by zhangjh on 2015/6/18.
 */
/**
 * 列表展示内容
 * @returns {*[]}
 */
var columnsName = function(){
    var columnsName  =[
        {"data": "natrualkey"},
        {"data": "name"},
        {"data": "enSexName"},
        {"data": "remark"},
        {"data": null}
    ];
    return columnsName;
}


/**
 * 新增/修改校验字段描述
 * @returns {{name: {validators: {notEmpty: {message: string}}}, customerId: {validators: {notEmpty: {message: string}}}}}
 */
var fieldsDesc = function(){
    var fieldsDesc =
    {
        name: {
            validators: {
                notEmpty: {
                    message: '中文名称为必填项'
                }
            }
        },
        enSexName: {
            validators: {
                notEmpty: {
                    message: '英文名称为必填项'
                }
            }
        },
        sexFullname: {
            validators: {
                notEmpty: {
                    message: '中文名称全称为必填项'
                }
            }
        }
    }
    return fieldsDesc;
}

