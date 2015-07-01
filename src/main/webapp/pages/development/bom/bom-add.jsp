<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../../base/path.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>新建BOM信息</title>
    <jsp:include page="../../base/common.jsp" flush="true"></jsp:include>
    <jsp:include page="../../base/commonTable.jsp" flush="true"></jsp:include>
    <jsp:include page="../../base/headResources.jsp"></jsp:include>
    <link rel="stylesheet" href="<%=path%>/resources/css/page-header.css"/>
</head>
<body>
<div class="breadcrumbs" id="breadcrumbs">
    <script type="text/javascript">
        try {
            ace.settings.check('breadcrumbs', 'fixed')
        } catch (e) {

        }
    </script>

    <ul class="breadcrumb">
        <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">开发</a>
        </li>

        <li><a href="#">BOM</a></li>
        <li class="active">新增和修改</li>
    </ul>
    <!-- /.breadcrumb -->
    <!-- /section:basics/content.searchbox -->
</div>

<div class="page-content">
    <%--<%@ include file="base/ace-setting.jsp"%>--%>

    <!-- PAGE CONTENT BEGINS -->
    <div class="row">
        <div class="col-xs-12">
            <form class="form-horizontal" role="form">
                <div id="bomDesc">
                    <div id="bomDescTitle">
                        <h3 class="header smaller lighter blue">
                            描述
                            <small></small>
                        </h3>
                    </div>
                    <div id="bomDescDetail">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                                   for="customerId"> 客户 </label>

                            <div class="col-sm-9">
                                <input type="text" id="customerId" name="customerId"
                                       placeholder="客户" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                                   for="areaId"> 区域 </label>

                            <div class="col-sm-9">
                                <input type="text" id="areaId" id="name" placeholder="区域"
                                       class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <%-- <!-- #section:custom/extra.hr -->
                     <div class="hr hr32 hr-dotted"></div>--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                                   for="areaId"> 系列 </label>

                            <div class="col-sm-9">
                                <input type="text" id="seriesId" name="seriesId"
                                       placeholder="系列" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                                   for="areaId"> 款式 </label>

                            <div class="col-sm-9">
                                <input type="text" id="collectionNum" name="collectionNum"
                                       placeholder="款式" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                                   for="areaId"> 主颜色 </label>

                            <div class="col-sm-9">
                                <input type="text" id="mainColor" name="mainColor"
                                       placeholder="主颜色" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                                   for="areaId"> 订单数量 </label>

                            <div class="col-sm-9">
                                <input type="text" id="offerAmount" name="offerAmount"
                                       placeholder="订单数量" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                                   for="areaId"> 面料交货时间 </label>

                            <div class="col-sm-9">
                                <input type="text" id="fabricsEndDate" name="fabricsEndDate"
                                       placeholder="面料交货时间" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                                   for="areaId"> 辅料交货时间 </label>

                            <div class="col-sm-9">
                                <input type="text" id="accessoriesEndDate"
                                       name="accessoriesEndDate" placeholder="辅料交货时间"
                                       class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                                   for="areaId"> 成衣报价时间 </label>

                            <div class="col-sm-9">
                                <input type="text" id="preOfferDate" name="preOfferDate"
                                       placeholder="成衣报价时间" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                                   for="areaId"> 成衣收到时间 </label>

                            <div class="col-sm-9">
                                <input type="text" id="clothReceivedDate"
                                       name="clothReceivedDate" placeholder="成衣收到时间"
                                       class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="fabricsInfo">
                    <h3 class="header smaller lighter blue">
                        面料
                        <%--<small>+</small>--%> <img src="<%=path%>/resources/images/add.png" alt="增加面料" id="imgAddFabric">
                    </h3>
                    <%--<div class="hr hr32 hr-dotted"></div>--%>
                </div>

                <h3 class="header smaller lighter blue">
                    辅料
                    <small>+</small>
                </h3>

                <h3 class="header smaller lighter blue">
                    包装材料
                    <small>+</small>
                </h3>

                <h3 class="header smaller lighter blue">
                    成衣厂
                    <small>+</small>
                </h3>

            </form>

        </div>
        <!-- Button trigger modal -->
    </div>
        <%@ include file="../../system/material/material-list.jsp"%>
