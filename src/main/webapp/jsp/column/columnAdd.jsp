<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 栏目管理 -->
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
	                        <span class="title">栏目添加</span>
	                    </div>
						<div class="row">
							 <div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/column/save.html"/>" method="post">
											<div class="form-group">
												<label>上级栏目</label>
												<select name="parentcolumn" class="form-control">
													<option value="0" <c:if test="${col.parentcolumn=='0' }">selected</c:if>>前台主页</option>
													<option value="1" <c:if test="${col.parentcolumn=='1' }">selected</c:if>>后台主页</option>
													<!-- 加载其他别 -->
													<c:forEach items="${firstColumn }" var="first">
														<option value="${first.columnid }" <c:if test="${col.parentcolumn == first.columnid}">selected</c:if>>${first.columnname }</option>
													</c:forEach>
												</select>
											</div>
											
											<div class="form-group">
												<label>栏目名称</label> <label style="color: red">${nameError }</label>
												<input name="columnname" maxlength="8" type="text" value="${col.columnname }" class="form-control" required>
											</div>
											
											<div class="form-group">
												<label>优先级</label>
												<select name="orderby" class="form-control">
													<c:forEach items="${'1,1,1,1,1,1,1,1,1,1'}" varStatus="first">
														<option value="${first.index+1 }" <c:if test="${col.orderby eq first.index+1}">selected</c:if>>${first.index+1 }</option>
													</c:forEach>
												</select>
											</div>
											
											<div class="form-group">
												<label>页面类型</label>
												<select name="type" class="form-control">
													<option value="0" <c:if test="${col.type eq 0}">selected</c:if>>其他</option>
													<option value="1" <c:if test="${col.type eq 1}">selected</c:if>>列表</option>
												</select>
											</div>
											
											<div class="form-group">
												<label>URL</label>
												<input name="url" type="text" value="${col.url }" class="form-control">
											</div>
											
											<div class="form-group">
												<label>栏目状态</label>
												<select name="columnstate" class="form-control">
													<option value="0" <c:if test="${col.columnstate eq 0}">selected</c:if>>正常</option>
													<option value="2" <c:if test="${col.columnstate eq 2}">selected</c:if>>公告</option>
													<option value="1" <c:if test="${col.columnstate eq 1}">selected</c:if>>删除</option>
												</select>
											</div>
									
											<div class="btn-toolbar list-toolbar">
												<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
												<a href="<c:url value="/column/index.html"/>" class="btn btn-primary pull-right"><i class="fa fa-mail-reply"></i> 返回</a>
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