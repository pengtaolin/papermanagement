<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 前端主页界面 -->
<html>
	<body class="flat-blue landing-page">
 		<!-- 导航栏 -->
	   	<jsp:include page="/jsp/face/header.jsp"/>
	    
	    <div class="container-fluid app-content-a">
	        <div class="container">    
	            <div class="row">
					<div class="col-md-12">
						<div class="card">
		                    <div class="card-body no-padding">
		                        <div role="tabpanel">
		                            <!-- Nav tabs -->
		                            <ul class="nav nav-tabs" role="tablist">
		                               	<c:forEach items="${applicationScope.faceNotices }" var="fns" varStatus="v">
		                               		<li role="presentation" <c:if test="${v.index eq 0}">class="active"</c:if>><a href="#tab${v.index }" aria-controls="tab${v.index }" role="tab" data-toggle="tab">${fns.columnname }</a></li>
		                               	</c:forEach>
		                            </ul>
		                            <!-- Tab panes -->
		                            <div class="tab-content">
		                                <c:forEach items="${applicationScope.faceNotices }" var="fns" varStatus="ns">
		                                	<div role="tabpanel" class="tab-pane <c:if test="${ns.index eq 0}">active</c:if>" id="tab${ns.index }">
			                                    <div class="list-group">
												   	<c:forEach items="${fns.notices }" var="ns" varStatus="vs">
												   		<a title="${ns.noticetitle }" href='<c:url value='/notice/show/${fns.columnid }/${ns.noticeid }.html'/>' class="list-group-item <c:if test="${vs.index%2 eq 0}">list-group-item-success</c:if> <c:if test="${vs.index%2 eq 1}">list-group-item-warning</c:if>">
						  									<span class="badge"><fmt:formatDate value="${ns.updatetime }" pattern="yyyy-MM-dd"/></span>
							  								${ns.noticetitle }
							  							</a>
												   	</c:forEach><%-- ${fns.url } --%>
													<c:if test="${fns.url eq ''}">
							                			<a title="更多..." href='<c:url value='/column/show/${fns.columnid }-1.html'/>' class="list-group-item text-center">
															<i class="fa fa-refresh"></i> 更多...
														</a>
							                		</c:if>
												</div>
			                                </div>
		                                </c:forEach>
		                            </div>
		                   		</div>
		             		</div>
		            	</div>
					</div>
				</div>
        	</div>
       	</div>
       	
       	<jsp:include page="/jsp/face/footer.jsp"/>
	    
	</body>
</html>
