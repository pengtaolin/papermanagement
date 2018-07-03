<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!--登录界面(未用)-->
<html>
	<body class="flat-blue login-page">
		<div class="container">
			<div class="login-box">
				<div>
					<div class="login-form row">
						<div class="col-sm-12 text-center login-header">
							<i class="login-logo fa fa-university fa-5x"></i>
							<h4 class="login-title">欢迎登录论文管理系统</h4>
						</div>
						<div class="col-sm-12">
							<div class="login-body">
								<div class="progress hidden" id="login-progress">
									<div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
										登录中...
									</div>
								</div>
								<form action="/user/login.html" method="post">
									<div class="control">
										<input name="username" type="text" class="form-control" placeholder="学号/职工号" />
									</div>
									<div class="control">
										<input name="password" type="password" class="form-control" placeholder="密码" />
									</div>
									<div class="checkbox3 checkbox-round checkbox-check checkbox-light">
										<input name="rememberMe" type="checkbox" id="checkbox-10">
										<label for="checkbox-10">
                                         	记住密码
                                        </label>
									</div>
									<div class="login-button text-center">
										<!-- <a class="btn btn-primary" type="submit" href="<c:url value='/jsp/index.jsp'/>">登录</a>-->
										<input type="submit" class="btn btn-primary" value="登录"> 
									</div>
								</form>
							</div>
							<div class="login-footer">
								<span class="text-right">
									<a href="#myModal1" class="color-white" data-toggle="modal">忘记密码?</a>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 删除提示信息 -->
		<div class="modal small fade" id="myModal1" tabindex="-11" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel">忘记密码</h3>
					</div>
					<div class="modal-body">
						<h5 class="error-text"><i class="fa fa-warning modal-icon"></i>请及时联系管理员</h5>
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">确定</button>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>