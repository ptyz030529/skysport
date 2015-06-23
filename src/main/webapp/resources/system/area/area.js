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
 * @returns {{name: {validators: {notEmpty: {message: string}}}, customerId: {validators: {notEmpty: {message: string}}}}}
 */
var fieldsDesc = function(){
    var fieldsDesc =
    {
        name: {
            validators: {
                notEmpty: {
                    message: '区域名称为必填项'
                }
            }
        },
        customerId: {
            validators: {
                notEmpty: {
                    message: '客户名称为必填项'
                }
            }
        }
    }
    return fieldsDesc;
}

/**
 * 初始化列表
 * @param _data 表单对象
 */
var initSelect = function(_data){
    var id = null;
    var text = null;
    Object.keys(_data).map(function(key){
        if(key == 'customerId'){
            id = _data[key];
        }
        else if(key == 'customerName'){
            text = _data[key];
        }
    });
    var $element = $('.js-data-example-ajax').select2(); // the select element you are working with
    var option = new Option(text, id, true, true);
    $element.append(option);
    $element.trigger('change');
}

/**
 * 重置下拉框
 */
var resetSelect = function(){
    $('.js-data-example-ajax').select2('val', '');
}






