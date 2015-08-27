/**
 * Created by zhangjh on 2015/7/14.
 */
(function () {
    "use strict";
    $(function () {
        reloadDetailSelectData();
        $("#projectForm").on("change", "select", cb);
    })

    //第一次初始化下拉列表
    var reloadDetailSelectData = function () {
        $.sendRestFulAjax(path + "/system/baseinfo/project_select", null, 'GET', 'json', initSelectCallBack);
    }


    var initSelectCallBack = function (_data) {
        initSelect(_data);
        initOther();
    }

    var initOther = function () {
        var natrualkey = $("#natrualkey").val();
        if (natrualkey != '') {
            $.sendRestFulAjax(path + "/development/project/info/" + natrualkey, null, 'GET', 'json', initFormFields);
        }

    }

    /**
     * 初始化表单
     * @param _data
     */
    var initFormFields = function (_data) {
        console.info("the info of project:" + _data);

        Object.keys(_data).map(function (key) {

            $('#projectForm input').filter(function () {
                return key == this.name;
            }).val(_data[key]);


            if (key == 'categoryBid') {
                var arr = _data[key].split(',');
                $('#categoryBid').selectpicker('val', arr);
            }
            else {
                //下拉框
                $("#" + key).val(_data[key]);
            }
        });


    }


    var initSelect = function (_data) {

        var data = _data;
        //年份
        var yearCodeItems = data["yearItems"];
        $("#yearCode").empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#yearCode"));
        $.each(yearCodeItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#yearCode"));
        });


        //客户
        var yearCodeItems = data["customerItems"];
        $("#customerId").empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#customerId"));
        $.each(yearCodeItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#customerId"));
        });

        //区域
        var areaItems = data["areaItems"];
        $("#areaId").empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#areaId"));
        $.each(areaItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#areaId"));
        });

        //系列
        var seriesItems = data["seriesItems"];
        $("#seriesId").empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#seriesId"));
        $.each(seriesItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#seriesId"));
        });

        //一级品类
        var categoryAItems = data["categoryAItems"];
        $("#categoryAid").empty();
        $("<option></option>").val('').text("请选择...").appendTo($("#categoryAid"));
        $.each(categoryAItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#categoryAid"));
        });


    }

    /**
     *
     */
    var saveProject = function () {
        //执行表单验证
        $('#projectForm').bootstrapValidator('validate');
    }


    var doSaveAction = function () {
        //var $tag_obj = $('#mainColorNames').data('tag');
        project.categoryAid = '';
        project.categoryBid = '';
        //project.collectionNumber = '';

        var formDataStr = $("#projectForm").serialize();
        //var formDataJson = $.strToJson(formDataStr);

        var natrualkey = $("#natrualkey").val();
        var url;
        if (natrualkey === '' || natrualkey === 'null') {
            url = path + "/development/project/new";
        } else {
            url = path + "/development/project/edit";
        }

        var categoryBid = $("#categoryBid").val();
        $.sendRestFulAjax(url, formDataStr + "&categoryBid=" + categoryBid, 'POST', 'json', function () {
            window.location.href = path + "/development/project/list";
        });
    }


    /**
     * 新增/修改校验字段描述
     * @returns {{name: {validators: {notEmpty: {message: string}}}, customerId: {validators: {notEmpty: {message: string}}}}}
     */
    var fieldsDesc =
    {
        yearCode: {
            validators: {
                notEmpty: {
                    message: '年份为必填项'
                }
            }
        },
        customerId: {
            validators: {
                notEmpty: {
                    message: '客户为必填项'
                }
            }
        },
        areaId: {
            validators: {
                notEmpty: {
                    message: '区域为必填项'
                }
            }
        },
        seriesId: {
            validators: {
                notEmpty: {
                    message: '区域为必填项'
                }
            }
        },
        categoryAid: {
            validators: {
                notEmpty: {
                    message: '品类一级名称为必填项'
                }
            }
        },
        categoryBid: {
            validators: {
                notEmpty: {
                    message: '品类二级名称为必填项'
                }
            }
        }
    }


    //启动表单校验监听
    $('#projectForm').bootstrapValidator({
        //live: 'disabled',
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: fieldsDesc
    }).on('success.form.bv', function (e) { //表单校验成功，ajax提交数据
        doSaveAction();
    });


    /**
     * 回调函数
     */
    function cb() {
        if ($(this).attr('id') === 'categoryAid') {
            var categoryAid = $(this).val();
            initCategoryB(categoryAid);
        }
    }

    /**
     * 根据一级品类id的改变，查询二级品类id
     * @param categoryAid
     */
    function initCategoryB(categoryAid) {

        $.sendRestFulAjax(path + "/system/category/searchSecond/" + categoryAid, null, 'GET', 'json', function (data) {

            $('#categoryBid').selectpicker();

            $('#categoryBid').selectpicker({noneSelectedText: '请选择...'});
            //二级品类
            $.each(data, function (index, value) {
                $("<option></option>")
                    .val(value.natrualkey)
                    .text(value.name)
                    .appendTo($("#categoryBid"));
            });


        });
    }


    var project = {
        projectId: "",
        projectName: "",
        categoryAid: "",
        categoryBid: "",
        collectionNumber: "",
        yearCode: "",
        customerId: "",
        areaId: "",
        seriesId: "",
        sampleDelivery: "",//推销样交期
        isNeedSwatch: "",
        isNeedPreOffer: "",
        needPreOfferDate: "",
        sketchReceivedDate: "",
        fileLocation: []
    }

    $.saveProject = saveProject;


}());