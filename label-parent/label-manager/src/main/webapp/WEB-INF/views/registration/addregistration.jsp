<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../commons/taglib.jsp" %>
<form id="registrationAddForm" class="form-horizontal" action="">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
		&times;
	</button>
	<c:if test="${empty registrationInfo }">
		<c:set var="optType" value="save"/>
		<h4 class="modal-title">
			新增
		</h4>
	</c:if>
	<c:if test="${!empty registrationInfo }">
		<input type="hidden" name="id" value="${registrationInfo.id }"/>
		<c:set var="optType" value="modify"/>
		<h4 class="modal-title">
			修改
		</h4>
	</c:if>
</div>
<div class="modal-body"> 
<div class="form-group">
	<label for="lastname" class="col-sm-4 control-label">注册证编号：</label>
	<div class="col-sm-7">
		<input type="text" class="form-control" id="registrationNo"  name="registrationNo" value="${registrationInfo.registrationNo }"
							   placeholder="请输入用户名" required="required">
	</div>
</div>
<div class="form-group">
	<label for="startTime" class="col-sm-4 control-label">起始有效期：</label>
	<div class="col-sm-7">
		<input type="text" class="form-control dateclass" id="effectiveDate"  name="effectiveDate" 
		value="<fmt:formatDate value="${registrationInfo.effectiveDate }" pattern="yyyy-MM-dd"/>" placeholder="请输起始有效期" required="required">
	</div>
</div>
<div class="form-group">
	<label for="endTime" class="col-sm-4 control-label">终止有效期：</label>
	<div class="col-sm-7">
		<input type="text" class="form-control dateclass" id="expiryDate"  name="expiryDate" 
		value="<fmt:formatDate value="${registrationInfo.expiryDate }" pattern="yyyy-MM-dd"/>" placeholder="请输终止有效期" required="required">
	</div>
</div>
</div>
</form>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">
		取消
	</button>
	<c:if test="${empty registrationInfo }">
		<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="submit('/registrationinfo/save','registrationAddForm');">
		提交
	</button>
	</c:if>
	<c:if test="${!empty registrationInfo }">
		<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="submit('/registrationinfo/modify','registrationAddForm');">
		提交
	</button>
	</c:if>
</div>
<script type="text/javascript" src="/assets/js/common/common.js"/>

