<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 角色管理 -->
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
	                    	<span class="title">角色添加</span>
	                	</div>
	                	<div class="row">
						 	<div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/role/save.html"/>" method="post">
											<div class="form-group">
												<label>角色名称</label> <label style="color: red">${nameError }</label>
												<input name="rolename" maxlength="10" type="text" value="${role.rolename }" class="form-control" required>
											</div>
											<div class="form-group">
												<label>角色状态</label>
												<select name="rolestate" class="form-control">
													<option value="0" <c:if test="${role.rolestate eq 0}">selected</c:if>>正常</option>
													<option value="1" <c:if test="${role.rolestate eq 1}">selected</c:if>>删除</option>
												</select>
											</div>
											
											<div class="form-group">
												<label>已选权限</label>
												<input disabled type="text" value="${perms }" class="form-control">
											</div>
											
											<div class="form-group">
												<label>重新选择权限</label>
												<select name="permissions" class="form-control" multiple="multiple">
													<c:forEach items="${permissionList }" var="perm">
														<option value="${perm.permissionid}" <c:if test="${prems eq perm.permissionid}">selected</c:if>>${perm.permissionname}</option>
													</c:forEach>
												</select>
											</div>
											
											<div class="btn-toolbar list-toolbar">
												<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
												<a href="<c:url value="/role/index.html"/>" class="btn btn-primary pull-right"><i class="fa fa-mail-reply"></i> 返回</a>
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
