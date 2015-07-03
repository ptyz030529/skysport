/**
 * Created by zhangjh on 2015/7/3.
 */
var fabricArr = [];
$(document).ready(function () {
    //第一步，页面加载时，加载所有数据/分步加载数据

    $("div[id^=fabricDetail]").hide(); //页面加载时，面料全部隐藏

    $("#bomDescTitle").click(function () {
        $("#bomDescDetail").toggle(300);
    });

    $("#imgAddFabric").click(function () {
        $("#bomDescDetail").hide(300);
        var size = $("div[id^=fabricTitle]").length;
        var nextIdNum = size + 1;
        var data = {
            "fabric": [
                {
                    "fabricDivId": "fabricDivId" + nextIdNum,
                    "fabricTitleId": "fabricTitleId" + nextIdNum,
                    "fabricTitleName": "面料" + nextIdNum,
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
            $("#fabricDetailId" + nextIdNum).toggle(300);
        });

    });

});