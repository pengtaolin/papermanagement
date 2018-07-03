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
	                        <span class="title">选题审核</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-body">
	                                    <table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>题目</th>
	                                                <th>学生</th>
	                                                <th>审核</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${selectList.list }" var="select" varStatus="i">
	                                        		<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td>${select.subjectid }</td>
		                                                <td>${select.stuid }</td>
		                                                <td>
															<c:if test="${select.selectstate eq 0}">
																<a href="/select/teach/state/${select.selectid}/1.html">通过</a>
																&nbsp;
																<a href="/select/teach/state/${select.selectid}/2.html">不通过</a>
															</c:if>
															<c:if test="${select.selectstate eq 1}">已通过</c:if>
															<c:if test="${select.selectstate eq 2}">
																<a href="/select/teach/restart/${select.selectid}.html">重选</a>
															</c:if>
															<c:if test="${select.selectstate eq 3}">写作中</c:if>
														</td>
		                                            </tr>
	                                        	</c:forEach>
	                                        </tbody>
	                                    </table>
	                                    
                                     	<!-- 分页 -->
	                                    <ul class="pagination">
						  					<li>
												<a href="<c:url value="/select/teach/index${selectList.firstPage}.html"/>">&lt;&lt;</a>
											</li>
										  	<c:if test="${selectList.hasPreviousPage eq true}">
										  		<li>
											  		<a href="<c:url value="/select/teach/index${selectList.prePage}.html"/>">&lt;</a>
												</li>	
										  	</c:if>
											<li>
						  						<a>第${selectList.pageNum}页/共${selectList.pages}页</a>
						  					</li>
											<c:if test="${selectList.hasNextPage eq true}">
										  		<li>
											  		<a href="<c:url value="/select/teach/index${selectList.nextPage}.html"/>">&gt;</a>
												</li>	
										  	</c:if>
											<li>
										  		<a href="<c:url value="/select/teach/index${selectList.lastPage}.html"/>">&gt;&gt;</a>
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
