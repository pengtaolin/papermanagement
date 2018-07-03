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
	                        <span class="title">${stuname }学生</span>
	                    </div>
						<div class="row">
							 <div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/paper/score/save.html"/>" method="post">
											<input name="selectid" type="hidden" value="${selectid }">
											<div class="form-group">
												<label>基本成绩（0-99）</label> 
												<input name="firstScore" value="${first }" class="form-control" required type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength = 2>
											</div>
											
											<div class="form-group">
												<label>答辩成绩（0-99）</label>
												<input name="secondScore"  value="${second }" class="form-control" required type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength = 2>
											</div>
											
											<div class="btn-toolbar list-toolbar">
												<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
												<a href="<c:url value="/paper/teach/index.html"/>" class="btn btn-primary pull-right"><i class="fa fa-mail-reply"></i> 返回</a>
											</div>
										</form>
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