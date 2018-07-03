<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 权限管理 -->
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
	                    	<span class="title">权限修改</span>
	                	</div>
	                	<div class="row">
						 	<div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/perm/update.html"/>" method="post">
		                                	<input type="hidden" name="permissionid" value="${permission.permissionid}" />
		                                	<input type="hidden" name="permissionname" value="${permission.permissionname}" />
		                                	<input type="hidden" name="createtime" value="${permission.createtime}" />
											<div class="form-group">
												<label>权限名称</label>
												<input name="permissionname" disabled="disabled" type="text" value="${permission.permissionname }" class="form-control" required>
											</div>
											
											<div class="form-group">
												<label>权限状态</label>
												<select name="permissionstate" class="form-control">
													<option value="0" <c:if test="${permission.permissionstate eq 0}">selected</c:if>>正常</option>
													<option value="1" <c:if test="${permission.permissionstate eq 1}">selected</c:if>>删除</option>
												</select>
											</div>    
											
											<div class="btn-toolbar list-toolbar">
												<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 修改</button>
												<a href="<c:url value="/perm/index.html"/>" class="btn btn-primary pull-right"><i class="fa fa-mail-reply"></i> 返回</a>
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
