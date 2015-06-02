<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../base/path.jsp"%>
<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='<%=path%>/resources/js/jquery.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='<%=path%>/resources/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='<%=path%>/resources/js/jquery.mobile.custom.js'>"+"<"+"/script>");
</script>
<script src="<%=path%>/resources/js/bootstrap.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="<%=path%>/resources/js/excanvas.js"></script>
<![endif]-->
<script src="<%=path%>/resources/js/jquery-ui.custom.js"></script>
<script src="<%=path%>/resources/js/jquery.ui.touch-punch.js"></script>
<script src="<%=path%>/resources/js/jquery.easypiechart.js"></script>
<script src="<%=path%>/resources/js/jquery.sparkline.js"></script>
<script src="<%=path%>/resources/js/flot/jquery.flot.js"></script>
<script src="<%=path%>/resources/js/flot/jquery.flot.pie.js"></script>
<script src="<%=path%>/resources/js/flot/jquery.flot.resize.js"></script>

<jsp:include page="aceFoot.jsp" flush="true"/>