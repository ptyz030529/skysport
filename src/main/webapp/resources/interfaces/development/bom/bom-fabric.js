/**
 * Created by zhangjh on 2015/7/10.
 */
(function ($) {
    "use strict";
    $.extend({
        initFabric :initFabric
    });

    function initFabric(fabricItems){
        for(var index =0 ;index<fabricItems.length;index++){
            addFabric(fabricItems[index]);
        }
    }

    /**
     * 启动表单校验监听
     * @param _id 当前表单序号
     */
    var startBootstrapValidatorListner = function (_id) {
        $('#fabricFormId' + _id).bootstrapValidator({
            //live: 'disabled',
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: fieldsDesc
        }).on('success.form.bv', function (e) { //表单校验成功，ajax提交数据
            console.log("面料_" + _id + "验证成功");
            saveFabricFun(_id);
        });
    }

    /**
     * 初始化面料nextIdNum的表单信息
     * @param nextIdNum 面料序号
     * @param _fabricInfo 面料表单值
     */
    function initFabricFields(nextIdNum, _fabricInfo) {

        //保存值
        var fabricInfo = $.extend({},_fabricInfo);
        bom.fabricItems.push(fabricInfo);

        //初始化赋值
        Object.keys(_fabricInfo).map(function (key) {
            //下拉框
            $("#" + key + nextIdNum).val(_fabricInfo[key]);
        });

    }

    /**
     * 添加面料
     */
    var addFabric = function (fabricInfo) {

        //if (fabricInfo == undefined){
        //    fabricInfo = fabric;
        //}

        $("div[id^=fabricAllInfoId]").hide(); //页面加载时，面料全部隐藏

        $("span[id^=fabricEyeId]").removeClass("glyphicon glyphicon-eye-open").addClass("glyphicon glyphicon-eye-close");

        var size = $("div[id^=fabricAllInfoId]").length;

        var nextIdNum = size + 1;

        var data = {
            "fabric": [
                {
                    "currenId": nextIdNum,
                    "fabricDivId": "fabricDivId" + nextIdNum,
                    "fabricTitleId": "fabricTitleId" + nextIdNum,
                    "fabricId": "fabricId" + nextIdNum,
                    "fabricTitleName": "面料_" + nextIdNum,
                    "fabricEyeId": "fabricEyeId" + nextIdNum,
                    "fabricTrashId": "fabricTrashId" + nextIdNum,
                    "fabricRepeatId": "fabricRepeatId" + nextIdNum,
                    "fabricFloppyDiskId": "fabricFloppyDiskId" + nextIdNum,
                    "fabricFormId": "fabricFormId" + nextIdNum,
                    "fabricAllInfoId": "fabricAllInfoId" + nextIdNum,
                    "fabricDetailId": "fabricDetailId" + nextIdNum,
                    "materialTypeId": "materialTypeId" + nextIdNum,
                    "spId": "spId" + nextIdNum,
                    "yearCode": "yearCode" + nextIdNum,
                    "classicId": "classicId" + nextIdNum,
                    "pantoneId": "pantoneId" + nextIdNum,
                    "productTypeId": "productTypeId" + nextIdNum,
                    "specificationId": "specificationId" + nextIdNum,
                    "dyeId": "dyeId" + nextIdNum,
                    "finishId": "finishId" + nextIdNum,
                    "blcId": "blcId" + nextIdNum,
                    "momcId": "momcId" + nextIdNum,
                    "comocId": "comocId" + nextIdNum,
                    "wvpId": "wvpId" + nextIdNum,
                    "mtId": "mtId" + nextIdNum,
                    "woblcId": "woblcId" + nextIdNum,
                    "isShow": "isShow" + nextIdNum,
                    "unitId": "unitId" + nextIdNum,
                    "positionId": "positionId" + nextIdNum,
                    "unitAmount": "unitAmount" + nextIdNum,
                    "orderCount": "orderCount" + nextIdNum,
                    "attritionRate": "attritionRate" + nextIdNum,
                    "unitPrice": "unitPrice" + nextIdNum,
                    "totalAmount": "totalAmount" + nextIdNum,
                    "totalPrice": "totalPrice" + nextIdNum
                }
            ]
        };

        var myTemplate = Handlebars.compile($("#fabric-template").html());
        $("#fabricsItemInfo").append(myTemplate(data));

        //加载下拉列表数据,付初始值
        reloadFabricDetailSelectData(nextIdNum,function(){
            if(fabricInfo != undefined){

                initFabricFields(nextIdNum,fabricInfo);

                $("div[id^=fabricAllInfoId]").hide(); //页面加载时，面料全部隐藏

                $("span[id^=fabricEyeId]").removeClass("glyphicon glyphicon-eye-open").addClass("glyphicon glyphicon-eye-close");
            }

        });

        //表单字段监听
        startBootstrapValidatorListner(nextIdNum);


    }


    //删除面料
    function deleteFraicById(index) {
        bom.fabricItems.splice(index - 1, 1);
    }

    function copyFabric(index){
        if(bom.fabricItems[index] == undefined || $.trim(bom.fabricItems[index]) == ''){
            bootbox.alert("请先保存面料_"+index);
        }
    }

    var deleteFun = function (id) {
        //当前面料id
        var curId = id;
        var fabricArrLength = $("div[id^=fabricAllInfoId]").length;
        //删除当前面料和之后的所有面料
        for (var index = curId; index <= fabricArrLength; index++) {
            //$("div[id^=fabricAllInfoId]")
            $("#fabricDivId" + index).remove();
            //保存当前节点之后的数据
            if (index >= curId) {

                if (index == curId) {
                    deleteFraicById(index);
                }


                var formDataStr = $("#fabricFormId" + (index + 1)).serialize();
                if (formDataStr != '') {
                    saveFabricById(index, formDataStr);
                }

            }
        }
        //重新生成面料
        var maxFabricId = fabricArrLength - 1;
        for (var index = curId; index <= maxFabricId; index++) {
            addFabric();
        }

        $("div[id^=fabricAllInfoId]").hide(); //全部隐藏


    }

    var doDel = function (result, id) {
        if (result) {
            deleteFun(id);
        }
    }

    var trashFabricSelect = function (_this, id) {
        var saveFlag = bom.fabricItems[id - 1].saveFlag;
        if (saveFlag == true) {
            bootbox.confirm("面料_" + id + "已保存，确定要删除", function (result) {
                doDel(result, id);
            });
        }
        else {
            deleteFun(id);
        }

    }

    var saveFabric = function (_this, id) {
        $('#fabricFormId' + id).bootstrapValidator('validate');
    }

    var saveFabricFun = function (id) {
        var formDataStr = $("#fabricFormId" + id).serialize();
        saveFabricById(id, formDataStr);


        bom.fabricItems[id - 1].saveFlag = true;//已保存

    }


    var saveFabricById = function (id, formDataStr) {
        var jsonObj = $.strToJson(formDataStr);
        bom.fabricItems[id - 1] = jsonObj;
        if (!$("#fabricAllInfoId" + id).is(':hidden')) {
            bom.fabricItems[id - 1].showFlag = true;//是否显示
        }
        bom.fabricItems[id - 1].currenId = id;//当前序号
        $.sendRestFulAjax(path + "/development/bom/saveFabricFun", jsonObj, 'GET', 'json', function (data) {
            _doFabricSuccess_info(data, id);
        });
    }


    /**
     * 显示或者展示div
     * @param _this
     * @param id
     */
    var showOrHideFabric = function (_this, id) {
        var fabricEyeId = "#fabricEyeId" + id;
        var fabricTrashId = "#fabricTrashId" + id;
        $("#fabricAllInfoId" + id).toggle(300,
            function () {
                if ($(this).is(':hidden')) {
                    $(fabricEyeId).removeClass("glyphicon glyphicon-eye-open").addClass("glyphicon glyphicon-eye-close");
                    $(fabricTrashId).addClass("disabled");
                }
                else {
                    $(fabricEyeId).removeClass("glyphicon glyphicon-eye-close").addClass("glyphicon glyphicon-eye-open");
                    $(fabricTrashId).removeClass("disabled");
                }
            }
        );
    }

    /**
     * 当后台的基础信息修改后，点击刷新，可以刷新cookies信息
     */
    var refreshFabricSelect = function (_this, id) {
        reloadBomSelect(id);
    }


    var reloadBomSelect = function(id,callback){
        $.sendRestFulAjax(path + "/system/baseinfo/bom_select", null, 'GET', 'json', function (data) {
            _doFabricSuccess_info(data, id,callback);
        });
    }

    //第一次初始化下拉列表
    var reloadFabricDetailSelectData = function (id,callback) {
        reloadBomSelect(id,callback);

        //if ($.cookie('systemBaseMaps') == undefined) {
        //    //第一次初始化下拉列表，存放到cookies中
        //    $.sendRestFulAjax(path + "/system/baseinfo/bom_select", null, 'GET', 'json', function (data) {
        //        _doFabricSuccess_info(data, id);
        //    });
        //}
        //else {
        //    //第二次，直接从cookies中读取
        //    initFabricSelect(nextIdNum);
        //}
    }


    //cookie重新赋值，给下拉列表赋值
    var _doFabricSuccess_info = function (_data, id,callback) {
        //$.cookie('systemBaseMaps', JSON.stringify(_data));//JSON 数据转化成字符串
        initFabricSelect(_data,id,callback);
    }

   //给下拉列表赋值
    var initFabricSelect = function (_data,id,callback) {
        var idNum = id;
        var data = _data;//JSON.parse($.cookie('systemBaseMaps'));//字符串转化成JSON 数据

        //材料类别
        var materialTypeIdItems = data["materialTypeItems"];
        $("#materialTypeId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#materialTypeId"+ idNum));
        $.each(materialTypeIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#materialTypeId" + idNum));
        });

        //供应商
        var spItems = data["spItems"];
        $("#spId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#spId"+ idNum));
        $.each(spItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#spId" + idNum));
        });

        //年份
        var yearCodeItems = data["yearItems"];
        $("#yearCode" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#yearCode"+ idNum));
        $.each(yearCodeItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#yearCode" + idNum));
        });

        //材质列表
        var classicIdItems = data["materialClassicItems"];
        $("#classicId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#classicId"+ idNum));
        $.each(classicIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#classicId" + idNum));
        });


        //品名列表
        var productTypeIdItems = data["productTypeItems"];
        $("#productTypeId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#productTypeId"+ idNum));
        $.each(productTypeIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#productTypeId" + idNum));
        });


        //纱支密度列表
        var specificationIdItems = data["specficationItems"];
        $("#specificationId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#specificationId"+ idNum));
        $.each(specificationIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#specificationId" + idNum));
        });

        //染色方式列表
        var dyeIdItems = data["dyeItems"];
        $("#dyeId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#dyeId"+ idNum));
        $.each(dyeIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#dyeId" + idNum));
        });

        //后整理列表
        var finishIdItems = data["finishItems"];
        $("#finishId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#finishId"+ idNum));
        $.each(finishIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#finishId" + idNum));
        });

        //复合或涂层列表
        var blcIdItems = data["blcItems"];
        $("#blcId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#blcId"+ idNum));
        $.each(blcIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#blcId" + idNum));
        });

        //膜或涂层的材质列表
        var mcIdItems = data["momcItems"];
        $("#momcId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#momcId"+ idNum));
        $.each(mcIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#momcId" + idNum));
        });

        //膜或涂层的颜色列表
        var comcIdItems = data["comocItems"];
        $("#comocId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#comocId"+ idNum));
        $.each(comcIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#comocId" + idNum));
        });

        //透湿程度列表
        var wvpIdItems = data["wvpItems"];
        $("#wvpId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#wvpId"+ idNum));
        $.each(wvpIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#wvpId" + idNum));
        });

        //膜的厚度列表
        var mtIdItems = data["mtItems"];
        $("#mtId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#mtId"+ idNum));
        $.each(mtIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#mtId" + idNum));
        });

        // 贴膜或涂层工艺列表
        var woblcIdItems = data["wblcItems"];
        $("#woblcId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#woblcId"+ idNum));
        $.each(woblcIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#woblcId" + idNum));
        });

        // 物料位置列表
        var positionIdItems = data["positionItems"];
        $("#positionId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#positionId"+ idNum));
        $.each(positionIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#positionId" + idNum));
        });

        // 用量单位列表
        var unitIdItems = data["unitItems"];
        $("#unitId" + idNum).empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#unitId"+ idNum));
        $.each(unitIdItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#unitId" + idNum));
        });


        if($.isFunction(callback)){
            callback();
        }

    }

    /**
     *
     * @type {{bomId: string, fabricId: string, fabricsName: string, materialTypeId: string, classicId: string, spId: string, yearCode: string, productTypeId: string, serialNumber: string, pantoneId: string, positionId: string, dyeId: string, finishId: string, blcId: string, momcId: string, comocId: string, wvpId: string, mtId: string, woblcId: string, unitId: string, unitAmount: string}}
     */
    var fabric = {
        bomId: "",
        fabricId: "",
        nameNum:"",
        fabricsName: "",
        materialTypeId: "",
        classicId: "",
        spId: "",
        yearCode: "",
        productTypeId: "",
        serialNumber: "",
        pantoneId: "",
        positionId: "",
        dyeId: "",
        finishId: "",
        blcId: "",
        momcId: "",
        comocId: "",
        wvpId: "",
        mtId: "",
        woblcId: "",
        unitId: "",
        unitAmount: "",
        showFlag: false,//页面是否展示
        saveFlag: false,//是否已保存
        delFlag: false,//是否已删除
        currenId: 0 //面料下标
    }
    /**
     * 新增/修改校验字段描述
     * @returns {{name: {validators: {notEmpty: {message: string}}}, customerId: {validators: {notEmpty: {message: string}}}}}
     */
    var fieldsDesc =
    {
        materialTypeId: {
            validators: {
                notEmpty: {
                    message: '材料类别为必填项'
                }
            }
        },
        spId: {
            validators: {
                notEmpty: {
                    message: '供应商为必填项'
                }
            }
        },
        yearCode: {
            validators: {
                notEmpty: {
                    message: '年份为必填项'
                }
            }
        },
        classicId: {
            validators: {
                notEmpty: {
                    message: '材质为必填项'
                }
            }
        },
        pantoneId: {
            validators: {
                notEmpty: {
                    message: '颜色为必填项'
                }
            }
        },
        productTypeId: {
            validators: {
                notEmpty: {
                    message: '品名为必填项'
                }
            }
        },
        specificationId: {
            validators: {
                notEmpty: {
                    message: '纱支密度为必填项'
                }
            }
        },
        dyeId: {
            validators: {
                notEmpty: {
                    message: '染色方式为必填项'
                }
            }
        },
        finishId: {
            validators: {
                notEmpty: {
                    message: '后整理为必填项'
                }
            }
        },
        blcId: {
            validators: {
                notEmpty: {
                    message: '复合或涂层为必填项'
                }
            }
        },
        //momcId: {
        //    validators: {
        //        notEmpty: {
        //            message: '膜或涂层材质为必填项'
        //        }
        //    }
        //},
        //comocId: {
        //    validators: {
        //        notEmpty: {
        //            message: '膜或涂层颜色为必填项'
        //        }
        //    }
        //},
        //wvpId: {
        //    validators: {
        //        notEmpty: {
        //            message: '透湿程度为必填项'
        //        }
        //    }
        //},
        //mtId: {
        //    validators: {
        //        notEmpty: {
        //            message: '膜的厚度为必填项'
        //        }
        //    }
        //},
        //woblcId: {
        //    validators: {
        //        notEmpty: {
        //            message: '贴膜或涂层工艺为必填项'
        //        }
        //    }
        //},
        unitId: {
            validators: {
                notEmpty: {
                    message: '用量单位为必填项'
                }
            }
        },
        unitAmount: {
            validators: {
                notEmpty: {
                    message: '用量为必填项'
                }
            }
        },
        positionId: {
            validators: {
                notEmpty: {
                    message: '物料位置为必填项'
                }
            }
        },
        orderCount: {
            validators: {
                notEmpty: {
                    message: '尺码总数量为必填项'
                }
            }
        },
        attritionRate: {
            validators: {
                notEmpty: {
                    message: '损耗率为必填项'
                }
            }
        },
        unitPrice: {
            validators: {
                notEmpty: {
                    message: '单价为必填项'
                }
            }
        },
        totalAmount: {
            validators: {
                notEmpty: {
                    message: '尺码总数量为必填项'
                }
            }
        },
        totalPrice: {
            validators: {
                notEmpty: {
                    message: '总价为必填项'
                }
            }
        }

    };

    /**
     * 面板内容初始化
     */
    $(document).ready(function () {

        //$("#bomDescDetail").hide();

        //第一步，页面加载时，加载所有数据/分步加载数据

        //页面加载时，面料全部隐藏
        $("div[id^=fabricAllInfoId]").hide();



        //点击添加面料
        $("#imgAddFabric").click(function () {
            addFabric();
            //赋初始化值：保存标志，显示标志
            var size = $("div[id^=fabricAllInfoId]").length;
            bom.fabricItems[size - 1] = fabric;
        });

    });
    var bom = {
        projectId: "",//项目id
        bomId: "",//BOMId
        fabricItems: [],//所有面料
        accessorieItems:[],//所有辅料
        fatory:[]//成衣厂
    }
    window.saveFabric = saveFabric;
    window.refreshFabricSelect = refreshFabricSelect;
    window.trashFabricSelect = trashFabricSelect;
    window.showOrHideFabric = showOrHideFabric;
    window.copyFabric = copyFabric;

}(jQuery));
