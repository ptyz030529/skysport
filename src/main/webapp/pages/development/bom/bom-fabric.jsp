<%--
  Created by IntelliJ IDEA.
  User: zhangjh
  Date: 2015/7/3
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<script id="fabric-template" type="text/x-handlebars-template">
    {{#each fabric}}
    <div id="{{fabricDivId}}" class="bom-info">
        <div class="bom-info form-group" id="{{fabricTitleId}}" style="margin: 0 auto;">
            <label class="col-sm-1 control-label no-padding-right blue">{{fabricTitleName}} </label>
        </div>
        <div id="{{fabricAllInfoId}}" class="bom-info">
            <div id="{{fabricDetailId}}" class="bom-info">
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
                           for="{{pantoneId}}"> 颜色 </label>

                    <div class="col-sm-9">
                        <input type="text" id="{{pantoneId}}" name="pantoneId"
                               placeholder="颜色" class="col-xs-10 col-sm-5"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"
                           for="{{productTypeId}}"> 品名 </label>

                    <div class="col-sm-9">
                        <input type="text" id="{{productTypeId}}" name="productTypeId"
                               placeholder="供应商" class="col-xs-10 col-sm-5"/> <img
                            src="<%=path%>/resources/images/search.png" alt="查找物料" data-toggle="modal"
                            data-target="#materialListModal"/>
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

            <div id="fabricUnitDosage1" class="bom-info">
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"
                           for="{{unitId}}"> 用量单位 </label>

                    <div class="col-sm-9">
                        <input type="text" id="{{unitId}}" name="unitId"
                               placeholder="用量单位" class="col-xs-10 col-sm-5"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"
                           for="{{unitAmount}}"> 用量 </label>

                    <div class="col-sm-9">
                        <input type="text" id="{{unitAmount}}" name="unitAmount"
                               placeholder="用量" class="col-xs-10 col-sm-5"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"
                           for="{{positionId}}"> 物料位置 </label>

                    <div class="col-sm-9">
                        <input type="text" id="{{positionId}}" name="positionId"
                               placeholder="物料位置" class="col-xs-10 col-sm-5"/>
                    </div>
                </div>

            </div>

            <div id="fabricSpinfo1" class="bom-info">
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"
                           for="{{orderCount}}"> 尺码总数量 </label>

                    <div class="col-sm-9">
                        <input type="text" id="{{orderCount}}" name="orderCount"
                               placeholder="尺码总数量" class="col-xs-10 col-sm-5"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"
                           for="{{attritionRate}}"> 损耗率 </label>

                    <div class="col-sm-9">
                        <input type="text" id="{{attritionRate}}" name="attritionRate"
                               placeholder="损耗率" class="col-xs-10 col-sm-5"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"
                           for="{{unitPrice}}"> 单价 </label>

                    <div class="col-sm-9">
                        <input type="text" id="{{unitPrice}}" name="unitPrice"
                               placeholder="单价" class="col-xs-10 col-sm-5"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"
                           for="{{totalAmount}}"> 尺码总数量 </label>

                    <div class="col-sm-9">
                        <input type="text" id="{{totalAmount}}" name="totalAmount"
                               placeholder="尺码总数量" class="col-xs-10 col-sm-5"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"
                           for="{{totalPrice}}"> 总价 </label>

                    <div class="col-sm-9">
                        <input type="text" id="{{totalPrice}}" name="totalPrice"
                               placeholder="总价" class="col-xs-10 col-sm-5"/>
                    </div>
                </div>
            </div>

        </div>


    </div>
    {{/each}}
</script>