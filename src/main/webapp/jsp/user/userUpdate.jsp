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
	                    	<span class="title">用户修改</span>
	                	</div>
	                	<div class="row">
						 	<div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/user/update.html"/>" method="post">
											<input name="userid" value="${userinfo.userid }" type="hidden">
											<div class="form-group">
												<label>已选角色</label>
												<input type="text" readonly value="${userinfo.roles }" class="form-control">
											</div>
											<div class="form-group">
												<label>重新选择角色</label>
												<select name="roles" class="form-control" multiple="multiple">
													<c:forEach items="${roleList }" var="role" varStatus="r">
														<option value="${role.roleid}">${role.rolename}</option>
													</c:forEach>
												</select>
											</div>
											<div class="form-group">
												<label>学号/职工号</label>
												<input name="userno" readonly type="text" value="${userinfo.userno }" class="form-control" required>
											</div>
											<div class="form-group">
												<label>姓名</label>
												<input name="name" type="text" value="${userinfo.name }" class="form-control" required>
											</div>
											<div class="form-group">
												<label>性别</label>
												<select name="sex" class="form-control">
													<option value="男" <c:if test="${userinfo.sex eq '男'}">selected</c:if>>男</option>
													<option value="女" <c:if test="${userinfo.sex eq '女'}">selected</c:if>>女</option>
												</select>
											</div>
											<div class="form-group">
												<label>教学系</label>
												<input name="series" type="text" value="${userinfo.series }" class="form-control">
											</div>
											<div class="form-group">
												<label>专业</label>
												<input name="major" type="text" value="${userinfo.major }" class="form-control">
											</div>
											<div class="form-group">
												<label>班级</label>
												<input name="clazz" type="text" value="${userinfo.clazz }" class="form-control">
											</div>
											<div class="form-group">
												<label>入学年份 (例:2014)</label>
												<input name="year" maxlength="4" type="text" value="${userinfo.year }" class="form-control">
											</div>
											<div class="form-group">
												<label>届数 (例:2018)</label>
												<input name="session" maxlength="4" type="text" value="${userinfo.session }" class="form-control">
											</div>
											<div class="form-group">
												<label>手机号</label>
												<input name="tel" maxlength="11" type="tel" value="${userinfo.tel }" class="form-control">
											</div>
											<div class="form-group">
												<label>QQ</label>
												<input name="qq" type="text" value="${userinfo.qq }" class="form-control">
											</div>
											<div class="form-group">
												<label>邮箱</label>
												<input name="email" type="email" value="${userinfo.email }" class="form-control">
											</div>
											<div class="form-group">
												<label>身份证号</label>
												<input name="cardid" maxlength="18" type="text" value="${userinfo.cardid }" class="form-control">
											</div>
											<div class="form-group">
												<label>部门</label>
												<input name="department" type="text" value="${userinfo.department }" class="form-control">
											</div>
											<div class="form-group">
												<label>学位</label>
												<input name="dedgree" type="text" value="${userinfo.dedgree }" class="form-control">
											</div>
											<div class="form-group">
												<label>职称</label>
												<input name="title" type="text" value="${userinfo.title }" class="form-control">
											</div>
											<div class="form-group">
												<label>状态</label>
												<select name="userstate" class="form-control">
													<option value="0" <c:if test="${userinfo.userstate eq 0 }">selected</c:if>>正常</option>
													<option value="1" <c:if test="${userinfo.userstate eq 1 }">selected</c:if>>删除</option>
												</select>
											</div>
											
											<div class="btn-toolbar list-toolbar">
												<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 修改</button>
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
