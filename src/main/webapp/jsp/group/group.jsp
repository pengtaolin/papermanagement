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
	                        <span class="title">小组管理</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-header">
	                                    <div class="card-title">
	                                    	<div class="btn-toolbar list-toolbar">
												<a class="btn btn-primary" href="<c:url value="/group/add.html"/>"><i class="fa fa-plus"></i> 添加小组</a>
											</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                    <table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>小组名称</th>
	                                                <th>更新时间</th>
	                                                <th></th>
	                                                <th></th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${groupList.list }" var="group" varStatus="i">
	                                        		<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td>${group.groupname }</td>
		                                                <td>
		                                                	<fmt:formatDate value="${group.updatetime }" pattern="yyyy-MM-dd"/>
	                                                	</td>
		                                                <td>
															<a href="<c:url value="/group/toUp/${group.groupid }.html"/>"><i class="fa fa-pencil"></i></a>
														</td>
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
																			<h3 id="myModalLabel">删除小组</h3>
																		</div>
																		<div class="modal-body">
																			<p class="error-text"><i class="fa fa-warning modal-icon"></i>你确定要删除这个小组吗?</p>
																		</div>
																		<div class="modal-footer">
																			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
																			<a class="btn btn-danger" href="<c:url value="/group/del/${group.groupid }.html"/>">删除</a>
																		</div>
																	</div>
																</div>
															</div>
														</td>
		                                            </tr>
	                                        	</c:forEach>
	                                        </tbody>
	                                    </table>
	                                    
	                                    <!-- 分页 -->
	                                    <ul class="pagination">
						  					<li>
												<a href="<c:url value="/group/index${groupList.firstPage}.html"/>">&lt;&lt;</a>
											</li>
										  	<c:if test="${groupList.hasPreviousPage eq true}">
										  		<li>
											  		<a href="<c:url value="/group/index${groupList.prePage}.html"/>">&lt;</a>
												</li>	
										  	</c:if>
											<li>
						  						<a>第${groupList.pageNum}页/共${groupList.pages}页</a>
						  					</li>
											<c:if test="${groupList.hasNextPage eq true}">
										  		<li>
											  		<a href="<c:url value="/group/index${groupList.nextPage}.html"/>">&gt;</a>
												</li>	
										  	</c:if>
											<li>
										  		<a href="<c:url value="/group/index${groupList.lastPage}.html"/>">&gt;&gt;</a>
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
