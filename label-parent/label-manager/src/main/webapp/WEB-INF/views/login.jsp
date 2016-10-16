<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>标签管理系统登录</title>
		<link rel="stylesheet" href="/assets/css/bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="/assets/css/ace/ace-fonts.css" />
		<link rel="stylesheet" href="/assets/css/reset.css" />
		<link rel="stylesheet" href="/assets/css/login.css" />
		<script type="text/javascript" src="/assets/js/jquery-1.10.2.js" ></script>
		<script type="text/javascript" src="/assets/js/bootstrap/bootstrap.min.js" ></script>
	</head>
	<body>
		<form class="form-horizontal login" role="form" action="/login" method="post">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">用户名：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="loginName" name="loginName"
						   placeholder="请输入用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">密  码：</label>
				<div class="col-sm-3">
					<input type="password" class="form-control" id="passWord" name="passWord" 
						   placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<button type="submit" class="btn btn-default">登录</button>
					<button type="button" class="btn btn-default reg" id="register" data-toggle="modal" data-target="#myRegister">注册</button>
				</div>
			</div>
		</form>
		<!-- 注册模态框（Modal） -->
		<div class="modal" id="myRegister" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							注册
						</h4>
					</div>
					<div class="modal-body">
						在这里添加一些文本
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							取消
						</button>
						<button type="button" class="btn btn-primary">
							提交
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
	</body>
</html>
