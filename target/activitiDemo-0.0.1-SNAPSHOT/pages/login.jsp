<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base/path.jsp"%>
<jsp:include page="base/common.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<title>登录页面</title>
<meta name="keywords" content="翊凯供应链" />
<meta name="description" content="翊凯供应链系统登录页面" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel="stylesheet" href="<%=path%>/resources/css/reset.css">
<link rel="stylesheet" href="<%=path%>/resources/css/supersized.css">
<link rel="stylesheet" href="<%=path%>/resources/css/style.css">
</head>

<body>

	<div class="page-container">

		<h1>Sky-Sport</h1>
		<form action="<%=path%>/login" method="post">
			
				<input type="text" name="username" class="username"
					placeholder="用户名"> <input type="password" name="password"
					class="password" placeholder="密码">
				<button type="submit">登录</button>
				<div class="error">
					<span>+</span>
				</div>

		

		</form>
		<!-- 	<div class="connect">
			<p>Or connect with:</p>
			<p>
				<a class="facebook" href=""></a> <a class="twitter" href=""></a>
			</p>
		</div> -->
	</div>

	<script src="<%=path%>/resources/js/jquery-1.8.2.min.js"></script>
	<script src="<%=path%>/resources/js/supersized.3.2.7.min.js"></script>
	<script src="<%=path%>/resources/js/supersized-init.js"></script>
	<script src="<%=path%>/resources/js/scripts.js"></script>

</body>

</html>