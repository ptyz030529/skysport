/**
 * Created by zhangjh on 2015/7/3.
 */
var fabricArr = [];
$(document).ready(function () {

    $("#bomDescDetail").hide();

    //第一步，页面加载时，加载所有数据/分步加载数据
    $("div[id^=fabricAllInfoId]").hide(); //页面加载时，面料全部隐藏

    $("#bomDescTitle").click(function () {
        $("#bomDescDetail").toggle(300);
    });

    //点击添加面料
    $("#imgAddFabric").click(function () {

        $("div[id^=fabricAllInfoId]").hide(); //页面加载时，面料全部隐藏

        var size = $("div[id^=fabricAllInfoId]").length;
        var nextIdNum = size + 1;
        var data = {
            "fabric": [
                {
                    "fabricDivId": "fabricDivId" + nextIdNum,
                    "fabricTitleId": "fabricTitleId" + nextIdNum,
                    "fabricTitleName": "面料_" + nextIdNum,
                    "fabricAllInfoId": "fabricAllInfoId" + nextIdNum,
                    "fabricDetailId": "fabricDetailId" + nextIdNum,
                    "materialTypeId": "materialTypeId" + nextIdNum,
                    "spId": "spId" + nextIdNum,
                    "yearCode": "yearCode" + nextIdNum,
                    "classicId": "classicId" + nextIdNum,
                    "productTypeId": "productTypeId" + nextIdNum,
                    "specificationId": "specificationId" + nextIdNum,
                    "dyeId": "dyeId" + nextIdNum,
                    "finishId": "finishId" + nextIdNum,
                    "blcId": "blcId" + nextIdNum,
                    "mcId": "mcId" + nextIdNum,
                    "comcId": "comcId" + nextIdNum,
                    "wvpId": "wvpId" + nextIdNum,
                    "mtId": "mtId" + nextIdNum,
                    "woblcid": "woblcid" + nextIdNum


                }

            ]
        };

        var myTemplate = Handlebars.compile($("#fabric-template").html());
        $("#fabricsInfo").append(myTemplate(data));

        //添加隐藏和显示事件
        $("#fabricTitleId" + nextIdNum).click(function () {
            $(this).toggle(300);
            $(this).parent().siblings().fadeOut(300);//隐藏其他面料
            //$("#fabricAllInfoId" + nextIdNum).toggle(300);
        })

    });

});