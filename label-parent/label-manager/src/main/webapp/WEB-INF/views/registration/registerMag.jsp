<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册证管理</title>
		<%@ include file="../commons/css.jsp" %>
		<%@ include file="../commons/js.jsp" %>
	</head>
	<body>
		<div class="registerAdd">
          	<form class="form-inline myRegister">
				<button type="button" class="btn btn-primary addBtn" data-toggle="modal" data-target="#editDialog" onclick="edit('/registrationinfo/addregistration')">
						新增
				</button>
				<button type="button" class="btn btn-primary importBtn" data-toggle="modal" data-target="#importDialog" onclick="importUrl('/registrationinfo/importData')">
						批量导入
				</button>
          	</form>
          	<!-- 列表 -->
			<div class="row searchTb"> </div>
			<!-- 分页 -->
			<div id="Pagination"></div>
        </div>
        <%@include file="../commons/editDialog.jsp" %>
        <%@include file="../commons/deleteDialog.jsp" %>
        <!-- 导入 -->
        <%@include file="../commons/importDialog.jsp" %>
	</body>
	<script type="text/javascript" src="/assets/js/registerMag.js"/>
</html>
