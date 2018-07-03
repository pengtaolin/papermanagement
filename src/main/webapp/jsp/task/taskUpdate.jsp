<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 任务管理 -->
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
	                        <span class="title">更新任务</span>
	                    </div>
						<div class="row">
							 <div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/task/update.html"/>" method="post">
											<input type="hidden" name="taskid" value="${task.taskid }"/>
											<input type="hidden" name="createtime" value="${task.createtime }"/>
											<div class="form-group">
												<label>任务名称</label> <label style="color: red">${nameError }</label>
												<input name="taskname" maxlength="12" type="text" value="${task.taskname }" class="form-control" required>
											</div>
											
											<div class="form-group">
												<label>已选年份</label>
												<input type="text" value="<fmt:formatDate value="${task.year }" pattern="yyyy-MM-dd"/>" class="form-control" readonly="readonly">
											</div>
											<div class="form-group">
												<label>重新选择年份</label>
												<input name="years" type="date" class="form-control"  required>
											</div>
											<div class="form-group">
												<label>状态</label>
												<select name="taskstate" class="form-control">
													<option value="0" <c:if test="${task.taskstate eq 0}">selected</c:if>>创建</option>
													<option value="1" <c:if test="${task.taskstate eq 1}">selected</c:if>>启动</option>
													<option value="2" <c:if test="${task.taskstate eq 2}">selected</c:if>>结束</option>
												</select>
											</div>
											
											<div class="btn-toolbar list-toolbar">
												<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
												<a href="<c:url value="/task/index.html"/>" class="btn btn-primary pull-right"><i class="fa fa-mail-reply"></i> 返回</a>
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