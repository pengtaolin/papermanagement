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
	                        <span class="title">角色管理</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-header">
	                                    <div class="card-title">
	                                    	<div class="btn-toolbar list-toolbar">
												<a class="btn btn-primary" href="<c:url value="/role/add.html"/>"><i class="fa fa-plus"></i> 添加角色</a>
											</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                    <table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>角色名称</th>
	                                                <th>状态</th>
	                                                <th></th>
	                                                <th></th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${roleList.list }" var="role" varStatus="r">
	                                        		<tr>
		                                                <th scope="row">${r.index+1 }</th>
		                                                <td>${role.rolename }</td>
		                                                <td>
															<c:if test="${role.rolestate eq 0}">正常</c:if>
															<c:if test="${role.rolestate eq 1}">删除</c:if>
		                                                </td>
		                                                <td>
															<a href="<c:url value="/role/toUp/${role.roleid }.html"/>"><i class="fa fa-pencil"></i></a>
														</td>
														<c:if test="${role.rolestate ne 1 }">
															<td>
																<a href="#myModal${r.index }" role="button" data-toggle="modal">
																	<i class="fa fa-trash-o"></i>
																</a>
																<!-- 删除提示信息 -->
																<div class="modal small fade" id="myModal${r.index }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
																	<div class="modal-dialog">
																		<div class="modal-content">
																			<div class="modal-header">
																				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																				<h3 id="myModalLabel">删除角色</h3>
																			</div>
																			<div class="modal-body">
																				<p class="error-text"><i class="fa fa-warning modal-icon"></i>你确定要删除这个角色吗?</p>
																			</div>
																			<div class="modal-footer">
																				<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
																				<a class="btn btn-danger" href="<c:url value="/role/delete/${role.roleid }.html"/>">删除</a>
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
												<a href="<c:url value="/role/index${roleList.firstPage}.html"/>">&lt;&lt;</a>
											</li>
										  	<c:if test="${roleList.hasPreviousPage eq true}">
										  		<li>
											  		<a href="<c:url value="/role/index${roleList.prePage}.html"/>">&lt;</a>
												</li>	
										  	</c:if>
											<li>
						  						<a>第${roleList.pageNum}页/共${roleList.pages}页</a>
						  					</li>
											<c:if test="${roleList.hasNextPage eq true}">
										  		<li>
											  		<a href="<c:url value="/role/index${roleList.nextPage}.html"/>">&gt;</a>
												</li>	
										  	</c:if>
											<li>
										  		<a href="<c:url value="/role/index${roleList.lastPage}.html"/>">&gt;&gt;</a>
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
