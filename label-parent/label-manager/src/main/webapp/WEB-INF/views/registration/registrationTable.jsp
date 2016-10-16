<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../commons/taglib.jsp" %>
<input type="hidden" id="totalPage" name="totalPage" value="${pages.totalPages }"/>
<input type="hidden" id="totalElement" name="totalElement" value="${pages.totalElements }"/>
<input type="hidden" id="pageSize" name="pageSize" value="${pageSize}"/>
<input type="hidden" id="currentPage" name="currentPage" value="${currentPage}"/>
<table class="table table-striped">
	<thead>
		<tr>
			<th>序号</th>
			<th>注册ID</th>
			<th>注册证号</th>
			<th>开始有效时间</th>
			<th>结束有效时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pages.content}"  var="registration" varStatus="s" >
			<tr>
				<td>${s.index+1+ currentPage*pageSize}</td>
				<td>${registration.id }</td>
				<td>${registration.registrationNo }</td>
				<td><fmt:formatDate value="${registration.effectiveDate }" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${registration.expiryDate }" pattern="yyyy-MM-dd"/></td>
				<td>
					<button class="btn opeBtn del" data-toggle="modal" data-target="#confirmDialog" onclick="del('/registrationinfo/delete?id=${registration.id}&currentPage=${currentPage}')"><font style="color: white;">删除</font></button>
					<button class="btn btn-primary opeBtn chg" data-toggle="modal" data-target="#editDialog" onclick="edit('/registrationinfo/addregistration?id=${registration.id}')">修改</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
