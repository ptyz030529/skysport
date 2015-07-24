/*!
 * bominfo
 * Copyright 2011-2015 zhangjh.
 * Licensed under cnfswy (https://github.com/firebata/skysport/blob/master/LICENSE)
 */
(function ($) {
    $.bominfo = {};
    var saveUrl = path + "/development/bom/edit";
    var infoUrl = path + "/development/bom/info/";
    $.extend({bomSave: bomSave, bomSubmit: bomSubmit});
    $(function () {
        initBom()
    });
    function initBom() {
        var natrualkey = $("#natrualkey").val();
        if ($.strIsNotEmpty(natrualkey)) {
            $.sendRestFulAjax(infoUrl + natrualkey, null, "GET", "json", initFormFields)
        }
    }

    function initFormFields(_data) {
        $.bominfo = _data;
        console.info($.bominfo)
    }

    function buildFabricItems() {
        var size = $("div[id^=fabricAllInfoId]").length;
        var fabricItems = size == 0 ? "" : [];
        for (var index = 1; index <= size; index++) {
            var fabricItem = {};
            var fabricsInfo = {};
            fabricsInfo.spId = $("#spId" + index).val();
            fabricsInfo.yearCode = $("#yearCode" + index).val();
            fabricsInfo.classicId = $("#classicId" + index).val();
            fabricsInfo.pantoneId = $("#pantoneId" + index).val();
            fabricsInfo.productTypeId = $("#productTypeId" + index).val();
            fabricsInfo.positionId = $("#positionId" + index).val();
            fabricsInfo.materialTypeId = $("#materialTypeId" + index).val();
            fabricsInfo.nameNum = index;
            var fabricsDetailInfo = {};
            fabricsDetailInfo.specificationId = $("#specificationId" + index).val();
            fabricsDetailInfo.dyeId = $("#dyeId" + index).val();
            fabricsDetailInfo.finishId = $("#finishId" + index).val();
            fabricsDetailInfo.blcId = $("#blcId" + index).val();
            fabricsDetailInfo.mcId = $("#mcId" + index).val();
            fabricsDetailInfo.comcId = $("#comcId" + index).val();
            fabricsDetailInfo.wvpId = $("#wvpId" + index).val();
            fabricsDetailInfo.mtId = $("#mtId" + index).val();
            fabricsDetailInfo.woblcid = $("#woblcid" + index).val();
            var materialSpInfo = {};
            materialSpInfo.orderCount = $("#orderCount" + index).val();
            materialSpInfo.attritionRate = $("#attritionRate" + index).val();
            materialSpInfo.unitPrice = $("#unitPrice" + index).val();
            materialSpInfo.totalAmount = $("#totalAmount" + index).val();
            materialSpInfo.totalPrice = $("#totalPrice" + index).val();
            var materialUnitDosage = {};
            materialUnitDosage.unitId = $("#unitId" + index).val();
            materialUnitDosage.unitAmount = $("#unitAmount" + index).val();
            fabricItem.fabricsInfo = fabricsInfo;
            fabricItem.fabricsDetailInfo = fabricsDetailInfo;
            fabricItem.materialSpInfo = fabricsInfo;
            fabricItem.materialUnitDosage = materialUnitDosage;
            fabricItems.push(fabricItem);
        }
        return fabricItems
    }

    function buildBomDesc() {
        $.bominfo.offerAmount = $("#offerAmount").val();
        $.bominfo.fabricsEndDate = $("#fabricsEndDate").val();
        $.bominfo.accessoriesEndDate = $("#accessoriesEndDate").val();
        $.bominfo.preOfferDate = $("#preOfferDate").val();
        $.bominfo.clothReceivedDate = $("#clothReceivedDate").val()
    }

    function bomSaveFun() {
        $.sendJsonAjax(saveUrl, $.bominfo,function () {
        //$.sendRestFulAjax(saveUrl, $.bominfo, 'POST', 'json', function () {
            window.location.href = path + "/development/bom/list"
        })
    }

    function bomSave() {
        buildBomDesc();
        var fabricItems = buildFabricItems();
        $.bominfo.fabricItems = fabricItems;
        bomSaveFun()
    }

    function bomSubmit() {
    }
}(jQuery));