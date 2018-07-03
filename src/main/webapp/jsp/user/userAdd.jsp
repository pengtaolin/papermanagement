<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 用户管理 -->
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
	                    	<span class="title">用户添加</span>
	                	</div>
	                	<div class="row">
						 	<div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/user/save.html"/>" method="post" enctype="multipart/form-data">
											<div class="form-group">
												<label>角色</label>
												<select name="roles" class="form-control" multiple="multiple">
													<c:forEach items="${roleList }" var="role" varStatus="r">
														<option value="${role.roleid}" <c:if test="${r.index eq 0}">selected</c:if>>${role.rolename}</option>
													</c:forEach>
												</select>
											</div>
											<div class="card">
												 <div class="card-body no-padding">
				                                    <div role="tabpanel">
				                                        <ul class="nav nav-tabs" role="tablist">
				                                            <li role="单条添加" ><a href="#one" aria-controls="one" role="tab" data-toggle="tab">单条添加</a></li>
				                                            <li role="批量添加" class="active"><a href="#more" aria-controls="more" role="tab" data-toggle="tab">批量添加</a></li>
				                                        </ul>
				                                        <div class="tab-content">
				                                            <div role="tabpanel" class="tab-pane" id="one">	<!-- 单条记录 -->
				                                            	<div class="form-group">
																	<label>学号/职工号</label>
																	<input name="userno" type="text" value="${userinfo.userno }" class="form-control">
																</div>
																<div class="form-group">
																	<label>姓名</label>
																	<input name="name" type="text" value="${userinfo.name }" class="form-control">
																</div>
																<div class="form-group">
																	<label>性别</label>
																	<select name="sex" class="form-control">
																		<option value="男" <c:if test="${userinfo.sex eq '男'}">selected</c:if>>男</option>
																		<option value="女" <c:if test="${userinfo.sex eq '女'}">selected</c:if>>女</option>
																	</select>
																</div>
																<div class="form-group">
																	<label>教学系</label>
																	<input name="series" type="text" value="${userinfo.series }" class="form-control">
																</div>
																<div class="form-group">
																	<label>专业</label>
																	<input name="major" type="text" value="${userinfo.major }" class="form-control">
																</div>
																<div class="form-group">
																	<label>班级</label>
																	<input name="clazz" type="text" value="${userinfo.clazz }" class="form-control">
																</div>
																<div class="form-group">
																	<label>入学年份 (例:2014)</label>
																	<input name="year" maxlength="4" type="text" value="${userinfo.year }" class="form-control">
																</div>
																<div class="form-group">
																	<label>届数 (例:2018)</label>
																	<input name="session" maxlength="4" type="text" value="${userinfo.session }" class="form-control">
																</div>
																<div class="form-group">
																	<label>手机号</label>
																	<input name="tel" maxlength="11" type="tel" value="${userinfo.tel }" class="form-control">
																</div>
																<div class="form-group">
																	<label>QQ</label>
																	<input name="qq" type="text" value="${userinfo.qq }" class="form-control">
																</div>
																<div class="form-group">
																	<label>邮箱</label>
																	<input name="email" type="email" value="${userinfo.email }" class="form-control">
																</div>
																<div class="form-group">
																	<label>身份证号</label>
																	<input name="cardid" maxlength="18" type="text" value="${userinfo.cardid }" class="form-control">
																</div>
																<div class="form-group">
																	<label>部门</label>
																	<input name="department" type="text" value="${userinfo.department }" class="form-control">
																</div>
																<div class="form-group">
																	<label>学位</label>
																	<input name="dedgree" type="text" value="${userinfo.dedgree }" class="form-control">
																</div>
																<div class="form-group">
																	<label>职称</label>
																	<input name="title" type="text" value="${userinfo.title }" class="form-control">
																</div>
				                                            </div>
				                                            <div role="tabpanel" class="tab-pane active" id="more">	<!-- 批量添加 -->
				                                        		<div class="form-group">
																	<label>表格文件(*.xls,*.xlsx)</label> <label style="color: red">${fileError }</label>
																	<input name="file" type="file" accept=".xls,.xlsx" class="form-control">
																</div>
				                                        	</div>
				                                        </div>
				                                    </div>
				                                </div>
			                                </div>
											
											<div class="btn-toolbar list-toolbar">
												<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
												<a href="<c:url value="/user/index.html"/>" class="btn btn-primary pull-right"><i class="fa fa-mail-reply"></i> 返回</a>
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