</div>
<jsp:include page="../../base/footCommon.jsp"></jsp:include>
<jsp:include page="../../base/aceFoot.jsp"></jsp:include>
<script id="fabric-template" type="text/x-handlebars-template">
    {{#each fabric}}
    <div id="{{fabricDivId}}" class="bom-info">
        <div class="bom-info form-group" id="{{fabricTitleId}}" style="margin: 0 auto;">
            <label class="col-sm-1 control-label no-padding-right blue">{{fabricTitleName}} </label>
        </div>
        <div id="{{fabricDetailId}}">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{materialTypeId}}"> 材料类别 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{materialTypeId}}" name="materialTypeId"
                           placeholder="材料类别" class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{spId}}"> 供应商 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{spId}}" name="spId" placeholder="供应商"
                           class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{yearCode}}"> 年份 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{yearCode}}" name="yearCode"
                           placeholder="年份" class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{classicId}}"> 材质 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{classicId}}" name="classicId"
                           placeholder="材质" class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{productTypeId}}"> 品名 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{productTypeId}}" name="productTypeId"
                           placeholder="供应商" class="col-xs-10 col-sm-5"/> <img
                        src="<%=path%>/resources/images/search.png" alt="查找物料" data-toggle="modal" data-target="#materialListModal" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{specificationId}}"> 纱支密度 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{specificationId}}" name="specificationId"
                           placeholder="纱支密度" class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{dyeId}}"> 染色方式 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{dyeId}}" name="dyeId" placeholder="染色方式"
                           class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{finishId}}"> 后整理 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{finishId}}" name="finishId"
                           placeholder="后整理" class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{blcId}}"> 复合或涂层 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{blcId}}" name="blcId" placeholder="复合或涂层"
                           class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{mcId}}"> 膜或涂层的材质 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{mcId}}" name="mcId" placeholder="膜或涂层的材质"
                           class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{comcId}}"> 膜或涂层的颜色 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{comcId}}" name="comcId"
                           placeholder="膜或涂层的颜色" class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{wvpId}}"> 透湿程度 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{wvpId}}" name="wvpId" placeholder="透湿程度"
                           class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{mtId}}"> 膜的厚度 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{mtId}}" name="mtId" placeholder="膜的厚度"
                           class="col-xs-10 col-sm-5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"
                       for="{{woblcid}}"> 贴膜或涂层工艺 </label>

                <div class="col-sm-9">
                    <input type="text" id="{{woblcid}}" name="woblcid"
                           placeholder="贴膜或涂层工艺" class="col-xs-10 col-sm-5"/>
                </div>
            </div>
        </div>
    </div>
    {{/each}}
</script>
</body>

<script type="text/javascript">
    var fabricArr = [];
    $(document).ready(function () {
        //第一步，页面加载时，加载所有数据/分步加载数据


        $("div[id^=fabricDetail]").hide(); //页面加载时，面料全部隐藏
        /* $("[name='my-checkbox']").bootstrapSwitch();
         $('input[name="my-checkbox"]').on(
         'switchChange.bootstrapSwitch', function (event, state) {
         console.log(this); // DOM element
         console.log(event); // jQuery event
         console.log(state); // true | false
         if (state) {
         $("#fabricDetail1").fadeIn();
         } else {

         $("#fabricDetail1").fadeOut();
         }

         });*/

        $("#bomDescTitle").click(function () {
            $("#bomDescDetail").toggle(300);
        });
//        $("#fabricsInfo").click(function () {
//            $("div[id^=fabricDetailId]").toggle(300);
//        });

//        $("#fabricTitle1").click(function () {
//            $("#fabricDetail1").toggle(300);
//        });
//        $("#fabricTitle2").click(function () {
//            $("#fabricDetail2").toggle(300);
//        });

//        $("div[id^=fabricTitleId]").click(function () {
//            $(this).toggle(300);
//        });

        $("#imgAddFabric").click(function(){
           $("#bomDescDetail").hide(300);
           var size = $("div[id^=fabricTitle]").length;
           var nextIdNum= size +1;
           var data ={
               "fabric":[
                   {
                       "fabricDivId":"fabricDivId"+nextIdNum,
                       "fabricTitleId":"fabricTitleId"+nextIdNum,
                       "fabricTitleName":"面料"+nextIdNum,
                       "fabricDetailId":"fabricDetailId"+nextIdNum,
                       "materialTypeId":"materialTypeId"+nextIdNum,
                       "spId":"spId"+nextIdNum,
                       "yearCode":"yearCode"+nextIdNum,
                       "classicId":"classicId"+nextIdNum,
                       "productTypeId":"productTypeId"+nextIdNum,
                       "specificationId":"specificationId"+nextIdNum,
                       "dyeId":"dyeId"+nextIdNum,
                       "finishId":"finishId"+nextIdNum,
                       "blcId":"blcId"+nextIdNum,
                       "mcId":"mcId"+nextIdNum,
                       "comcId":"comcId"+nextIdNum,
                       "wvpId":"wvpId"+nextIdNum,
                       "mtId":"mtId"+nextIdNum,
                       "woblcid":"woblcid"+nextIdNum

                   }

               ]
           };

            var myTemplate = Handlebars.compile($("#fabric-template").html());
            $("#fabricsInfo").append(myTemplate(data));

            //添加隐藏和显示事件
            $("#fabricTitleId"+nextIdNum).click(function () {
                $("#fabricDetailId"+nextIdNum).toggle(300);
            });


        });

//        $('#materialListModal').on('show.bs.modal', function (e) {
//            $(this).find('.modal-dialog').css({
//                'margin-top': function () {
//                    var modalHeight = $('#materialListModal').find('.modal-dialog').height();
//                    return ($(window).height() / 2 - (modalHeight / 2));
//                }
//            });
//        });


    });


</script>

</html>
