<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="sidebar responsive" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>
    <ul class="nav nav-list">
        <li>
            <a href="#" class="dropdown-toggle">
                <span class="menu-text"> 任务管理 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <ul class="submenu">
                <li>
                    <a href="javascript:onclick('<%=path%>/task/list/undo')">
                       我的待办
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('<%=path%>/task/list/done')">
                        历史任务
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('<%=path%>/task/list/all')">
                        所有待办
                    </a>
                </li>
            </ul>

        </li>


        <li>
            <a href="javascript:onclick('<%=path%>/system/sp/list')" class="dropdown-toggle">
                <span class="menu-text"> 基础资料 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <ul class="submenu">

                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-caret-right"></i>
                        物料管理
                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="">
                            <a href="javascript:onclick('system/fabrics/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                面料信息
                            </a>
                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="javascript:onclick('system/material/specification/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                纱支和密度
                            </a>
                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="javascript:onclick('system/material/dye/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                染色方式
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('system/material/finish/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                后整理
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('system/material/blc/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                复合或涂层
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('system/material/momc/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                膜或涂层的材质
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('system/material/comoc/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                膜或涂层的颜色
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('system/material/wvp/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                透湿程度
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('system/material/mt/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                膜的厚度
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('system/material/wblc/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                贴膜或涂层工艺
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('system/material/position/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                物料位置
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('system/material/unit/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                物料单位
                            </a>
                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:onclick('system/sp/list')">
                        供应商信息
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/factory/list')">
                        成衣厂
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/customer/list')">
                        客户信息
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/area/list')">
                        区域信息
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/series/list')">
                        系列信息
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/pantone/list')">
                        PANTONE
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/category/list')">
                        品类级别
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/sex/list')">
                        性别属性
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/material_type/list')">
                        材料类别
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/material_classic/list')">
                        材质分类
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/product_type/list')">
                        品名信息
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('system/sp_kind/list')">
                        主颜色
                    </a>
                </li>
                <%--	<li>
                        <a href="javascript:onclick('system/year_conf/list')">
                            年份管理
                        </a>
                    </li>
          --%>

                <li>
                    <a href="#<%--javascript:onclick('system/time_conf/list')--%>">
                        时间节点
                    </a>
                </li>


            </ul>

        </li>

        <li>
            <a href="#" class="dropdown-toggle">

                <span class="menu-text"> 开发 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <ul class="submenu">
                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-caret-right"></i>
                        项目
                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="">
                            <a href="javascript:onclick('<%=path%>/development/project/add/null')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                项目新建
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('<%=path%>/development/project/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                项目列表
                            </a>

                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:onclick('<%=path%>/development/project_item/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                子项目列表
                            </a>
                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>
                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-caret-right"></i>
                        BOM
                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="">
                            <a href="javascript:onclick('<%=path%>/development/bom/list')">
                                <i class="menu-icon fa fa-caret-right"></i>
                                BOM列表
                            </a>

                            <b class="arrow"></b>
                        </li>

                    </ul>
                </li>
                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-caret-right"></i>
                        开发控制流
                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="">
                            <a href="top-menu.html">
                                <i class="menu-icon fa fa-caret-right"></i>
                                预报价
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="two-menu-1.html">
                                <i class="menu-icon fa fa-caret-right"></i>
                                色样报价
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="two-menu-2.html">
                                <i class="menu-icon fa fa-caret-right"></i>
                                正式报价
                            </a>
                            <b class="arrow"></b>
                        </li>

                    </ul>
                </li>

                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-caret-right"></i>
                        面辅料生产通知单
                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="">
                            <a href="top-menu.html">
                                <i class="menu-icon fa fa-caret-right"></i>
                                面辅料生产通知单列表
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="two-menu-1.html">
                                <i class="menu-icon fa fa-caret-right"></i>
                                面料生产通知单信息
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="two-menu-2.html">
                                <i class="menu-icon fa fa-caret-right"></i>
                                辅料生产通知单
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="mobile-menu-1.html">
                                <i class="menu-icon fa fa-caret-right"></i>
                                成衣厂生产通知单
                            </a>
                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
        <li class="active">
            <a href="#">

                <span class="menu-text"> 市场部 </span>
            </a>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">

                <span class="menu-text"> 品管 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

        </li>
        <li>
            <a href="#" class="dropdown-toggle">

                <span class="menu-text"> 财务 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

        </li>

        <li>
            <a href="#" class="dropdown-toggle">

                <span class="menu-text"> 管理部 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <ul class="submenu">
                <li>
                    <a href="#">
                        目标管理
                    </a>
                </li>
                <li>
                    <a href="#">
                        文件管理
                    </a>
                </li>
                <li>
                    <a href="#">
                        人事管理
                    </a>
                </li>
                <li>
                    <a href="#">
                        行政管理
                    </a>
                </li>
                <li>
                    <a href="#">
                        财务管理
                    </a>
                </li>
                <li>
                    <a href="#">
                        供应商管理
                    </a>
                </li>
                <li>
                    <a href="#">
                        客户管理
                    </a>
                </li>
                <li>
                    <a href="#">
                        仓库管理
                    </a>
                </li>
                <li>
                    <a href="#">
                        销售管理
                    </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">

                <span class="menu-text"> 采购部</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

        </li>
        <li>
            <a href="#" class="dropdown-toggle">

                <span class="menu-text"> 客户接口 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

        </li>
        <li>
            <a href="#" class="dropdown-toggle">

                <span class="menu-text"> 供应商接口 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

        </li>
        <li>
            <a href="#" class="dropdown-toggle">

                <span class="menu-text"> 运营 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <span class="menu-text"> 系统管理 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <ul class="submenu">
                <li>
                    <a href="javascript:onclick('<%=path%>/system/permission/user-tab/3')">
                        用户& 权限
                    </a>
                </li>
                <li>
                    <a href="javascript:onclick('<%=path%>/system/permission/user-tab')">
                        个人信息
                    </a>
                </li>
                <li>
                    <a href="#">
                        信箱
                    </a>
                </li>
                <li>
                    <a href="#">
                        改密码
                    </a>
                </li>
            </ul>

        </li>
    </ul>
    <!-- /.nav-list -->
    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left"
           data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <!-- /section:basics/sidebar.layout.minimize -->
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>