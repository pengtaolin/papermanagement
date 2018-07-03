<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!--后台主页-->
<html>
	<!--主体-->
	<body class="flat-blue">
		<div class="app-container">
			<div class="row content-container">
				<!--导航条-->
				<jsp:include page="/jsp/common/navber.jsp"/>

				<!--侧拉菜单与版权声明-->
				<jsp:include page="/jsp/common/side-menu.jsp"/>
				
				<!-- 主界面内容 -->
				<div class="container-fluid">
					<div class="side-body padding-top">
						<%-- <div>
			                 <div class="alert fresh-color alert-success alert-dismissible fade in" role="alert">
			                     <h3 id="oh-snap!-you-got-an-error!">热烈欢迎<a class="anchorjs-link" href="#oh-snap!-you-got-an-error!"><span class="anchorjs-icon"></span></a></h3>
			                     <br>
			                     <p class="pull-right"> 你好，${sessionScope.session_user.username }。欢迎使用论文管理系统！</p>
			                     <br>
			                     <br>
			                     <button type="button" class="btn btn-link" data-dismiss="alert" aria-label="Close"><h4>确定</h4></button>
			                 </div>
			             </div>	 --%>
						<div class="row">
							<div class="col-md-12">
								<div class="card">
				                    <div class="card-body no-padding">
				                    	<img src="<c:url value="/img/background.jpg"/>" class="img-responsive">  
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