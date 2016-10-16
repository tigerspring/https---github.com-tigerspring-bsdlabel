<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>标签管理系统</title>
		<%@ include file="./commons/css.jsp" %>
		<%@ include file="./commons/js.jsp" %>
		<%@ include file="./commons/taglib.jsp" %>
	</head>
	<body>
		<div class="header container">
			<div class="row">
				<div class="col-md-8">
				<img src="/assets/img/index/company_logo.jpg" class="company_logo" />
				<p class="logo_txt">标签管理系统</p>
				</div>
				<div class="col-md-4">
					<p class="welcome_txt">欢迎，</p>
					<span class="user">${logUser.loginName}</span>
					<a class="user_exit" href="/logout">
						<p>退出</p>
					</a>
				</div>
			</div>
			<div class="mainNavBox">
				<ul class="navUL">
					<li class="mainLi active"><a href="#" id="registerMag" onclick="clickTab(this,'/registrationinfo/registrationInfoList');">注册证管理</a></li>
					<li class="mainLi"><a href="#" id="labelMag" onclick="clickTab(this,'/skuinfo/skuinfoManage');">标签管理</a></li>
					<li class="mainLi"><a href="#" id="labelPrint" onclick="clickTab(this);">标签打印</a></li>
					<li class="mainLi"><a href="#" id="private" onclick="clickTab(this);">权限管理</a></li>
				</ul>
			</div>
			<div class="pages" id="tabOption"></div>
		</div>
		<script type="text/javascript" src="/assets/js/index.js" ></script>
	</body>
</html>
