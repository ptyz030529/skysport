/**
 * Created by zhangjh on 2015/6/29.
 */
/**
 * 列表展示内容
 * @returns {*[]}
 */
var columnsName = function () {
    var columnsName = [
        {"data": "natrualkey"},
        {"data": "projectId"},
        {"data": "bomId"},
        {"data": "name"},
        {"data": "remark"},
        {"data": null}
    ];
    return columnsName;
}


/**
 * 新增/修改校验字段描述
 * @returns {{name: {validators: {notEmpty: {message: string}}}, projectId: {validators: {notEmpty: {message: string}}}}}
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
        projectId: {
            validators: {
                notEmpty: {
                    message: '项目编号为必填项'
                }
            }
        }
    }
    return fieldsDesc;
}
