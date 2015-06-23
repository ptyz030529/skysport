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
        {"data": "factoryContact"},
        {"data": "factoryTel1"},
        {"data": "remark"},
        {"data": null}
    ];
    return columnsName;
}

/**
 * 新增/修改校验字段描述
 * @returns {{name: {validators: {notEmpty: {message: string}}}, email: {validators: {notEmpty: {message: string}}}}}
 */
var fieldsDesc = function(){
    var fieldsDesc =
    {
        name: {
            validators: {
                notEmpty: {
                    message: '名称为必填项'
                }
            }
        },
        email: {
            validators: {
                notEmpty: {
                    message: '邮箱为必填项'
                }
            }
        }
    }
    return fieldsDesc;
}






