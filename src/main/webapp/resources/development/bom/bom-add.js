/*!
 * bominfo
 * Copyright 2011-2015 zhangjh.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */
(function ($) {
    "use strict";
    var saveUrl = path + "/development/bom/edit";
    var infoUrl = path + "/development/bom/info"

    $.bominfo = {};

    //扩展BOM静态方法
    $.extend({
        bomSave: bomSave,
        bomSubmit: bomSubmit
    });

    function initBom() {

    }

    $(function () {
        initBom();
    });

    /**
     * 组建面料信息
     * @returns {Array}
     */
    function buildFabricItems() {
        var size = $("div[id^=fabricAllInfoId]").length;
        var fabricItems = [];
        for (var index = 0; index < size; index++) {
            var formDataStr = $("#fabricFormId" + (index + 1)).serialize();
            fabricItems.push(formDataStr);
        }
        return fabricItems;
    }

    /**
     * 组件描述信息
     */
    function buildBomDesc() {
        $.bominfo.offerAmount = $("#offerAmount").val();
        $.bominfo.fabricsEndDate = $("#fabricsEndDate").val();
        $.bominfo.accessoriesEndDate = $("#accessoriesEndDate").val();
        $.bominfo.preOfferDate = $("#preOfferDate").val();
        $.bominfo.clothReceivedDate = $("#clothReceivedDate").val();
    }

    //保存成功，跳转到列表页面
    function bomSaveFun() {
        sendRestFulAjax(saveUrl, $.bominfo, 'POST', 'json', function () {
            window.location.href = path + "/development/bom/list";
        });
    }

    var bomSave = function () {
        //描述信息
        buildBomDesc();


        //面料信息
        var fabricItems = buildFabricItems();

        //辅料信息


        //包材


        //成衣厂
        $.bominfo.fabricItems = fabricItems;


        bomSaveFun();

    }


    var bomSubmit = function () {

    }

}(jQuery));