<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<SCRIPT type="text/javascript">
    <!--
    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    var zNodes = [
        {id: 1, pId: 0, name: "基础资料", open: true},
        {id: 11, pId: 1, name: "物料管理", open: true},
        {id: 111, pId: 11, name: "面料信息"},
        {id: 112, pId: 11, name: "纱织和密度"},
        {id: 12, pId: 1, name: "供应商信息"},
        {id: 12, pId: 1, name: "成衣厂"},
        {id: 12, pId: 1, name: "客户信息"},
        {id: 2, pId: 0, name: "开发", open: true},
        {id: 21, pId: 2, name: "项目", open: true},
        {id: 211, pId: 21, name: "项目列表"},
        {id: 212, pId: 21, name: "项目新建"},
        {id: 22, pId: 2, name: "BOM", open: true},
        {id: 221, pId: 22, name: "BOM列表"},
        {id: 23, pId: 2, name: "预成本报价", open: true},
    ];

    var code;

    function setCheck() {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
                type = {"Y": "p", "N": "ps"};
        zTree.setting.check.chkboxType = type;

    }


    $(document).ready(function () {
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        setCheck();
    });
    //-->
</SCRIPT>
<h5><small><i class="icon-double-angle-right"></i> 为角色分配权限</small></h5>
选择角色:<select name="roleid"></select>

<div class="content_wrap">
    <div class="zTreeDemoBackground left">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
</div>