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
			<th>id </th>
			<th>产品编号</th>
			<th>产品名称</th>
			<th>规格型号</th>
			<th>生产商信息</th>
			<th>代理人信息</th>
			<th>生产日期</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pages.content}"  var="skuinfo" varStatus="s" >
			<tr>
				<td>${s.index+1+ currentPage*pageSize}</td>
				<td>${skuinfo.id }</td>
				<td>${skuinfo.skuNo }</td>
				<td>${skuinfo.proName }</td>
				<td>${skuinfo.specifications }</td>
				<td>${skuinfo.manufacturer }</td>
				<td>${skuinfo.agent }</td>
				<td><fmt:formatDate value="${skuinfo.productDate }" pattern="yyyy-MM-dd"/></td>
				<td>
					<button class="btn opeBtn del" data-toggle="modal" data-target="#confirmDialog" onclick="del('/skuinfo/delete?id=${skuinfo.id}&currentPage=${currentPage}')"><font style="color: white;">删除</font></button>
					<button class="btn btn-primary opeBtn chg" data-toggle="modal" data-target="#editDialog" onclick="edit('/registrationinfo/addregistration?id=${registration.id}')">修改</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
