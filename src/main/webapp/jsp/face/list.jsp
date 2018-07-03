<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp"%>
<!DOCTYPE html>
<!-- 前端主页界面 -->
<html>
	<body class="flat-blue landing-page">
		<!-- 导航栏 -->
		<jsp:include page="/jsp/face/header.jsp" />
	
		<!--中间框架-->
		<div class="container-fluid app-content-a">
			<div class="container">
				<!--文章内容-->
				<div class="row">
					<div class="col-md-12">
						<!--路径导航条-->
						<ol class="breadcrumb">
							<li><a href='<c:url value="/index.html"/>'>首页</a></li>
							<li><a>${column.columnname }</a></li>
							<li class="active">正文</li>
						</ol>
						<div class="panel panel-primary">
							<div class="panel-heading">
								列表
							</div>	
				  			<div class="panel-body">
				  				<div class="list-group">
				  					<c:forEach items="${noticeList.list }" var="ns" varStatus="vs">
								   		<a title="${ns.noticetitle }" href='<c:url value='/notice/show/${ns.columnid }/${ns.noticeid }.html'/>' class="list-group-item <c:if test="${vs.index%2 eq 0}">list-group-item-success</c:if> <c:if test="${vs.index%2 eq 1}">list-group-item-warning</c:if>">
		  									<span class="badge"><fmt:formatDate value="${ns.updatetime }" pattern="yyyy-MM-dd"/></span>
			  								${ns.noticetitle }
			  							</a>
								   	</c:forEach>
								</div>
							</div>
							<div class="panel-footer">
								<!--分页下标-->
				  				<ul class="pager pagination text-center">
				  					<li>
										<a href="<c:url value="/column/show/${column.columnid}-${noticeList.firstPage}.html"/>">&lt;&lt;</a>
									</li>
								  	<c:if test="${noticeList.hasPreviousPage eq true}">
								  		<li>
									  		<a href="<c:url value="/column/show/${column.columnid}-${noticeList.prePage}.html"/>">&lt;</a>
										</li>	
								  	</c:if>
									<li>
				  						<a>第${noticeList.pageNum}页/共${noticeList.pages}页</a>
				  					</li>
									<c:if test="${noticeList.hasNextPage eq true}">
								  		<li>
									  		<a href="<c:url value="/column/show/${column.columnid}-${noticeList.nextPage}.html"/>">&gt;</a>
										</li>	
								  	</c:if>
									<li>
								  		<a href="<c:url value="/column/show/${column.columnid}-${noticeList.lastPage}.html"/>">&gt;&gt;</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<jsp:include page="/jsp/face/footer.jsp"/>
	</body>

</html>
