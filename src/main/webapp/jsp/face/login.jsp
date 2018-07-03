<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!--登录界面-->
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
								<form action="/user/login.html" method="post">
									<label style="color: red">${nameError }</label>
									<div class="control">
										<input name="userno" type="text" class="form-control" value="${user.userno }" placeholder="学号/职工号" required/>
									</div>
									<div class="control">
										<input name="pwd" type="password" class="form-control" value="${user.pwd }" placeholder="密码" required/>
									</div>
									<div class="control input-group">
										<input name="vcode" maxlength="4" id="verifyCode" type="text" value="${rcode }" class="form-control" placeholder="验证码" required>
										<span class="input-group-btn">
											<img id="vCode" src="<c:url value='/user/vcode.html'/>" border="2"/>
										  	<a href="javascript:_change()" class="btn btn-default" >换一张</a>
										</span>
								    </div><br />
									<div class="login-button text-center">
										<input type="submit" class="btn btn-primary" value="登录"> 
									</div>
								</form>
							</div>
							<div class="login-footer">
								<span class="pull-left">
									<a href="<c:url value='/index.html'/>" class="color-white" >返回首页</a>
								</span>
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
	<script type="text/javascript">
		function _change() {
			var ele = document.getElementById("vCode");
			ele.src = "<c:url value='/user/vcode.html'/>?xxx=" + new Date().getTime();
		}
	</script>
</html>