<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!--财务表格-->
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
							<span class="title">Pricing Table</span>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">
											<div class="title">Pricing Table Example</div>
										</div>
										<div class="pull-right card-action">
											<div class="btn-group" role="group" aria-label="...">
												<button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalCardProfileExample"><i class="fa fa-code"></i></button>
											</div>
										</div>
									</div>
									<div class="card-body">
										<div class="row no-margin no-gap">
											<div class="col-sm-3">
												<div class="pricing-table green">
													<div class="pt-header">
														<div class="plan-pricing">
															<div class="pricing">$10</div>
															<div class="pricing-type">per month</div>
														</div>
													</div>
													<div class="pt-body">
														<h4>Basic Plan</h4>
														<ul class="plan-detail">
															<li>1 Website</li>
															<li>100 GB Storage</li>
															<li>Unlimited Bandwidth</li>
														</ul>
													</div>
													<div class="pt-footer">
														<button type="button" class="btn btn-success">Buy Now</button>
													</div>
												</div>
											</div>

											<div class="col-sm-3">
												<div class="pricing-table blue">
													<div class="pt-header">
														<div class="plan-pricing">
															<div class="pricing">$25</div>
															<div class="pricing-type">per month</div>
														</div>
													</div>
													<div class="pt-body">
														<h4>Standard Plan</h4>
														<ul class="plan-detail">
															<li>5 Website</li>
															<li>500 GB Storage</li>
															<li>Unlimited Bandwidth</li>
														</ul>
													</div>
													<div class="pt-footer">
														<button type="button" class="btn btn-info">Buy Now</button>
													</div>
												</div>
											</div>
											<div class="col-sm-3">
												<div class="pricing-table yellow">
													<div class="pt-header">
														<div class="plan-pricing">
															<div class="pricing">$50</div>
															<div class="pricing-type">per month</div>
														</div>
													</div>
													<div class="pt-body">
														<h4>Advanced Plan</h4>
														<ul class="plan-detail">
															<li>10 Website</li>
															<li>1 TB Storage</li>
															<li>Unlimited Bandwidth</li>
														</ul>
													</div>
													<div class="pt-footer">
														<button type="button" class="btn btn-warning">Buy Now</button>
													</div>
												</div>
											</div>
											<div class="col-sm-3">
												<div class="pricing-table red">
													<div class="pt-header">
														<div class="plan-pricing">
															<div class="pricing">$100</div>
															<div class="pricing-type">per month</div>
														</div>
													</div>
													<div class="pt-body">
														<h4>Unlimited Plan</h4>
														<ul class="plan-detail">
															<li>Unlimited Website</li>
															<li>Unlimited Storage</li>
															<li>Unlimited Bandwidth</li>
														</ul>
													</div>
													<div class="pt-footer">
														<button type="button" class="btn btn-danger">Buy Now</button>
													</div>
												</div>
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