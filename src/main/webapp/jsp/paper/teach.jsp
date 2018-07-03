<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 文档管理 -->
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
	                        <span class="title">成绩评审</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-body">
	                                    <table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>名称</th>
	                                                <th>操作</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${paperList }" var="paper" varStatus="p">
		                                            <tr>
		                                                <th scope="row">${p.index+1 }</th>
		                                                <td>${paper.papername }</td>
		                                                
		                                               	<td>
		                                               		<c:if test="${paper.paperstate ==0}">
		                                               			<a href="/paper/score/${paper.fileurl }.html">成绩输入</a>
		                                               		</c:if>
		                                               		<c:if test="${paper.paperstate ==1}">
		                                               			<a href="/paper/score/${paper.fileurl }.html">重新输入</a>
		                                               		</c:if>
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
