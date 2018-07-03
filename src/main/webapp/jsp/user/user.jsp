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
												<a class="btn btn-primary" href="<c:url value="/user/add.html"/>"><i class="fa fa-plus"></i> 添加用户</a>
											</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                      <table class="datatable table table-hover" cellspacing="0" width="100%">
	                                        <thead>
	                                            <tr>
	                                            	<th>序号</th>
	                                                <th>姓名</th>
	                                                <th>性别</th>
	                                                <th>教学系</th>
	                                                <th>专业</th>
	                                                <th>班级</th>
	                                                <th>届数</th>
	                                            </tr>
	                                        </thead>
	                                        <tfoot>
                                            	<tr>
	                                               	<th>序号</th>
	                                                <th>姓名</th>
	                                                <th>性别</th>
	                                                <th>教学系</th>
	                                                <th>专业</th>
	                                                <th>班级</th>
	                                                <th>届数</th>
	                                            
	                                            </tr>
	                                        </tfoot>
	                                        <tbody>
	                                        	<c:forEach items="${userList }" var="user">
	                                        		<tr onclick="toView('${user.userid }');">
		                                            	<td>${user.userno }</td>
		                                                <td>${user.name }</td>
		                                                <td>${user.sex }</td>
		                                                <td>${user.series }</td>
		                                                <td>${user.major }</td>
		                                                <td>${user.clazz }</td>
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
			//alert(id);
			var url = "/user/view/"+id+".html";
			window.location.href = url;
		};
	</script>
</html>
