<%--
  Created by IntelliJ IDEA.
  User: zhangjh
  Date: 2015/7/3
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script id="fabric-template" type="text/x-handlebars-template">
    {{#each fabric}}
    <div id="{{fabricDivId}}" class="bom-info">
        <div class="bom-info form-group" id="{{fabricTitleId}}" style="margin: 0 auto;">
            <label class="col-xs-1 control-label text-left blue" style="text-align: left;">{{fabricTitleName}} </label>
            <label class="col-xs-1 col-md-offset-4 control-label no-padding-right blue ">
                <span  class="glyphicon glyphicon-eye-open" id="{{fabricEyeId}}" onclick="javascript:showOrHideFabric(this,'{{currenId}}')"></span>
            </label>
            <label class="col-xs-1 control-label no-padding-right blue ">
                <span class="glyphicon glyphicon-trash" id="{{fabricTrashId}}" onclick="javascript:trashFabricSelect(this,'{{currenId}}')"></span>
            </label>
            <label class="col-xs-1 control-label no-padding-right blue ">
                <span class="glyphicon glyphicon-repeat" id="{{fabricRepeatId}}" onclick="javascript:refreshFabricSelect(this,'{{currenId}}')"></span>
            </label>
            <label class="col-xs-1 control-label no-padding-right blue ">
                <span class="glyphicon glyphicon-floppy-disk" id="{{fabricFloppyDiskId}}" onclick="javascript:saveFabric(this,'{{currenId}}')"></span>
            </label>
            <label class="col-xs-1 control-label no-padding-right blue ">
                <%--<span class="glyphicons glyphicons-more-items" id="{{fabricCopyId}}" onclick="javascript:copyFabric(this,'{{currenId}}')"></span>--%>
                <span class="glyphicons glyphicons-more-items" id="{{fabricCopyId}}" onclick="javascript:copyFabric(this,'{{currenId}}')"></span>
            </label>
        </div>
        <form id="{{fabricFormId}}" method="post" class="form-horizontal" action="edit">
            <div id="{{fabricAllInfoId}}" class="bom-info">
                <div id="{{fabricDetailId}}" class="bom-info">
                    <div class="form-group">
                        <div class="col-xs-12">
                            <div class="widget-header widget-header-blue widget-header-flat">
                                <i class="ace-icon fa fa-hand-o-right blue"></i> &nbsp;&nbsp;<h5 class="widget-title lighter">{{fabricTitleName}}详细</h5>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label  col-xs-2" for="{{materialTypeId}}"> 材料类别 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{materialTypeId}}"
                                    name="materialTypeId" placeholder="材料类别" >
                                <option value="1" selected>面料</option>
                            </select>
                        </div>
                        <label class="col-xs-2  control-label" for="{{spId}}"> 供应商 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{spId}}" name="fabricsInfo.spId" placeholder="供应商">
                                <option value="1" selected>供应商</option>
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="{{yearCode}}"> 年份 </label>
                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{yearCode}}" name="fabricsInfo.yearCode"
                                    placeholder="年份">
                                <option value="1" selected>年份</option>
                            </select>
                        </div>
                        <label class="col-xs-2  control-label" for="{{classicId}}"> 材质 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{classicId}}" name="fabricsInfo.classicId"
                                    placeholder="材质">
                                <option value="1" selected>材质</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="{{pantoneId}}"> 颜色 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{pantoneId}}" name="fabricsInfo.pantoneId"
                                    placeholder="颜色">
                                <option value="1" selected>颜色</option>
                            </select>
                        </div>
                        <label class="col-xs-2  control-label" for="{{productTypeId}}"> 品名 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{productTypeId}}" name="fabricsInfo.productTypeId"
                                    placeholder="品名">
                                <option value="1" selected>品名</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="{{specificationId}}"> 纱支密度 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{specificationId}}"
                                    name="fabricsDetailInfo.specificationId" placeholder="纱支密度">
                                <option value="1" selected>纱支密度</option>
                            </select>
                        </div>
                        <label class="col-xs-2 control-label" for="{{dyeId}}"> 染色方式 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{dyeId}}" name="fabricsDetailInfo.dyeId"
                                    placeholder="染色方式">
                                <option value="1" selected>染色方式</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="{{finishId}}"> 后整理 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{finishId}}" name="fabricsDetailInfo.finishId"
                                    placeholder="后整理">
                                <option value="1" selected>后整理</option>
                            </select>
                        </div>
                        <label class="col-xs-2  control-label" for="{{blcId}}"> 复合或涂层 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{blcId}}" name="fabricsDetailInfo.blcId"
                                    placeholder="复合或涂层">
                                <option value="1" selected>复合或涂层</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="{{mcId}}"> 膜或涂层材质 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{mcId}}" name="fabricsDetailInfo.mcId"
                                    placeholder="膜或涂层材质">
                                <option value="1" selected>膜或涂层材质</option>
                            </select>
                        </div>
                        <label class="col-xs-2  control-label" for="{{comcId}}"> 膜或涂层颜色 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{comcId}}" name="fabricsDetailInfo.comcId"
                                    placeholder="膜或涂层颜色">
                                <option value="1" selected>膜或涂层颜色</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="{{wvpId}}"> 透湿程度 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{wvpId}}" name="fabricsDetailInfo.wvpId"
                                    placeholder="透湿程度">
                                <option value="1" selected>透湿程度</option>
                            </select>
                        </div>
                        <label class="col-xs-2  control-label" for="{{mtId}}"> 膜的厚度 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{mtId}}" name="fabricsDetailInfo.mtId"
                                    placeholder="膜的厚度">
                                <option value="1" selected>膜的厚度</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="{{woblcid}}"> 贴膜或涂层工艺 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{woblcid}}" name="fabricsDetailInfo.woblcid"
                                    placeholder="贴膜或涂层工艺">
                                <option value="1" selected>贴膜或涂层工艺</option>
                            </select>
                        </div>

                    </div>
                </div>

                <div id="fabricUnitDosage1" class="bom-info">
                    <div class="form-group">
                        <div class="col-xs-12">
                            <div class="widget-header widget-header-blue widget-header-flat">
                                <i class="ace-icon fa fa-hand-o-right blue"></i> &nbsp;&nbsp;<h5 class="widget-title lighter">{{fabricTitleName}}用量</h5>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="{{unitId}}"> 用量单位 </label>

                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{unitId}}" name="materialUnitDosage.unitId"
                                    placeholder="用量单位">
                            </select>
                        </div>
                        <label class="col-xs-2  control-label" for="{{positionId}}"> 物料位置 </label>
                        <div class="col-xs-3">
                            <select class="col-xs-12" data-style="btn-info" id="{{positionId}}" name="fabricsInfo.positionId"    placeholder="物料位置">
                            </select>
                        </div>

                    </div>

                    <div class="form-group">
                        <label class="col-xs-2  control-label"
                               for="{{unitAmount}}"> 用量 </label>
                        <div class="col-xs-3">
                            <input type="text" id="{{unitAmount}}" name="materialUnitDosage.unitAmount"
                                   placeholder="用量" class="col-xs-10 col-sm-12"/>
                        </div>
                    </div>

                </div>

                <div id="fabricSpinfo1" class="bom-info">
                    <div class="form-group">
                        <div class="col-xs-12">
                            <div class="widget-header widget-header-blue widget-header-flat">
                                <i class="ace-icon fa fa-hand-o-right blue"></i> &nbsp;&nbsp;<h5 class="widget-title lighter">{{fabricTitleName}}供应商信息</h5>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2  control-label"
                               for="{{orderCount}}"> 尺码总数量 </label>

                        <div class="col-xs-3">
                            <input type="text" id="{{orderCount}}" name="materialSpInfo.orderCount"
                                   placeholder="尺码总数量" class="col-xs-10 col-sm-12"/>
                        </div>

                        <label class="col-xs-2  control-label"
                               for="{{attritionRate}}"> 损耗率 </label>

                        <div class="col-xs-3">
                            <input type="text" id="{{attritionRate}}" name="materialSpInfo.attritionRate"
                                   placeholder="损耗率" class="col-xs-10 col-sm-12"/>
                        </div>

                    </div>

                    <div class="form-group">
                        <label class="col-xs-2  control-label"
                               for="{{unitPrice}}"> 单价 </label>

                        <div class="col-xs-3">
                            <input type="text" id="{{unitPrice}}" name="materialSpInfo.unitPrice"
                                   placeholder="单价" class="col-xs-10 col-sm-12"/>
                        </div>

                        <label class="col-xs-2  control-label"
                               for="{{totalAmount}}"> 尺码总数量 </label>

                        <div class="col-xs-3">
                            <input type="text" id="{{totalAmount}}" name="materialSpInfo.totalAmount"
                                   placeholder="尺码总数量" class="col-xs-10 col-sm-12"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2  control-label"
                               for="{{totalPrice}}"> 总价 </label>

                        <div class="col-xs-3">
                            <input type="text" id="{{totalPrice}}" name="materialSpInfo.totalPrice"
                                   placeholder="总价" class="col-xs-10 col-sm-12"/>
                        </div>
                    </div>
                </div>

            </div>
        </form>

    </div>
    {{/each}}
</script>