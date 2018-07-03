<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 成绩管理 -->
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
	                        <span class="title">论文成绩</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-body">
		                                <c:if test="${empty select}">
											暂无成绩
										</c:if>
								
                                        <c:if test="${not empty select}">
		                                    <table class="table table-hover">
		                                        <thead>
		                                            <tr>
		                                                <th>序号</th>
		                                                <th>题目</th>
		                                                <th>进度</th>
		                                                <th>成绩</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
													<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td>${select.subjectid }</td>
		                                                 <td>${select.progressid }</td>
		                                                <td>
															<c:if test="${empty select.score}">
																评价中
															</c:if>
															<c:if test="${not empty select.score}">
																指导：${first}
																答辩：${second}
																总分：<fmt:formatNumber type="number" value="${sumscore}" pattern="#.00"/>
															</c:if>
														</td>
		                                            </tr>
	                                        	</tbody>
	                                    	</table>
	                                    </c:if>
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
