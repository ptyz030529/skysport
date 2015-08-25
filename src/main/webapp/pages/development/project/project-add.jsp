<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../base/path.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增/修改项目信息</title>
    <jsp:include page="../../base/common.jsp" flush="true"></jsp:include>
    <jsp:include page="../../base/commonTable.jsp" flush="true"></jsp:include>
    <jsp:include page="../../base/headResources.jsp"></jsp:include>
    <jsp:include page="../../base/upload.jsp"></jsp:include>
    <script language="javascript" type="text/javascript"
            src="<%=path%>/resources/My97DatePicker/WdatePicker.js"></script>
    <script language="javascript" type="text/javascript"    src="<%=path%>/resources/js/bootstrap-multiselect.js"></script>
    <link rel="stylesheet" href="<%=path%>/resources/css/page-header.css"/>
    <link rel="stylesheet" href="<%=path%>/resources/css/bootstrap-multiselect.css"/>
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

        <li><a href="#">用户信息</a></li>
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
            <form class="form-horizontal" role="form" id="projectForm">
                <div id="projectDesc">
                    <div id="projectDescTitle">
                        <h5 class="header smaller lighter blue">
                            基本信息
                            <small></small>
                            <input type="hidden" name="natrualkey" id="natrualkey" value="${natrualkey}"/>
                        </h5>
                    </div>
                    <div id="projectDescDetail">
                        <div class="form-group">
                            <label class="col-xs-2  control-label" for="yearCode"> 年份 </label>

                            <div class="col-xs-3">
                                <select class="col-xs-12" data-style="btn-info" id="yearCode" name="yearCode"
                                        placeholder="年份">
                                </select>
                            </div>
                            <label class="col-xs-2  control-label" for="customerId"> 客户 </label>

                            <div class="col-xs-3">
                                <select class="col-xs-12" data-style="btn-info" id="customerId" name="customerId"
                                        placeholder="客户">
                                </select>
                            </div>

                        </div>

                        <%-- <!-- #section:custom/extra.hr -->
                     <div class="hr hr32 hr-dotted"></div>--%>
                        <div class="form-group">
                            <label class="col-xs-2  control-label" for="areaId"> 区域 </label>

                            <div class="col-xs-3">
                                <select class="col-xs-12" data-style="btn-info" id="areaId" name="areaId"
                                        placeholder="区域">
                                </select>
                            </div>
                            <label class="col-xs-2  control-label" for="seriesId"> 系列 </label>

                            <div class="col-xs-3">
                                <select class="col-xs-12" data-style="btn-info" id="seriesId" name="seriesId"
                                        placeholder="系列">
                                </select>
                            </div>


                        </div>

                        <%--<div class="form-group">

                            <label class="col-xs-2  control-label"
                                   for="name"> 名称 </label>

                            <div class="col-xs-3">
                                <input type="text" id="name" name="name"
                                       placeholder="名称" class="col-xs-10 col-sm-12"/>
                            </div>


                            <label class="col-xs-2  control-label"
                                   for="version"> 版本号 </label>

                            <div class="col-xs-3">
                                <input type="text" id="version" name="version"
                                       placeholder="版本号" class="col-xs-10 col-sm-12"/>
                            </div>

                        </div>--%>


                        <div class="form-group">
                            <label class="col-xs-2  control-label"
                                   for="sampleDelivery"> 样品交付日期 </label>

                            <div class="col-xs-3">
                                <input type="text" id="sampleDelivery" name="sampleDelivery"
                                       placeholder="样品交期" class="col-xs-10 col-sm-12" onClick="WdatePicker()"/>
                            </div>

                            <label class="col-xs-2  control-label"
                                   for="needPreOfferDate"> 预报价日期 </label>

                            <div class="col-xs-3">
                                <input type="text" id="needPreOfferDate" name="needPreOfferDate"
                                       placeholder="预报价日期" class="col-xs-10 col-sm-12" onClick="WdatePicker()"/>
                            </div>

                        </div>

                    </div>
                </div>
                <div id="fabricsInfo">
                    <h5 class="header smaller lighter blue">
                        BOM基础信息
                    </h5>

                    <div id="fabricsItemInfo">
                        <div class="form-group">
                            <label class="col-xs-2  control-label" for="categoryAid"> 品类一级名称 </label>

                            <div class="col-xs-3">
                                <select class="col-xs-12" data-style="btn-info" id="categoryAid" name="categoryAid"
                                        placeholder="品类一级名称">
                                </select>
                            </div>
                            <label class="col-xs-2  control-label" for="categoryBid"> 品类二级名称 </label>

                            <div class="col-xs-3">
                                <select class="col-xs-12" data-style="btn-info" id="categoryBid" name="categoryBid"
                                        placeholder="品类二级名称">
                                </select>
                            </div>

                        </div>

                        <%-- <!-- #section:custom/extra.hr -->
                     <div class="hr hr32 hr-dotted"></div>--%>
                        <div class="form-group">
                            <label class="col-xs-2  control-label" for="sexIds">性别属性</label>
                            <div class="col-xs-3">
                                <!-- #section:plugins/input.multiselect -->
                                <select id="sexIds" multiple="multiple" >
                                </select>
                                <!-- /section:plugins/input.multiselect -->
                            </div>
                            <label class="col-xs-2  control-label"
                                   for="collectionNumber"> 款式数量 </label>

                            <div class="col-xs-3">
                                <input type="text" id="collectionNumber" name="collectionNumber"
                                       placeholder="款式数量" class="col-xs-10 col-sm-12"/>
                            </div>

                        </div>

                        <div class="form-group">
                            <label class="col-xs-2  control-label"
                                   for="mainColorNames"> 色组 </label>

                            <div class="col-xs-3">
                                <!-- #section:plugins/input.tag-input -->
                                <input type="text" class="tags col-xs-12 col-sm-12" name="mainColorNames"
                                       id="mainColorNames" placeholder="输入色组 ..."/>
                                <!-- /section:plugins/input.tag-input -->
                            </div>

                        </div>

                    </div>
                </div>
                <div id="accessoriesInfo">
                    <h5 class="header smaller lighter blue">
                        附件信息
                    </h5>

                    <div class="form-group">

                        <label class="col-xs-2  control-label"
                               for="sketchReceivedDate"> 产品描述收到时间 </label>

                        <div class="col-xs-3">
                            <input type="text" id="sketchReceivedDate" name="sketchReceivedDate"
                                   placeholder="产品描述收到时间" class="col-xs-10 col-sm-12" onClick="WdatePicker()"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2  control-label"
                               for="fileLocation"> 附件上传 </label>

                        <div class="col-xs-10">
                            <input id="fileLocation" class="file" type="file" name="fileLocation" multiple
                                   data-preview-file-type="any" data-upload-url="#" data-preview-file-icon="">
                        </div>

                    </div>
                </div>

                <div id="projectBtnInfo">
                    <div class="col-xs-offset-6 col-xs-9">
                        <button type="button" class="btn btn-info btn-md" onclick="javascript:$.saveProject()">保存
                        </button>
                    </div>
                </div>
            </form>

        </div>
        <!-- Button trigger modal -->
    </div>
</div>
<jsp:include page="../../base/footCommon.jsp"></jsp:include>
<jsp:include page="../../base/aceFoot.jsp"></jsp:include>
</body>
<script>
    $("#fileLocation").fileinput({
        uploadUrl: path + "/development/project/fileUpload", // server upload action
        uploadAsync: true,
        maxFileCount: 5
    });
</script>

</html>
<script type="text/javascript" src="<%=path%>/resources/interfaces/development/project/project-add.js"></script>