/**
 * Created by zhangjh on 2015/7/14.
 */
(function () {



    "use strict";
    $(function () {

        reloadDetailSelectData();
        initTags();
    })

    //第一次初始化下拉列表
    var reloadDetailSelectData = function () {
        sendRestFulAjax(path + "/system/baseinfo/project_select", null, 'GET', 'json', initSelect);
    }


    /**
     * 初始化标签
     */
    var initTags = function(){
        var tag_input = $('#mainColorIds');
        try{
            tag_input.tag(
                {
                    placeholder:tag_input.attr('placeholder'),
                    //enable typeahead by specifying the source array
                    source: ace.vars['US_STATES']//defined in ace.js >> ace.enable_search_ahead
                    /**
                     //or fetch data from database, fetch those that match "query"
                     source: function(query, process) {
						  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
						  .done(function(result_items){
							process(result_items);
						  });
						}
                     */
                }
            )

            //programmatically add a new
            //var $tag_obj = $('#mainColorIds').data('tag');
            //$tag_obj.add('Programmatically Added');
        }
        catch(e) {
            //display a textarea for old IE, because it doesn't support this plugin or another one I tried!
            tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
            //$('#form-field-tags').autosize({append: "\n"});
        }

    }

    var initSelect = function (_data) {
        var data = _data;
        //年份
        var yearCodeItems = data["yearItems"];
        $("#yearCode").empty();
        $.each(yearCodeItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#yearCode"));
        });


        //客户
        var yearCodeItems = data["customerItems"];
        $("#customerId").empty();
        $.each(yearCodeItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#customerId"));
        });


        //区域
        var areaItems = data["areaItems"];
        $("#areaId").empty();
        $.each(areaItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#areaId"));
        });


        //系列
        var seriesItems = data["seriesItems"];
        $("#seriesId").empty();
        $.each(seriesItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#seriesId"));
        });


        //性别属性
        var sexItems = data["sexItems"];
        $("#sexIds").empty();
        $.each(sexItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#sexIds"));
        });

        //一级品类
        var categoryAItems = data["categoryAItems"];
        $("#categoryAid").empty();
        $.each(categoryAItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#categoryAid"));
        });

        //二级品类
        var categoryBItems = data["categoryBItems"];
        $("#categoryBid").empty();
        $.each(categoryBItems, function (i, item) {
            $("<option></option>")
                .val(item["natrualkey"])
                .text(item["name"])
                .appendTo($("#categoryBid"));
        });

    }


    var saveProject  = function (){
        var $tag_obj = $('#mainColorIds').data('tag');
        console.info("tags :"+ $tag_obj.values);
        project.categoryAid = '';
        project.categoryBid = '';
        project.collectionNumber = '';

        var formDataStr = $("#projectForm").serialize();
        var formDataJson = strToJson(formDataStr);
        console.info("formDataJson :" + formDataJson);



        sendRestFulAjax(path + "/development/project/new", formDataStr, 'POST', 'json', function(){
            console.info("已保存");
        });





    }

    var project ={
        projectId:"",
        projectName:"",
        categoryAid:"",
        categoryBid:"",
        collectionNumber:"",
        sexIds:[],//性别属性
        mainColors:[],//色组
        yearCode:"",
        customerId:"",
        areaId:"",
        seriesId:"",
        sampleDelivery:"",//推销样交期
        isNeedSwatch:"",
        isNeedPreOffer:"",
        needPreOfferDate:"",
        sketchReceivedDate:"",
        fileLocation:[]
    }

    $.saveProject = saveProject;



}());