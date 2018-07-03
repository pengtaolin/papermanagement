<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 课题管理 -->
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
	                        <span class="title">课题管理</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                            	<div class="card-header">
	                                    <div class="card-title">
	                                    	<div class="btn-toolbar list-toolbar">
	                                    		<button type="button" class="btn btn-primary" onclick="tableToExcel('contentTable','学生论文课题汇总.xls','课题汇总')"><i class="fa fa-table"></i> 导出表格</button>
											</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                    <table id="contentTable" class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>课题名称 </th>
	                                                <th>课题类型</th>
	                                                <th>指导老师</th>
	                                                <th>创建者</th>
	                                                <th>创建时间</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${subjectList.list }" var="subject" varStatus="i">
	                                        		<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td>
		                                                	<a data-toggle="modal" data-target="#modalCardProfileExample${i.index }">${subject.subjectname }</a>
		                                                	<div class="modal fade" id="modalCardProfileExample${i.index }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										                        <div class="modal-dialog modal-lg">
										                            <div class="modal-content">
										                                <div class="modal-header">
										                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										                                    <h4 class="modal-title" id="myModalLabel">课题简介</h4>
										                                </div>
										                                <div class="modal-body">
																			<div class="form-group">
																				<label class="form-control">${subject.subjectcontent }</label>
																			</div>
										                                </div>
										                            </div>
										                        </div>
										                    </div>
		                                                </td>
		                                                <td>${subject.subjecttype }</td>
		                                                <td>${subject.teachid }</td>
		                                                <td>${subject.createuser }</td>
		                                                <td><fmt:formatDate value="${subject.createtime }" pattern="yyyy-MM-dd"/></td>
		                                            </tr>
	                                        	</c:forEach>
	                                        </tbody>
	                                    </table>
	                                    
	                                    <!-- 分页 -->
	                                    <ul class="pagination">
						  					<li>
												<a href="<c:url value="/subject/index${subjectList.firstPage}.html"/>">&lt;&lt;</a>
											</li>
										  	<c:if test="${subjectList.hasPreviousPage eq true}">
										  		<li>
											  		<a href="<c:url value="/subject/index${subjectList.prePage}.html"/>">&lt;</a>
												</li>	
										  	</c:if>
											<li>
						  						<a>第${subjectList.pageNum}页/共${subjectList.pages}页</a>
						  					</li>
											<c:if test="${subjectList.hasNextPage eq true}">
										  		<li>
											  		<a href="<c:url value="/subject/index${subjectList.nextPage}.html"/>">&gt;</a>
												</li>	
										  	</c:if>
											<li>
										  		<a href="<c:url value="/subject/index${subjectList.lastPage}.html"/>">&gt;&gt;</a>
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
