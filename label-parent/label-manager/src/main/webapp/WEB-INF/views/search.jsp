<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>标签查询</title>
	</head>
	<body>
        <div class="compileSearch">
          	<form class="form-inline myCondition">
          		<button type="button" class="btn btn-primary addBtn" data-toggle="modal" data-target="#editDialog" onclick="edit('/registrationinfo/addregistration')">
						新增
				</button>
				<button type="button" class="btn btn-primary importBtn" data-toggle="modal" data-target="#importDialog" onclick="importUrl('/registrationinfo/importData')">
						批量导入
				</button>
          	</form>
			<div class="row searchTb">
		          		<table class="table table-striped">
						<thead>
							<tr>
								<th>产品代码(SKU)</th>
								<th>产品名称</th>
								<th>产品规格</th>
								<th>生产厂商</th>
								<th>代理人</th>
								<th>生产日期</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>WoWO-001</td>
								<td>喔喔奶糖</td>
								<td>kg</td>
								<td>喔喔集团</td>
								<td>张三</td>
								<td>2016-10-5</td>
							</tr>
							<tr>
								<td>WoWO-001</td>
								<td>喔喔奶糖</td>
								<td>kg</td>
								<td>喔喔集团</td>
								<td>张三</td>
								<td>2016-10-5</td>
							</tr>
							<tr>
								<td>WoWO-001</td>
								<td>喔喔奶糖</td>
								<td>kg</td>
								<td>喔喔集团</td>
								<td>张三</td>
								<td>2016-10-5</td>
							</tr>
						</tbody>
					</table>
		        </div>
        </div>
	</body>
</html>
