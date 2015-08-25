/**
 * Created by zhangjh on 2015/7/3.
 */
/**
 * 列表展示内容
 * @returns {*[]}
 */
var columnsName = function () {
    var columnsName = [
        {"data": "natrualkey"},
        {"data": "name"},
        {"data": "levelId"},
        {"data": "remark"},
        {"data": null}
    ];
    return columnsName;
}


/**
 * 新增/修改校验字段描述
 * @returns {{name: {validators: {notEmpty: {message: string}}}, customerId: {validators: {notEmpty: {message: string}}}}}
 */
var fieldsDesc = function () {
    var fieldsDesc =
    {
        name: {
            validators: {
                notEmpty: {
                    message: '区域名称为必填项'
                }
            }
        },
        remark: {
            validators: {
                notEmpty: {
                    message: '客户名称为必填项'
                }
            }
        }
    }
    return fieldsDesc;
}

var initSelect = function (_data) {
    var id = null;

    Object.keys(_data).map(function (key) {
        if (key == 'levelId') {
            id = _data[key];
        }
    });
    $('.selectpicker').selectpicker('val', id);
}






