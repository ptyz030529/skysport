<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8" %>
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
                        <%--<small>+</small>--%> <img src="<%=path%>/resources/images/add.png" alt="增加面料"   id="imgAddFabric">
                    </h3>

                    <%--<div class="hr hr32 hr-dotted"></div>--%>
                </div>
                <div id="accessoriesInfo">
                    <h3 class="header smaller lighter blue">
                        辅料
                        <%--<small>+</small>--%><img src="<%=path%>/resources/images/add.png" alt="增加辅料"   id="imgAddAccessories">
                    </h3>
                </div>
                <div id="packageMaterialsInfo">
                    <h3 class="header smaller lighter blue">
                        包装材料
                        <%--<small>+</small>--%><img src="<%=path%>/resources/images/add.png" alt="增加包装材料"   id="imgAddPackageMaterials">
                    </h3>
                </div>
                <div id="factoryInfo">
                    <h3 class="header smaller lighter blue">
                        成衣厂
                        <%--<small>+</small>--%><img src="<%=path%>/resources/images/add.png" alt="增加成衣厂"    id="imgAddFacotry">
                    </h3>
                </div>
            </form>

        </div>
        <!-- Button trigger modal -->
    </div>
    <%@ include file="../../system/material/bom-material-list.jsp" %>
</div>
<jsp:include page="../../base/footCommon.jsp"></jsp:include>
<jsp:include page="../../base/aceFoot.jsp"></jsp:include>
<%@ include file="bom-fabric.jsp"%>
</body>



</html>
<script type="text/javascript" src="<%=path%>/resources/development/bom/bom.js"></script>