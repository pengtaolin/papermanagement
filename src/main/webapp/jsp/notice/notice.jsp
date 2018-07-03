<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<!-- 公告管理 -->
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
	                        <span class="title">公告管理</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-header">
	                                    <div class="card-title">
	                                    	<div class="btn-toolbar list-toolbar">
												<a class="btn btn-primary" href="<c:url value="/notice/add.html"/>"><i class="fa fa-plus"></i> 添加公告</a>
											</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                    <table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>栏目</th>
	                                                <th>标题</th>
	                                                <th>浏览量</th>
	                                                <th>上传时间</th>
	                                                <th>状态</th>
	                                                <th></th>
	                                                <th></th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                           <tbody>
	                                        	<c:forEach items="${noticeList.list }" var="notice" varStatus="i">
	                                        		<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td>${notice.columnid }</td>
		                                                <td>${notice.noticetitle }</td>
		                                                <td>${notice.watchnum }</td>
		                                                <td><fmt:formatDate value="${notice.updatetime }" pattern="yyyy-MM-dd"/></td>
		                                                <td>
		                                                	<c:if test="${notice.noticestate eq 0}">正常</c:if>
		                                                	<c:if test="${notice.noticestate eq 1}">删除</c:if>
	                                                	</td>
		                                                <td>
															<a href="<c:url value="/notice/toUp/${notice.noticeid }.html"/>"><i class="fa fa-pencil"></i></a>
														</td>
														<c:if test="${notice.noticestate ne 1 }">
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
																				<p class="error-text"><i class="fa fa-warning modal-icon"></i>你确定要删除这篇公告吗?</p>
																			</div>
																			<div class="modal-footer">
																				<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
																				<a class="btn btn-danger" href="<c:url value="/notice/del/${notice.noticeid }.html"/>">删除</a>
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
												<a href="<c:url value="/notice/index${noticeList.firstPage}.html"/>">&lt;&lt;</a>
											</li>
										  	<c:if test="${noticeList.hasPreviousPage eq true}">
										  		<li>
											  		<a href="<c:url value="/notice/index${noticeList.prePage}.html"/>">&lt;</a>
												</li>	
										  	</c:if>
											<li>
						  						<a>第${noticeList.pageNum}页/共${noticeList.pages}页</a>
						  					</li>
											<c:if test="${noticeList.hasNextPage eq true}">
										  		<li>
											  		<a href="<c:url value="/notice/index${noticeList.nextPage}.html"/>">&gt;</a>
												</li>	
										  	</c:if>
											<li>
										  		<a href="<c:url value="/notice/index${noticeList.lastPage}.html"/>">&gt;&gt;</a>
											</li>
										</ul>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    
	                   <!-- 预览查看界面 -->
	                   <!--  <button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalCardProfileExample"><i class="fa fa-code"></i></button>
	                    <div class="modal fade" id="modalCardProfileExample" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                        <div class="modal-dialog modal-lg">
	                            <div class="modal-content">
	                                <div class="modal-header">
	                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                                    <h4 class="modal-title" id="myModalLabel">论文内容</h4>
	                                </div>
	                                <div class="modal-body no-padding">
	                                    <div id="code-preview-card-profile" class="code-preview">
	                                    	欢迎使用论文
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div> -->
	                </div>
	            </div>
	        </div>
	        <!-- 底部 -->
			<jsp:include page="/jsp/common/footer.jsp"/>
	    </div>
	</body>
</html>

