<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SKU管理</title>
		<%@ include file="../commons/css.jsp" %>
		<%@ include file="../commons/js.jsp" %>
		<link rel="stylesheet" href="/assets/css/jqueryui/jquery-ui-1.10.4.custom.css" />
		<script src="/assets/js/jqueryui/jquery-ui-1.10.4.custom.js"></script>
	</head>
	<body>
		<div class="registerAdd">
          	<form class="form-inline myRegister" id="searchForm">
          		<div class="form-group">
					<label for="lastname" class="col-sm-5 control-label">产品代码(SKU)：</label>
					<div class="col-sm-5">
						<input type="text" class="form-control myInput" name="skuNo" id="skuNo"
							   placeholder="请输入产品代码" required="required">
					</div>
				</div>
				<button type="button" class="btn btn-primary " onclick="searchSubmit();">
						查询
				</button>
				<button type="button" class="btn btn-primary addBtn" data-toggle="modal" data-target="#editDialog" onclick="edit('/skuinfo/addLabel')">
						新增
				</button>
				<button type="button" class="btn btn-primary importBtn" data-toggle="modal" data-target="#labelImportModal">
						批量导入
				</button>
          	</form>
          	<!-- 列表 -->
			<div class="row searchTb"></div>
			<!-- 分页 -->
			<div id="Pagination"></div>
        </div>
        <%@include file="../commons/editDialog.jsp" %>
        <%@include file="../commons/deleteDialog.jsp" %>
	</body>
	<script type="text/javascript" src="/assets/js/skuInfoMag.js"/>
</html>