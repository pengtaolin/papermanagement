<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 栏目管理 -->
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
	                        <span class="title">换题管理</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-body">
	                                    <table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>课题名称</th>
	                                                <th>课题类型</th>
	                                                <th>指导老师</th>
	                                                <th>创建时间</th>
	                                                <th></th>
	                                                <th></th>
	                                                <th></th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${subjectList }" var="subject" varStatus="i">
	                                        		<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td>
		                                                	<a data-toggle="modal" data-target="#modalCardProfileExample${i.index }">${subject.subjectname }</a>
		                                                	<div class="modal fade" id="modalCardProfileExample${i.index }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										                        <div class="modal-dialog modal-lg">
										                            <div class="modal-content">
										                                <div class="modal-header">
										                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										                                    <h4 class="modal-title" id="myModalLabel">课题简介</h4>
										                                </div>
										                                <div class="modal-body">
																			<div class="form-group">
																				<textarea class="form-control">${subject.subjectcontent }</textarea>
																			</div>
										                                </div>
										                            </div>
										                        </div>
										                    </div>
										                </td>
		                                                <td>${subject.subjecttype }</td>
		                                                <td>${subject.teachid }</td>
		                                                <td>
		                                                	<fmt:formatDate value="${subject.createtime }" pattern="yyyy-MM-dd"/>
	                                                	</td>
	                                                	<td>
	                                                		<c:if test="${subject.subjectstate eq 0}">
	                                                			<a href="/subject/stu/state/${subject.subjectid }/1.html">申请</a>
	                                                		</c:if>
	                                                		<c:if test="${subject.subjectstate eq 1}">
	                                                			申请中
	                                                		</c:if>
	                                                		<c:if test="${subject.subjectstate eq 2}">
	                                                			审核中
	                                                		</c:if>
	                                                		<c:if test="${subject.subjectstate eq 3}">
	                                                			<a href="/subject/stu/state/${subject.subjectid }/1.html">重新申请</a>
	                                                		</c:if>
	                                                		<c:if test="${subject.subjectstate eq 4}">
	                                                			<a href="/progress/start/${subject.subjectid}.html">开始写作</a>
	                                                		</c:if>
	                                                		<c:if test="${subject.subjectstate eq 5}">
	                                                			<a href="/subject/stu/state/${subject.subjectid }/1.html">重新申请</a>
	                                                		</c:if>
	                                                		<c:if test="${subject.subjectstate eq 8}">
	                                                			写作中
	                                                		</c:if>
														</td>
														
														<td>
															<a href="#myModal${i.index }" role="button" data-toggle="modal">
																<i class="fa fa-trash-o"></i>
															</a>
															<!-- 删除提示信息 -->
															<div class="modal small fade" id="myModal${i.index }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
																<div class="modal-dialog">
																	<div class="modal-content">
																		<div class="modal-header">
																			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																			<h3 id="myModalLabel">删除课题</h3>
																		</div>
																		<div class="modal-body">
																			<p class="error-text"><i class="fa fa-warning modal-icon"></i>你确定要删除这个课题吗?</p>
																		</div>
																		<div class="modal-footer">
																			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
																			<a class="btn btn-danger" href="<c:url value="/subject/stu/del/${subject.subjectid }.html"/>">删除</a>
																		</div>
																	</div>
																</div>
															</div>
														</td>
		                                            </tr>
	                                        	</c:forEach>
	                                        </tbody>
	                                    </table>
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
