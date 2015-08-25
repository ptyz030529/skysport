<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="page-content">
    <!-- PAGE CONTENT BEGINS -->
    <div class="row">
        <div class="col-xs-12">
            <table id="example" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>用户类型</th>
                    <th>是否在线</th>
                    <th>是否锁定</th>
                    <th>受权限限制</th>
                    <th>上次登录时间</th>
                    <th>备注</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody></tbody>
                <!-- tbody是必须的 -->
            </table>
        </div>
        <!-- Button trigger modal -->
    </div>

</div>
<jsp:include page="../../base/footCommon.jsp"></jsp:include>
<!--定义操作列按钮模板-->
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="btn btn-{{this.type}} btn-sm" onclick="{{this.fn}}">{{this.name}}</button>
    {{/each}}
</script>
<script type="text/javascript" src="<%=path%>/resources/interfaces/system/permission/userinfo.js"></script>
<script type="text/javascript" src="<%=path%>/resources/interfaces/system/list.js"></script>
