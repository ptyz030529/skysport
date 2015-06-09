/**
 * Created by zhangjh on 2015/6/9.
 */
/**
 * 列表展示内容
 * @returns {*[]}
 */
var columnsName = function(){
    var columnsName  =[
        {"data": "natrualkey"},
        {"data": "name"},
        {"data": "customerName"},
        {"data": "remark"},
        {"data": null}
    ];
    return columnsName;
}


/**
 * 新增/修改校验字段描述
 * @returns {{name: {validators: {notEmpty: {message: string}}}, customerName: {validators: {notEmpty: {message: string}}}}}
 */
var fieldsDesc = function(){
    var fieldsDesc =
    {
        name: {
            validators: {
                notEmpty: {
                    message: '区域名称  is required and cannot be empty'
                }
            }
        },
        customerName: {
            validators: {
                notEmpty: {
                    message: '客户名称  is required and cannot be empty'
                }
            }
        }
    }
    return fieldsDesc;
}


