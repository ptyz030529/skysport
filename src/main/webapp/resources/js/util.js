/*!
 * 前端js公用方法插件
 * Copyright 2011-2015 zhangjh.
 * Licensed under MIT (https://github.com/firebata/skysport/blob/master/LICENSE)
 */
(function ($) {
    "use strict";
    //扩展常用方法
    $.extend({
        sendRestFulAjax: sendRestFulAjax,//ajax
        sendJsonAjax:sendJsonAjax,
        downloadAjax:downloadAjax,
        strToJson: strToJson,//&连接字符串转json对象
        strIsEmpty: strIsEmpty,//判断字符串为空
        strIsNotEmpty: strIsNotEmpty//判断字符串不为空

    });
    /**
     *
     * @param _url 路径
     * @param _data 数据
     * @param _type HTTP方法
     * @param _dataType 数据类型
     * @param _doSuccess 成功回调函数
     */
    function sendRestFulAjax(_url, _data, _type, _dataType, _doSuccess) {
        var type = strIsEmpty(_type) ? 'POST' : _type;
        //var dataType = _type == "undefined" || $.trim(_dataType) == '' ? 'json' : _dataType;
        var sf = strIsEmpty(_doSuccess) ? doSucess : _doSuccess;
        $.ajax({
            url: _url,
            data: _data,
            type: type,
            //dataType: dataType,
            success: sf,
            error: doNotSucess
        });
    }

    /**
     *
     * @param _url 路径
     * @param _data 数据
     * @param _type HTTP方法
     * @param _dataType 数据类型
     * @param _doSuccess 成功回调函数
     */
    function sendJsonAjax(_url, _data,  _doSuccess) {
        var sf = strIsEmpty(_doSuccess) ? doSucess : _doSuccess;
        $.ajax({
            url: _url,
            data: JSON.stringify(_data),
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            success: sf,
            error: doNotSucess
        });
    }

    /**
     *
     * @param _url 路径
     * @param _data 数据
     * @param _type HTTP方法
     * @param _dataType 数据类型
     * @param _doSuccess 成功回调函数
     */
    function downloadAjax(_url, _data,_contentType, _doSuccess) {
        var sf = strIsEmpty(_doSuccess) ? doSucess : _doSuccess;
        $.ajax({
            url: _url,
            data: JSON.stringify(_data),
            type: "POST",
            dataType: "json",
            contentType: _contentType,
            success: sf,
            error: doNotSucess
        });
    }

    /*bootbox.setLocale("zh_CN");*/
    var doNotSucess = function (XMLHttpRequest, textStatus, errorThrown) {
        //console.error(XMLHttpRequest);
        bootbox.alert("本次操作失败.");
    }
    var doSucess = function (XMLHttpRequest, textStatus, errorThrown) {
        //bootbox.alert(XMLHttpRequest);
    }
    /**
     * 将“&”连接的字符串转换成Json
     * @param str “&”连接的字符串
     * @returns {Object}  Json
     */
    function strToJson(str) {
        str = str.replace(/&/g, "','");
        str = str.replace(/=/g, "':'");
        str = "({'" + str + "'})";
        var obj = eval(str);
        return obj;
    }

    /**
     * 校验字符串为空
     * @param input 字符串
     * @returns {boolean}
     */
    function strIsEmpty(input) {
        return input == undefined || $.trim(input) == ''
    }

    /**
     * 校验字符串不为空
     * @param input 字符串
     * @returns {boolean}
     */
    function strIsNotEmpty(input) {
        return !strIsEmpty(input);
    }
}(jQuery));