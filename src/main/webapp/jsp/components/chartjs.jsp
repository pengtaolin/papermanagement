<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!--图表Js-->
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
							<span class="title">Chart</span>
							<div class="description">Create chart with Chart.js</div>
						</div>
						<div class="row">
							<div class="col-sm-6 col-xs-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">
											<div class="title">Line Chart</div>
										</div>
									</div>
									<div class="card-body no-padding">
										<canvas id="line-chart" class="chart"></canvas>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-xs-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">
											<div class="title">Bar Chart</div>
										</div>
									</div>
									<div class="card-body no-padding">
										<canvas id="bar-chart" class="chart"></canvas>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 col-xs-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">
											<div class="title">Radar Chart</div>
										</div>
									</div>
									<div class="card-body no-padding">
										<canvas id="radar-chart" class="chart"></canvas>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-xs-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">
											<div class="title">Polar Area Chart</div>
										</div>
									</div>
									<div class="card-body no-padding">
										<canvas id="polar-area-chart" class="chart"></canvas>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 col-xs-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">
											<div class="title">Pie & Doughnut Chart</div>
										</div>
									</div>
									<div class="card-body no-padding">
										<canvas id="pie-chart" class="chart"></canvas>
									</div>
								</div>
							</div>
						</div>
						<div class="page-title">
							<span class="title">Card Jumbotron</span>
							<div class="description">Chart.js in Jumbotron Header, recommend using in dashboard pages.</div>
						</div>
						<div class="row">
							<div class="col-sm-6 col-xs-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">
											<div class="title">Line Chart</div>
										</div>
									</div>
									<div class="card-body">
										<div class="card primary">
											<div class="card-jumbotron no-padding">
												<canvas id="jumbotron-line-chart" class="chart no-padding"></canvas>
											</div>
											<div class="card-body">
												<h4>Lorem Ipsum</h4> Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
											</div>
										</div>
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