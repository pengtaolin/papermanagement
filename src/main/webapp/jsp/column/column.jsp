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
	                        <span class="title">栏目管理</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-header">
	                                    <div class="card-title">
	                                    	<div class="btn-toolbar list-toolbar">
												<a class="btn btn-primary" href="<c:url value="/column/add.html"/>"><i class="fa fa-plus"></i> 添加栏目</a>
											</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                    <table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>上级栏目</th>
	                                                <th>名称</th>
	                                                <th>优先级</th>
	                                                <th>界面类型</th>
	                                                <th>状态</th>
	                                                <th></th>
	                                                <th></th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${columnList.list }" var="column" varStatus="i">
	                                        		<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td>${column.parentcolumn }</td>
		                                                <td>${column.columnname }</td>
		                                                <td>${column.orderby }</td>
		                                                <td>
		                                                	<c:if test="${column.type eq 0}">其他</c:if>
		                                                	<c:if test="${column.type eq 1}">列表</c:if>
														</td>
		                                                <td>
		                                                	<c:if test="${column.columnstate eq 0}">正常</c:if>
		                                                	<c:if test="${column.columnstate eq 2}">公告</c:if>
		                                                	<c:if test="${column.columnstate eq 1}">删除</c:if>
	                                                	</td>
		                                                <td>
															<a href="<c:url value="/column/toUp/${column.columnid }.html"/>"><i class="fa fa-pencil"></i></a>
														</td>
														<c:if test="${column.columnstate ne 1 }">
															<td>
																<a href="#myModal${i.index }" role="button" data-toggle="modal">
																	<i class="fa fa-trash-o"></i>
																</a>
																<!-- 删除提示信息 -->
																<div class="modal small fade" id="myModal${i.index }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
																	<div class="modal-dialog">
																		<div class="modal-content">
																			<div class="modal-header">
																				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																				<h3 id="myModalLabel">删除栏目</h3>
																			</div>
																			<div class="modal-body">
																				<p class="error-text"><i class="fa fa-warning modal-icon"></i>你确定要删除这篇栏目吗?</p>
																			</div>
																			<div class="modal-footer">
																				<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
																				<a class="btn btn-danger" href="<c:url value="/column/del/${column.columnid }.html"/>">删除</a>
																			</div>
																		</div>
																	</div>
																</div>
															</td>
														</c:if>
		                                            </tr>
	                                        	</c:forEach>
	                                        </tbody>
	                                    </table>
	                                    
	                                    <!-- 分页 -->
	                                    <ul class="pagination">
						  					<li>
												<a href="<c:url value="/column/index${columnList.firstPage}.html"/>">&lt;&lt;</a>
											</li>
										  	<c:if test="${columnList.hasPreviousPage eq true}">
										  		<li>
											  		<a href="<c:url value="/column/index${columnList.prePage}.html"/>">&lt;</a>
												</li>	
										  	</c:if>
											<li>
						  						<a>第${columnList.pageNum}页/共${columnList.pages}页</a>
						  					</li>
											<c:if test="${columnList.hasNextPage eq true}">
										  		<li>
											  		<a href="<c:url value="/column/index${columnList.nextPage}.html"/>">&gt;</a>
												</li>	
										  	</c:if>
											<li>
										  		<a href="<c:url value="/column/index${columnList.lastPage}.html"/>">&gt;&gt;</a>
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
