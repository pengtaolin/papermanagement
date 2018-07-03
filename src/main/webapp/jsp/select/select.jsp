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
	                        <span class="title">选题管理</span>
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
	                                                <th>指导老师</th>
	                                                <th>操作</th>
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
		                                                <td>${subject.teachid }</td>
		                                                <td>
															<c:if test="${subject.subjectstate eq 0}"><a href="/select/stu/add/${subject.subjectid }.html">选择</a></c:if>
															<c:if test="${subject.subjectstate eq 1}">已选择</c:if>
															<c:if test="${subject.subjectstate eq 2}">已选完</c:if>
															<c:if test="${subject.subjectstate eq 3}">
																<a href="/progress/start/${subject.subjectid}.html">开始写作</a>
																&nbsp;
																<a href="/subject/stu/add.html">申请换题</a>
															</c:if>
															<c:if test="${subject.subjectstate eq 4}">未通过</c:if>
															<c:if test="${subject.subjectstate eq 8}">写作中</c:if>
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
