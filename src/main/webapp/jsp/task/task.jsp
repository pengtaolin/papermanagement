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
	                        <span class="title">任务管理</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-header">
	                                    <div class="card-title">
	                                    	<div class="btn-toolbar list-toolbar">
												<a class="btn btn-primary" href="<c:url value="/task/add.html"/>"><i class="fa fa-plus"></i> 添加任务</a>
											</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                    <table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>年份</th>
	                                                <th>任务名称</th>
	                                                <th>状态</th>
	                                                <th>创建时间</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${taskList.list }" var="task" varStatus="i">
	                                        		<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td><fmt:formatDate value="${task.year }" pattern="yyyy"/></td>
		                                                <td>${task.taskname }</td>
		                                                <td>
		                                                	<c:if test="${task.taskstate eq 0}">已创建</c:if>
		                                                	<c:if test="${task.taskstate eq 1}">运行中</c:if>
		                                                	<c:if test="${task.taskstate eq 2}">已结束</c:if>
	                                                	</td>
	                                                	<td><fmt:formatDate value="${task.createtime }" pattern="yyyy-MM-dd"/></td>
		                                                <td>
															<a href="<c:url value="/task/toUp/${task.taskid }.html"/>"><i class="fa fa-pencil"></i></a>
														</td>
		                                                
		                                                <c:if test="${task.taskstate eq 0}">
		                                                	<td>
																<a href="<c:url value="/task/state/${task.taskid }/1.html"/>">开始</a>
															</td>
		                                                </c:if>
		                                                <c:if test="${task.taskstate ne 2}">
		                                                	<td>
																<a href="<c:url value="/task/state/${task.taskid }/2.html"/>">结束</a>
															</td>
		                                                </c:if>
		                                            </tr>
	                                        	</c:forEach>
	                                        </tbody>
	                                    </table>
	                                    
	                                    <!-- 分页 -->
	                                    <ul class="pagination">
						  					<li>
												<a href="<c:url value="/task/index${taskList.firstPage}.html"/>">&lt;&lt;</a>
											</li>
										  	<c:if test="${taskList.hasPreviousPage eq true}">
										  		<li>
											  		<a href="<c:url value="/task/index${taskList.prePage}.html"/>">&lt;</a>
												</li>	
										  	</c:if>
											<li>
						  						<a>第${taskList.pageNum}页/共${taskList.pages}页</a>
						  					</li>
											<c:if test="${taskList.hasNextPage eq true}">
										  		<li>
											  		<a href="<c:url value="/task/index${taskList.nextPage}.html"/>">&gt;</a>
												</li>	
										  	</c:if>
											<li>
										  		<a href="<c:url value="/task/index${taskList.lastPage}.html"/>">&gt;&gt;</a>
											</li>
										</ul>
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
