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
	                        <span class="title">我的学生</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-body">
	                                	<table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                            	<th>学号</th>
	                                                <th>姓名</th>
	                                                <th>性别</th>
	                                                <th>班级</th>
	                                                <th>选题</th>
	                                                <th>届数</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${userList }" var="user">
	                                        		<tr onclick="toView('${user.userid }');">
		                                            	<td>${user.userno }</td>
		                                                <td>${user.name }</td>
		                                                <td>${user.sex }</td>
		                                                <td>${user.clazz }</td>
		                                                <td>${user.title }</td>
		                                                <td>${user.session }</td>
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
	<script type="text/javascript">
		function toView(id) {
			//发出get请求到显示界面
			var url = "/user/teachview/"+id+".html";
			window.location.href = url;
		};
	</script>
</html>
