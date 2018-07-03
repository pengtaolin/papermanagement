<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!--后台主页-->
<html>
	<!--主体-->
	<body class="flat-blue">
		<div class="app-container">
			<div class="row content-container">
				<!--导航条-->
				<jsp:include page="/jsp/common/navber.jsp"/>

				<!--侧拉菜单与版权声明-->
				<jsp:include page="/jsp/common/side-menu.jsp"/>
				
				<!-- 主界面内容 -->
				<div class="container-fluid">
					<div class="side-body padding-top">
						<div class="row">
							<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
								<a href="#">
									<div class="card red summary-inline">
										<div class="card-body">
											<i class="icon fa fa-inbox fa-4x"></i>
											<div class="content">
												<div class="title">50</div>
												<div class="sub-title">新邮件</div>
											</div>
											<div class="clear-both"></div>
										</div>
									</div>
								</a>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
								<a href="#">
									<div class="card yellow summary-inline">
										<div class="card-body">
											<i class="icon fa fa-comments fa-4x"></i>
											<div class="content">
												<div class="title">23</div>
												<div class="sub-title">新消息</div>
											</div>
											<div class="clear-both"></div>
										</div>
									</div>
								</a>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
								<a href="#">
									<div class="card green summary-inline">
										<div class="card-body">
											<i class="icon fa fa-tags fa-4x"></i>
											<div class="content">
												<div class="title">280</div>
												<div class="sub-title">产品界面</div>
											</div>
											<div class="clear-both"></div>
										</div>
									</div>
								</a>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
								<a href="#">
									<div class="card blue summary-inline">
										<div class="card-body">
											<i class="icon fa fa-share-alt fa-4x"></i>
											<div class="content">
												<div class="title">16</div>
												<div class="sub-title">分享</div>
											</div>
											<div class="clear-both"></div>
										</div>
									</div>
								</a>
							</div>
						</div>
						<div class="row  no-margin-bottom">
							<div class="col-sm-6 col-xs-12">
								<div class="row">
									<div class="col-xs-12">
										<div class="card primary">
											<div class="card-jumbotron no-padding">
												<canvas id="jumbotron-line-chart" class="chart no-padding"></canvas>
											</div>
											<div class="card-body half-padding">
												<h4 class="float-left no-margin font-weight-300">利润</h4>
												<h2 class="float-right no-margin font-weight-300">$3200</h2>
												<div class="clear-both"></div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 col-sm-12">
										<div class="thumbnail no-margin-bottom">
											<img src="../img/thumbnails/picjumbo.com_IMG_4566.jpg" class="img-responsive">
											<div class="caption">
												<h3 id="thumbnail-label">缩略图标签<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
												<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
												<p>
													<a href="#" class="btn btn-primary" role="button">按钮</a>
													<a href="#" class="btn btn-default" role="button">按钮</a>
												</p>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-12">
										<div class="thumbnail no-margin-bottom">
											<img src="../img/thumbnails/picjumbo.com_IMG_3241.jpg" class="img-responsive">
											<div class="caption">
												<h3 id="thumbnail-label">缩略图标签<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
												<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
												<p>
													<a href="#" class="btn btn-success" role="button">按钮</a>
													<a href="#" class="btn btn-default" role="button">按钮</a>
												</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-xs-12">
								<div class="row">
									<div class="col-md-6 col-sm-12">
										<div class="card primary">
											<div class="card-jumbotron no-padding">
												<canvas id="jumbotron-bar-chart" class="chart no-padding"></canvas>
											</div>
											<div class="card-body half-padding">
												<h4 class="float-left no-margin font-weight-300">任务</h4>
												<div class="clear-both"></div>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-12">
										<div class="card primary">
											<div class="card-jumbotron no-padding">
												<canvas id="jumbotron-line-2-chart" class="chart no-padding"></canvas>
											</div>
											<div class="card-body half-padding">
												<h4 class="float-left no-margin font-weight-300">界面视图</h4>
												<div class="clear-both"></div>
											</div>
										</div>
									</div>
								</div>
								<div class="card card-success">
									<div class="card-header">
										<div class="card-title">
											<div class="title"><i class="fa fa-comments-o"></i> 最后消息</div>
										</div>
										<div class="clear-both"></div>
									</div>
									<div class="card-body no-padding">
										<ul class="message-list">
											<a href="#">
												<li>
													<img src="../img/profile/profile-1.jpg" class="profile-img pull-left">
													<div class="message-block">
														<div><span class="username">Tui2Tone</span> <span class="message-datetime">12 min ago</span>
														</div>
														<div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
													</div>
												</li>
											</a>
											<a href="#">
												<li>
													<img src="../img/profile/profile-1.jpg" class="profile-img pull-left">
													<div class="message-block">
														<div><span class="username">Tui2Tone</span> <span class="message-datetime">15 min ago</span>
														</div>
														<div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
													</div>
												</li>
											</a>
											<a href="#">
												<li>
													<img src="../img/profile/profile-1.jpg" class="profile-img pull-left">
													<div class="message-block">
														<div><span class="username">Tui2Tone</span> <span class="message-datetime">2 hour ago</span>
														</div>
														<div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
													</div>
												</li>
											</a>
											<a href="#">
												<li>
													<img src="../img/profile/profile-1.jpg" class="profile-img pull-left">
													<div class="message-block">
														<div><span class="username">Tui2Tone</span> <span class="message-datetime">1 day ago</span>
														</div>
														<div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
													</div>
												</li>
											</a>
											<a href="#" id="message-load-more">
												<li class="text-center load-more">
													<i class="fa fa-refresh"></i> 加载更多...
												</li>
											</a>
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