<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 用户基本信息 -->
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
	                    	<span class="title">查看信息</span>
	                	</div>
	                	<div class="row">
						 	<div class="col-xs-12">
						 		<c:if test="${empty userinfo }">
									 <div class="card">
		                                <div class="card-body">
											暂无指导老师
										</div>
									</div>
								</c:if>
						 		
						 		<c:if test="${not empty userinfo }">
									<div class="tab-content">
										<div class="tab-pane active in">
											<div class="form-group">
												<label>学号/职工号</label>
												<input name="userno" readonly type="text" value="${userinfo.userno }" class="form-control">
											</div>
											<div class="form-group">
												<label>姓名</label>
												<input name="name" readonly type="text" value="${userinfo.name }" class="form-control">
											</div>
											<div class="form-group">
												<label>性别</label>
												<select disabled class="form-control">
													<option value="男" <c:if test="${userinfo.sex eq '男'}">selected</c:if>>男</option>
													<option value="女" <c:if test="${userinfo.sex eq '女'}">selected</c:if>>女</option>
												</select>
												<input name="sex" value="${userinfo.sex }" type="hidden"/>
											</div>
											<div class="form-group">
												<label>教学系</label>
												<input name="series" readonly type="text" value="${userinfo.series }" class="form-control">
											</div>
											<div class="form-group">
												<label>专业</label>
												<input name="major" readonly type="text" value="${userinfo.major }" class="form-control">
											</div>
											<div class="form-group">
												<label>班级</label>
												<input name="clazz" readonly type="text" value="${userinfo.clazz }" class="form-control">
											</div>
											<div class="form-group">
												<label>入学年份</label>
												<input name="year" readonly type="text" value="${userinfo.year }" class="form-control">
											</div>
											<div class="form-group">
												<label>届数 </label>
												<input name="session" readonly type="text" value="${userinfo.session }" class="form-control">
											</div>
											<div class="form-group">
												<label>手机号</label>
												<input name="tel" readonly type="tel" value="${userinfo.tel }" class="form-control">
											</div>
											<div class="form-group">
												<label>QQ</label>
												<input name="qq" readonly type="text" value="${userinfo.qq }" class="form-control">
											</div>
											<div class="form-group">
												<label>邮箱</label>
												<input name="email" readonly type="email" value="${userinfo.email }" class="form-control">
											</div>
											<div class="form-group">
												<label>身份证号</label>
												<input name="cardid" readonly type="text" value="${userinfo.cardid }" class="form-control">
											</div>
											<div class="form-group">
												<label>部门</label>
												<input name="department" readonly type="text" value="${userinfo.department }" class="form-control">
											</div>
											<div class="form-group">
												<label>学位</label>
												<input name="dedgree" readonly type="text" value="${userinfo.dedgree }" class="form-control">
											</div>
											<div class="form-group">
												<label>职称</label>
												<input name="title" readonly type="text" value="${userinfo.title }" class="form-control">
											</div>
										</div>
									</div>
								</c:if>
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
