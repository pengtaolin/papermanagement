<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 选题管理 -->
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
	                        <span class="title">添加选题</span>
	                    </div>
						<div class="row">
							 <div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/select/teach/save.html"/>" method="post">
											<div class="form-group">
												<label>任务名称</label>
												<select name="taskid" class="form-control">
													<c:forEach items="${taskList }" var="task" varStatus="r">
														<option value="${task.taskid}">${task.taskname}</option>
													</c:forEach>
												</select>
											</div>
											
											<div class="form-group">
												<label>课题名称</label>
												<input type="hidden" name="subjectid" value="${subject.subjectid }">
												<input type="text" readonly="readonly" value="${subject.subjectname }" class="form-control">
											</div>
											
											<div class="form-group">
												<label>最多选择人数</label>
												<select name="maxselect" class="form-control">
													<c:forEach items="${'1,1,1,1,1,1,1,1,1,1'}" varStatus="first">
														<option value="${first.index+1 }">${first.index+1 }</option>
													</c:forEach>
												</select>
											</div>
											
											<div class="btn-toolbar list-toolbar">
												<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
												<a href="<c:url value="/subject/teach/index.html"/>" class="btn btn-primary pull-right"><i class="fa fa-mail-reply"></i> 返回</a>
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
