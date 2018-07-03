<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<nav class="navbar navbar-default navbar-fixed-top navbar-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-expand-toggle">
	                        <i class="fa fa-bars icon"></i>
	                    </button>
				<ol class="breadcrumb navbar-breadcrumb">
					<li class="active">菜单</li>
				</ol>
				<button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                    <i class="fa fa-th icon"></i>
                </button>
			</div>
			
			<ul class="nav navbar-nav navbar-right">
				<button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                	<i class="fa fa-times icon"></i>
               	</button>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-comments-o"></i></a>
					<ul class="dropdown-menu animated fadeInDown">
						<li class="title">
							通知 <span class="badge pull-right">0</span>
						</li>
						<li class="message">
							没有新通知
						</li>
					</ul>
				</li>
				<li class="dropdown danger">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-star-half-o"></i> 4</a>
					<ul class="dropdown-menu danger  animated fadeInDown">
						<li class="title">
							通知 <span class="badge pull-right">4</span>
						</li>
						<li>
							<ul class="list-group notifications">
								<a href="#">
									<li class="list-group-item">
										<span class="badge">1</span> <i class="fa fa-exclamation-circle icon"></i> 新注册
									</li>
								</a>
								<a href="#">
									<li class="list-group-item">
										<span class="badge success">1</span> <i class="fa fa-check icon"></i> 新任务
									</li>
								</a>
								<a href="#">
									<li class="list-group-item">
										<span class="badge danger">2</span> <i class="fa fa-comments icon"></i> 客户信息
									</li>
								</a>
								<a href="#">
									<li class="list-group-item message">
										查看所有
									</li>
								</a>
							</ul>
						</li>
					</ul>
				</li>
				<li class="dropdown profile">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">欢迎您，${sessionScope.session_user.name }  <span class="caret"></span></a>
					<ul class="dropdown-menu animated fadeInDown">
						<li class="profile-img">
							<img src="<c:url value='${sessionScope.session_user.imageurl }'/>" class="profile-img">
						</li>
						<li>
							<div class="profile-info">
								<h4 class="username">${sessionScope.session_user.name }</h4>
								<p>${sessionScope.session_user.email }</p>
								<div class="btn-group margin-bottom-2x" role="group">
									<a type="button" class="btn btn-default" href="<c:url value="/user/detail.html"/>"><i class="fa fa-user"></i> 基本信息</a>
									<a type="button" class="btn btn-default" href="<c:url value="/user/exit.html"/>"><i class="fa fa-sign-out"></i> 退出</a>
								</div>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
				