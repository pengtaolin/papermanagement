<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 文档管理 -->
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
	                        <span class="title">论文汇总</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-body">
	                                    <table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>名称</th>
	                                                <th>操作</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${paperList.list }" var="paper" varStatus="p">
		                                            <tr>
		                                                <th scope="row">${p.index+1 }</th>
		                                                <td>${paper.papername }</td>
		                                                
		                                               	<td>
															<c:if test="${not empty paper.fileurl }">
		                                                		<a href="/paper/download/${paper.paperid }.html">下载</a>
		                                                	</c:if>
		                                                	<c:if test="${empty paper.fileurl }">
		                                                		未上传
		                                                	</c:if>
	                                                	</td>
		                                            </tr>
	                                            </c:forEach>
	                                        </tbody>
	                                    </table>
	                                    <!-- 分页 -->
	                                    <ul class="pagination">
						  					<li>
												<a href="<c:url value="/paper/leader/index${paperList.firstPage}.html"/>">&lt;&lt;</a>
											</li>
										  	<c:if test="${paperList.hasPreviousPage eq true}">
										  		<li>
											  		<a href="<c:url value="/paper/leader/index${paperList.prePage}.html"/>">&lt;</a>
												</li>	
										  	</c:if>
											<li>
						  						<a>第${paperList.pageNum}页/共${paperList.pages}页</a>
						  					</li>
											<c:if test="${paperList.hasNextPage eq true}">
										  		<li>
											  		<a href="<c:url value="/paper/leader/index${paperList.nextPage}.html"/>">&gt;</a>
												</li>	
										  	</c:if>
											<li>
										  		<a href="<c:url value="/paper/leader/index${paperList.lastPage}.html"/>">&gt;&gt;</a>
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
