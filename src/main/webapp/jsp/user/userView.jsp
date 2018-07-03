<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 用户管理 -->
<html>
	<body class="flat-blue">
	    <div class="app-container">
	        <div class="row content-container">
	            <!--导航条-->
				<jsp:include page="/jsp/common/navber.jsp"/>

				<!--侧拉菜单与版权声明-->
				<jsp:include page="/jsp/common/side-menu.jsp"/>
				
				<!-- 主界面内容 -->
	            <div class="container-fluid">
	                <div class="side-body">
						<div class="page-title">
	                    	<span class="title">查看用户</span>
	                	</div>
	                	<div class="row">
						 	<div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/user/toUp.html"/>" method="post">
											<input name="userid" value="${userinfo.userid }" type="hidden">
											<div class="form-group">
												<label>角色</label>
												<input name="roles" readonly type="text" value="${userinfo.roles }" class="form-control">
											</div>
											<div class="form-group">
												<label>学号/职工号</label>
												<input name="userno" readonly type="text" value="${userinfo.userno }" class="form-control">
											</div>
											<div class="form-group">
												<label>姓名</label>
												<input name="name" readonly type="text" value="${userinfo.name }" class="form-control">
											</div>
											<div class="form-group">
												<label>性别</label>
												<select disabled class="form-control">
													<option value="男" <c:if test="${userinfo.sex eq '男'}">selected</c:if>>男</option>
													<option value="女" <c:if test="${userinfo.sex eq '女'}">selected</c:if>>女</option>
												</select>
												<input name="sex" value="${userinfo.sex }" type="hidden"/>
											</div>
											<div class="form-group">
												<label>教学系</label>
												<input name="series" readonly type="text" value="${userinfo.series }" class="form-control">
											</div>
											<div class="form-group">
												<label>专业</label>
												<input name="major" readonly type="text" value="${userinfo.major }" class="form-control">
											</div>
											<div class="form-group">
												<label>班级</label>
												<input name="clazz" readonly type="text" value="${userinfo.clazz }" class="form-control">
											</div>
											<div class="form-group">
												<label>入学年份</label>
												<input name="year" readonly type="text" value="${userinfo.year }" class="form-control">
											</div>
											<div class="form-group">
												<label>届数 </label>
												<input name="session" readonly type="text" value="${userinfo.session }" class="form-control">
											</div>
											<div class="form-group">
												<label>手机号</label>
												<input name="tel" readonly type="tel" value="${userinfo.tel }" class="form-control">
											</div>
											<div class="form-group">
												<label>QQ</label>
												<input name="qq" readonly type="text" value="${userinfo.qq }" class="form-control">
											</div>
											<div class="form-group">
												<label>邮箱</label>
												<input name="email" readonly type="email" value="${userinfo.email }" class="form-control">
											</div>
											<div class="form-group">
												<label>身份证号</label>
												<input name="cardid" readonly type="text" value="${userinfo.cardid }" class="form-control">
											</div>
											<div class="form-group">
												<label>部门</label>
												<input name="department" readonly type="text" value="${userinfo.department }" class="form-control">
											</div>
											<div class="form-group">
												<label>学位</label>
												<input name="dedgree" readonly type="text" value="${userinfo.dedgree }" class="form-control">
											</div>
											<div class="form-group">
												<label>职称</label>
												<input name="title" readonly type="text" value="${userinfo.title }" class="form-control">
											</div>
											<div class="form-group">
												<label>状态</label>
												<select disabled class="form-control">
													<option value="0" <c:if test="${userinfo.userstate eq 0 }">selected</c:if>>正常</option>
													<option value="1" <c:if test="${userinfo.userstate eq 1 }">selected</c:if>>删除</option>
												</select>
												<input name="userstate" value="${userinfo.userstate }" type="hidden"/>
											</div>
											
											<div class="btn-toolbar list-toolbar">
												<!-- 修改 -->
												<button  type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 修改信息</button>
												
												<!-- 重置密码 -->
												<a href="#myPwd" class="btn btn-primary"  data-toggle="modal"><i class="fa fa-history"></i> 重置密码</a>
												<!-- 提示信息 -->
												<div class="modal small fade" id="myPwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																<h3 id="myModalLabel">重置用户密码</h3>
															</div>
															<div class="modal-body">
																<p class="error-text"><i class="fa fa-warning modal-icon"></i>你确定要重置这个用户的密码吗?</p>
															</div>
															<div class="modal-footer">
																<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
																<a class="btn btn-danger" href="<c:url value="/user/pwd/${userinfo.userid}.html"/>">确定</a>
															</div>
														</div>
													</div>
												</div>
												
												<!-- 彻底删除信息 -->
												<a href="#myModal" class="btn btn-primary"  data-toggle="modal"><i class="fa fa-trash"></i> 彻底删除</a>
												<!-- 删除提示信息 -->
												<div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																<h3 id="myModalLabel">删除用户信息</h3>
															</div>
															<div class="modal-body">
																<p class="error-text"><i class="fa fa-warning modal-icon"></i>你确定要彻底删除这个用户吗?</p>
															</div>
															<div class="modal-footer">
																<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
																<a class="btn btn-danger" href="<c:url value="/user/delete/${userinfo.userid}.html"/>">删除</a>
															</div>
														</div>
													</div>
												</div>
												
												<!-- 返回 -->
												<a href="<c:url value="/user/index.html"/>" class="btn btn-primary pull-right"><i class="fa fa-mail-reply"></i> 返回</a>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
	                </div>
	            </div>
	        </div>
	        <!-- 底部 -->
			<jsp:include page="/jsp/common/footer.jsp"/>
		</div>
	</body>

</html>
