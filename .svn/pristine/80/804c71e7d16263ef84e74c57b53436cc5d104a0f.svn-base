<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../base/path.jsp"%>
<jsp:include page="../base/common.jsp"></jsp:include>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function savepro() {
		var saveData = {
			"pid" : "1201",
			"pname" : "zhangjh"
		}; //发送给服务器的JSON
		$.ajax({
			type : "PUT",
			url : "infoJson.json",
			data : JSON.stringify(saveData),
			contentType : "application/json", //发送至服务器的类型
			dataType : "json", //预期服务器返回类型
			success : function(data) {
				console.info("success:"+data['success']);
				console.info("testModel:"+data['testModel']);
				console.info("testModel.pid:"+data['testModel']['pid']);
				console.info("testModel.pname:"+data['testModel']['pname']);
			}
		})
	}
</script>
</head>
<body>
	<div>
		<input type="button" value="保存" onclick="savepro()" />
	</div>
</body>
</html>