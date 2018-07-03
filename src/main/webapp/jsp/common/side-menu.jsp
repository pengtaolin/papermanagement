<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<!-- 侧拉菜单 -->
	<div class="side-menu sidebar-inverse">
		<nav class="navbar navbar-default" role="navigation">
			<div class="side-menu-container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">
						<!-- <div class="icon fa fa-paper-plane"></div> -->
						<div class="icon fa">
							<img title="赣南师范大学科技学院" alt="赣南师范大学科技学院" style="width:34px;height: 34px" src="<c:url value='/img/school.png'/>">
						</div>
						<div class="title">论文管理系统</div>
					</a>
					<button type="button" class="navbar-expand-toggle pull-right visible-xs">
                         <i class="fa fa-times icon"></i>
                     </button>
				</div>
				<ul class="nav navbar-nav">
					<!-- 使用中的界面 -->
					<li class="active">
						<a href="<c:url value='/main.html'/>">
							<span class="icon fa fa-desktop"></span><span class="title">首页</span>
						</a>
					</li>
					<c:forEach items="${sessionScope.ColumnPerm }" var="col" varStatus="cv">
						
						<c:if test="${empty col.childs }">
							<li>
								<a href="<c:url value='${col.url }'/>">
									<span class="icon fa fa-file-text-o"></span><span class="title">${col.columnname }</span>
								</a>
							</li>
						</c:if>
						
						<c:if test="${not empty col.childs}">
							<li class="panel panel-default dropdown">
								<a data-toggle="collapse" href="#dropdown-${cv.index }">
									<span class="icon fa fa-cubes"></span><span class="title">${col.columnname }</span>
								</a>
								<!-- 下拉列表等级1 -->
								<div id="dropdown-${cv.index }" class="panel-collapse collapse">
									<div class="panel-body">
										<ul class="nav navbar-nav">
											<c:forEach items="${col.childs }" var="ch">
												<li>
													<a href="${ch.url }">${ch.columnname }</a>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</li>
						</c:if>
					</c:forEach>
					
					
					
					
					
				<!-- 	
					
					<li>
						<a href="<c:url value='/select/leader/score/index.html'/>">
							<span class="icon fa fa-desktop"></span><span class="title">成绩汇总</span>
						</a>
					</li>
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-21">
							<span class="icon fa fa-cubes"></span><span class="title">指导老师</span>
						</a>
						下拉列表等级1
						<div id="dropdown-21" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									
									<li>
										<a href="/subject/teach/index.html">预设选题</a>
									</li>
									<li>
										<a href="/select/teach/index.html">选题审核</a>
									</li>
									<li>
										<a href="/user/mystu.html">指导学生</a>
									</li>
									<li>
										<a href="/progress/teach/index.html">批改论文</a>
									</li>
									<li>
										<a href="#">作品推荐</a>
									</li>
									
									
									<li>
										<a href="/user/mystu.html">指导学生</a>
									</li>
									<li>
										<a href="/paper/teach/index.html">成绩评审</a>
									</li>
									
								</ul>
							</div>
						</div>
					</li> -->
					
					<!-- <li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-31">
							<span class="icon fa fa-cubes"></span><span class="title">答辩老师</span>
						</a>
						下拉列表等级1
						<div id="dropdown-31" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="#">论文评审</a>
									</li>
									<li>
										<a href="#">答辩学生</a>
									</li>
								</ul>
							</div>
						</div>
					</li> -->
					
					<!-- <li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-41">
							<span class="icon fa fa-cubes"></span><span class="title">系主任</span>
						</a>
						下拉列表等级1
						<div id="dropdown-41" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="/subject/leader/index.html">课题审核</a>
									</li> 
									
									<li>
										<a href="/select/leader/index.html">选题汇总</a>
									</li>
									<li>
										<a href="/paper/leader/index.html">论文汇总</a>
									</li>
								</ul>
							</div>
						</div>
					</li> -->
					
					
					<!--
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-11">
							<span class="icon fa fa-cubes"></span><span class="title">学生</span>
						</a>-->
						<!-- 下拉列表等级1 -->
						<!--
						<div id="dropdown-11" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									 <li>
										<a href="/select/stu/index.html">学生选题</a>
									</li> 
									<li>
										<a href="/subject/stu/index.html">申请换题</a>
									</li>
									<li>
										<a href="/progress/stu/index.html">论文进度</a>
									</li>
									<li>
										<a href="/user/myteach.html">指导老师</a>
									</li>
									<li>
										<a href="/select/stu/score.html">查询成绩</a>
									</li>
								</ul>
							</div>
						</div>
					</li>-->
					
					<!-- <li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-51">
							<span class="icon fa fa-cubes"></span><span class="title">管理员</span>
						</a>
						下拉列表等级1
						<div id="dropdown-51" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="/group/index.html">小组管理</a>
									</li>
									<li>
										<a href="/task/index.html">任务管理</a>
									</li>
									<li>
										<a href="/subject/index.html">课题管理</a>
									</li>
									<li>
										<a href="/paper/admin/index.html">文档管理</a>
									</li>
								</ul>
							</div>
						</div>
					</li> -->
					
					
					
					
					
					<!-- 开发中部分内容 -->
					<%-- <li class="active">
						<a href="<c:url value='/main.html'/>">
							<span class="icon fa fa-tachometer"></span><span class="title">首页</span>
						</a>
					</li>
					<li>
						<a href="<c:url value='/notice/index.html'/>">
							<span class="icon fa fa-file-text-o"></span><span class="title">公告管理</span>
						</a>
					</li>
					<li>
						<a href="<c:url value='/column/index.html'/>">
							<span class="icon fa fa-file-text-o"></span><span class="title">栏目管理</span>
						</a>
					</li>
					
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-1">
							<span class="icon fa fa-cubes"></span><span class="title">论文管理</span>
						</a>
						<!-- 下拉列表等级1 -->
						<div id="dropdown-1" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<!-- 学生 -->
									<li>
										<a href="#">学生选题</a>
									</li>
									<li>
										<a href="#">提交论文</a>
									</li>
									<li>
										<a href="#">下载论文</a>
									</li>
									<li>
										<a href="#">查看论文</a>
									</li>
									<li>
										<a href="#">查询成绩</a>
									</li>
									<li>
										<a href="#">指导老师</a>
									</li>
									<li>
										<a href="#">基本信息</a>
									</li>
									<!-- 指导老师 -->
									<li>
										<a href="#">选题管理</a>
									</li>
									<li>
										<a href="#">学生管理</a>
									</li>
									<li>
										<a href="#">下载论文</a>
									</li>
									<li>
										<a href="#">查看论文</a>
									</li>
									<li>
										<a href="#">批改论文</a>
									</li>
									<li>
										<a href="#">成绩评审</a>
									</li>
									<li>
										<a href="#">作品推荐</a>
									</li>
									<li>
										<a href="#">基本信息</a>
									</li>
									<!-- 答辩老师 -->
									<li>
										<a href="#">成绩评审</a>
									</li>
									<li>
										<a href="#">学生管理</a>
									</li>
									<!-- 系主任 -->
									<li>
										<a href="#">选题审核</a>
									</li>
									<li>
										<a href="#">审核意见</a>
									</li>
									<!-- 管理员 -->
									<li>
										<a href="#">选题管理</a>
									</li>
									<li>
										<a href="#">专业管理</a>
									</li>
									<li>
										<a href="#">文档管理</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
					
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-2">
							<span class="icon fa fa-desktop"></span><span class="title">用户管理</span>
						</a>
						<!-- 下拉列表等级1 -->
						<div id="dropdown-2" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="<c:url value="/user/index.html"/>">用户管理</a>
									</li>
									<li>
										<a href="<c:url value="/role/index.html"/>">角色管理</a>
									</li>
									<li>
										<a href="<c:url value="/perm/index.html"/>">权限管理</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
					
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-5">
							<span class="icon fa fa-desktop"></span><span class="title">系统管理</span>
						</a>
						<!-- 下拉列表等级1 -->
						<div id="dropdown-5" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="#">系统设置</a>
									</li>
									<li>
										<a href="#">基本信息</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
					
					
					
					
					
					<!-- 例子 激活状态 -->
					
					<!-- 例子 下拉列表状态 -->
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-element">
							<span class="icon fa fa-desktop"></span><span class="title">UI工具包</span>
						</a>
						<!-- 下拉列表等级1 -->
						<div id="dropdown-element" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="<c:url value='/jsp/ui-kits/theming.jsp'/>">支持主题</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/ui-kits/grid.jsp'/>">网格</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/ui-kits/button.jsp'/>">按钮</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/ui-kits/card.jsp'/>">卡片</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/ui-kits/list.jsp'/>">列表</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/ui-kits/modal.jsp'/>">情态动词</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/ui-kits/alert.jsp'/>">警报和提示</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/ui-kits/panel.jsp'/>">面板</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/ui-kits/loader.jsp'/>">装载机</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/ui-kits/step.jsp'/>">标签及步骤</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/ui-kits/other.jsp'/>">其他</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-table">
							<span class="icon fa fa-table"></span><span class="title">表格</span>
						</a>
						<!-- Dropdown level 1 -->
						<div id="dropdown-table" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="<c:url value='/jsp/table/table.jsp'/>">表格</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/table/datatable.jsp'/>">数据库</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-form">
							<span class="icon fa fa-file-text-o"></span><span class="title">表单</span>
						</a>
						<!-- Dropdown level 1 -->
						<div id="dropdown-form" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="<c:url value='/jsp/form/ui-kits.jsp'/>">表单UI工具包</a>
									</li>
								</ul>
							</div>
						</div>
					</li>

					<!-- Dropdown-->
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#component-example">
							<span class="icon fa fa-cubes"></span><span class="title">组件</span>
						</a>
						<!-- Dropdown level 1 -->
						<div id="component-example" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="<c:url value='/jsp/components/pricing-table.jsp'/>">财务表格</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/components/chartjs.jsp'/>">图表JS</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
					<!-- Dropdown-->
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-example">
							<span class="icon fa fa-slack"></span><span class="title">页面例子</span>
						</a>
						<!-- Dropdown level 1 -->
						<div id="dropdown-example" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="<c:url value='/jsp/pages/login.jsp'/>">登录</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/pages/index.jsp'/>">主界面</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
					<!-- Dropdown-->
					<li class="panel panel-default dropdown">
						<a data-toggle="collapse" href="#dropdown-icon">
							<span class="icon fa fa-archive"></span><span class="title">图标</span>
						</a>
						<!-- Dropdown level 1 -->
						<div id="dropdown-icon" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li>
										<a href="<c:url value='/jsp/icons/glyphicons.jsp'/>">Glyphicons</a>
									</li>
									<li>
										<a href="<c:url value='/jsp/icons/font-awesome.jsp'/>">优美的字体</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
					<li>
						<a href="<c:url value='/jsp/license.jsp'/>">
							<span class="icon fa fa-thumbs-o-up"></span><span class="title">许可证</span>
						</a>
					</li> --%>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</div>
	<!--版权声明-->
	<div class="copyrights">
		Collect from Lin
	</div>