<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 小组管理 -->
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
	                        <span class="title">添加小组</span>
	                    </div>
						<div class="row">
							 <div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/group/save.html"/>" method="post">
											<div class="form-group">
												<label>小组名称</label> <label style="color: red">${nameError }</label>
												<input name="groupname" maxlength="12" type="text" value="${group.groupname }" class="form-control" required>
											</div>
											
											<div class="form-group">
												<label>小组成员</label>
												<select name="users" class="form-control" multiple="multiple">
													<c:forEach items="${infos }" var="info">
														<option value="${info.userid }">${info.name }</option>
													</c:forEach>
												</select>
											</div>
											
											<div class="btn-toolbar list-toolbar">
												<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
												<a href="<c:url value="/group/index.html"/>" class="btn btn-primary pull-right"><i class="fa fa-mail-reply"></i> 返回</a>
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