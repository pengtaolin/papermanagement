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
	                        <span class="title">用户管理</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-header">
	                                    <div class="card-title">
	                                    	<div class="btn-toolbar list-toolbar">
	                                    		<button type="button" class="btn btn-primary" onclick="tableToExcel('contentTable','学生论文成绩汇总.xls','成绩汇总')"><i class="fa fa-table"></i> 导出表格</button>
											</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                      <table id="contentTable" class="datatable table table-hover" cellspacing="0" width="100%">
	                                        <thead>
	                                            <tr>
	                                            	<th>序号</th>
	                                                <th>论文（设计）题目</th>
	                                                <th>学生姓名</th>
	                                                <th>学生学号</th>
	                                                <th>教师姓名</th>
	                                                <th>教师性别</th>
	                                                <th>教师职称</th>
	                                                <th>教师学位</th>
	                                                <th>教师单位</th>
	                                                <th>指导成绩</th>
	                                                <th>答辩成绩</th>
	                                                <th>总成绩</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${scoreTables }" var="scoreTable" varStatus="st">
		                                        	<tr>
		                                               	<td>${st.index+1 }</td>
		                                                <td>${scoreTable.subjectname }</td>
		                                                <td>${scoreTable.student.name }</td>
		                                                <td>${scoreTable.student.userno }</td>
		                                                <td>${scoreTable.teacher.name }</td>
		                                                <td>${scoreTable.teacher.sex }</td>
		                                                <td>${scoreTable.teacher.title }</td>
		                                                <td>${scoreTable.teacher.dedgree }</td>
		                                                <td>${scoreTable.teacher.department }</td>
														<td>${scoreTable.baseScore }</td>
		                                                <td>${scoreTable.showScore }</td>
		                                                <td><fmt:formatNumber type="number" value="${scoreTable.sumScore }" pattern="#.00"/></td>
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
