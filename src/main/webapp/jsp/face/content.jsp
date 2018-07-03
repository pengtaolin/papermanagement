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
							<li><a href="<c:url value="/column/show/${column.columnid }-1.html"/>">${column.columnname }</a></li>
							<li><a>${notice.noticetitle }</a></li>
							<li class="active">正文</li>
						</ol>
						<div class="panel panel-primary">
							<div class="panel-heading">正文</div>
							<div class="panel-body">
								<div class="text-center">
									<h2>
										<strong>${notice.noticetitle }</strong>
									</h2>
									<h6>
										<strong>日期：<fmt:formatDate value="${notice.updatetime }" pattern="yyyy-MM-dd"/>&emsp;&emsp;来源：本站原创&emsp;&emsp;浏览数：${notice.watchnum }次</strong>
									</h6>
								</div>
	
								<div class="main-content">
									${notice.noticecontent }
								</div>
							</div>
	
							<div class="panel-footer">
								<a href="<c:url value="/notice/download/${notice.noticeid }.html"/>" class="text-right btn btn-primary" type="button">
									下载 <span class="badge">${notice.downloads }</span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<jsp:include page="/jsp/face/footer.jsp"/>
	</body>

</html>
