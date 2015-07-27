/*!
 * bominfo
 * Copyright 2011-2015 zhangjh.
 * Licensed under MTT (https://github.com/firebata/skysport/blob/master/LICENSE)
 */
(function ($) {
    $.bominfo = {};
    var saveUrl = path + "/development/bom/edit";
    var infoUrl = path + "/development/bom/info/";
    var listUrl = path + "/development/bom/list";
    $.extend({bomSave: bomSave, bomSubmit: bomSubmit});
    $(function () {
        initBom()
    });

    function initBom() {
        //初始化秒速信息
        var natrualkey = $("#natrualkey").val();
        $.initDesc(natrualkey);
    }


    function buildFabricItems() {
        var size = $("div[id^=fabricAllInfoId]").length;
        var fabricItems = [];
        for (var index = 1; index <= size; index++) {
            var fabricItem = {};
            var fabricsInfo = {};//面料基本信息
            fabricsInfo.spId = $("#spId" + index).val();
            fabricsInfo.yearCode = $("#yearCode" + index).val();
            fabricsInfo.classicId = $("#classicId" + index).val();
            fabricsInfo.pantoneId = $("#pantoneId" + index).val();
            fabricsInfo.productTypeId = $("#productTypeId" + index).val();
            fabricsInfo.positionId = $("#positionId" + index).val();
            fabricsInfo.materialTypeId = $("#materialTypeId" + index).val();
            fabricsInfo.nameNum = index;
            var fabricsDetailInfo = {};//面料描述信息
            fabricsDetailInfo.specificationId = $("#specificationId" + index).val();
            fabricsDetailInfo.dyeId = $("#dyeId" + index).val();
            fabricsDetailInfo.finishId = $("#finishId" + index).val();
            fabricsDetailInfo.blcId = $("#blcId" + index).val();
            fabricsDetailInfo.mcId = $("#mcId" + index).val();
            fabricsDetailInfo.comcId = $("#comcId" + index).val();
            fabricsDetailInfo.wvpId = $("#wvpId" + index).val();
            fabricsDetailInfo.mtId = $("#mtId" + index).val();
            fabricsDetailInfo.woblcid = $("#woblcid" + index).val();
            var materialSpInfo = {};//面料用量信息
            materialSpInfo.orderCount = $("#orderCount" + index).val();
            materialSpInfo.attritionRate = $("#attritionRate" + index).val();
            materialSpInfo.unitPrice = $("#unitPrice" + index).val();
            materialSpInfo.totalAmount = $("#totalAmount" + index).val();
            materialSpInfo.totalPrice = $("#totalPrice" + index).val();
            var materialUnitDosage = {};//面料单位用量
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
        $.bominfo.natrualkey = $("#natrualkey").val()
    }

    /**
     * 保存数据
     */
    function bomSaveFun() {
        $.sendJsonAjax(saveUrl, $.bominfo, function () {
            //$.sendRestFulAjax(saveUrl, $.bominfo, 'POST', 'json', function () {
            window.location.href = path + listUrl;
        })
    }

    /**
     * 构建保存数据，并保存
     */
    function bomSave() {
        //描述信息
        buildBomDesc();
        //面料信息
        var fabricItems = buildFabricItems();
        $.bominfo.fabricItems = fabricItems;
        bomSaveFun()
    }

    function bomSubmit() {

    }
}(jQuery));