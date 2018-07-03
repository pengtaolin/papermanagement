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
	                        <span class="title">选题汇总</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                            	<div class="card-header">
	                                    <div class="card-title">
	                                    	<div class="btn-toolbar list-toolbar">
	                                    		<button type="button" class="btn btn-primary" onclick="tableToExcel('contentTable','${selectList.list[0].taskid }届学生选题汇总.xls','选题汇总')"><i class="fa fa-table"></i> 导出表格</button>
											</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                    <table id="contentTable" class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>任务</th>
	                                                <th>题目及老师</th>
	                                                <th>学生</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${selectList.list }" var="select" varStatus="i">
	                                        		<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td>${select.taskid }</td>
		                                                <td>${select.subjectid }</td>
		                                                <td>${select.stuid }</td>
		                                            </tr>
	                                        	</c:forEach>
	                                        </tbody>
	                                    </table>
	                                    
                                     	<!-- 分页 -->
	                                    <ul class="pagination">
						  					<li>
												<a href="<c:url value="/select/leader/index${selectList.firstPage}.html"/>">&lt;&lt;</a>
											</li>
										  	<c:if test="${selectList.hasPreviousPage eq true}">
										  		<li>
											  		<a href="<c:url value="/select/leader/index${selectList.prePage}.html"/>">&lt;</a>
												</li>	
										  	</c:if>
											<li>
						  						<a>第${selectList.pageNum}页/共${selectList.pages}页</a>
						  					</li>
											<c:if test="${selectList.hasNextPage eq true}">
										  		<li>
											  		<a href="<c:url value="/select/leader/index${selectList.nextPage}.html"/>">&gt;</a>
												</li>	
										  	</c:if>
											<li>
										  		<a href="<c:url value="/select/leader/index${selectList.lastPage}.html"/>">&gt;&gt;</a>
											</li>
										</ul>
										
										
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
