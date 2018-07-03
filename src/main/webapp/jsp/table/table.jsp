<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 表格 -->
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
	                        <span class="title">Table</span>
	                        <div class="description">A bootstrap table for display list of data.</div>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-header">
	
	                                    <div class="card-title">
	                                    <div class="title">Table</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                    <table class="table">
	                                        <thead>
	                                            <tr>
	                                                <th>#</th>
	                                                <th>First Name</th>
	                                                <th>Last Name</th>
	                                                <th>Username</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                            <tr>
	                                                <th scope="row">1</th>
	                                                <td>Mark</td>
	                                                <td>Otto</td>
	                                                <td>@mdo</td>
	                                            </tr>
	                                            <tr>
	                                                <th scope="row">2</th>
	                                                <td>Jacob</td>
	                                                <td>Thornton</td>
	                                                <td>@fat</td>
	                                            </tr>
	                                            <tr>
	                                                <th scope="row">3</th>
	                                                <td>Larry</td>
	                                                <td>the Bird</td>
	                                                <td>@twitter</td>
	                                            </tr>
	                                        </tbody>
	                                    </table>
	                                    <div class="row">
	                                        <div class="col-sm-6">
	                                            <div class="sub-title">Table Striped <span class="description">( .table-striped )</span></div>
	                                            <table class="table table-striped">
	                                                <thead>
	                                                    <tr>
	                                                        <th>#</th>
	                                                        <th>First Name</th>
	                                                        <th>Last Name</th>
	                                                        <th>Username</th>
	                                                    </tr>
	                                                </thead>
	                                                <tbody>
	                                                    <tr>
	                                                        <th scope="row">1</th>
	                                                        <td>Mark</td>
	                                                        <td>Otto</td>
	                                                        <td>@mdo</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">2</th>
	                                                        <td>Jacob</td>
	                                                        <td>Thornton</td>
	                                                        <td>@fat</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">3</th>
	                                                        <td>Larry</td>
	                                                        <td>the Bird</td>
	                                                        <td>@twitter</td>
	                                                    </tr>
	                                                </tbody>
	                                            </table>
	                                        </div>
	                                        <div class="col-sm-6">
	                                            <div class="sub-title">Table Bordered <span class="description">( .table-bordered )</span></div>
	                                            <table class="table table-bordered">
	                                                <thead>
	                                                    <tr>
	                                                        <th>#</th>
	                                                        <th>First Name</th>
	                                                        <th>Last Name</th>
	                                                        <th>Username</th>
	                                                    </tr>
	                                                </thead>
	                                                <tbody>
	                                                    <tr>
	                                                        <th scope="row">1</th>
	                                                        <td>Mark</td>
	                                                        <td>Otto</td>
	                                                        <td>@mdo</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">2</th>
	                                                        <td>Jacob</td>
	                                                        <td>Thornton</td>
	                                                        <td>@fat</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">3</th>
	                                                        <td>Larry</td>
	                                                        <td>the Bird</td>
	                                                        <td>@twitter</td>
	                                                    </tr>
	                                                </tbody>
	                                            </table>
	                                        </div>
	                                    </div>
	                                    <div class="row">
	                                        <div class="col-sm-6">
	                                            <div class="sub-title">Table Hover <span class="description">( .table-hover )</span></div>
	                                            <table class="table table-hover">
	                                                <thead>
	                                                    <tr>
	                                                        <th>#</th>
	                                                        <th>First Name</th>
	                                                        <th>Last Name</th>
	                                                        <th>Username</th>
	                                                    </tr>
	                                                </thead>
	                                                <tbody>
	                                                    <tr>
	                                                        <th scope="row">1</th>
	                                                        <td>Mark</td>
	                                                        <td>Otto</td>
	                                                        <td>@mdo</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">2</th>
	                                                        <td>Jacob</td>
	                                                        <td>Thornton</td>
	                                                        <td>@fat</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">3</th>
	                                                        <td>Larry</td>
	                                                        <td>the Bird</td>
	                                                        <td>@twitter</td>
	                                                    </tr>
	                                                </tbody>
	                                            </table>
	                                        </div>
	                                        <div class="col-sm-6">
	                                            <div class="sub-title">Table Condensed <span class="description">( .table-condensed )</span></div>
	                                            <table class="table table-condensed">
	                                                <thead>
	                                                    <tr>
	                                                        <th>#</th>
	                                                        <th>First Name</th>
	                                                        <th>Last Name</th>
	                                                        <th>Username</th>
	                                                    </tr>
	                                                </thead>
	                                                <tbody>
	                                                    <tr>
	                                                        <th scope="row">1</th>
	                                                        <td>Mark</td>
	                                                        <td>Otto</td>
	                                                        <td>@mdo</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">2</th>
	                                                        <td>Jacob</td>
	                                                        <td>Thornton</td>
	                                                        <td>@fat</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">3</th>
	                                                        <td>Larry</td>
	                                                        <td>the Bird</td>
	                                                        <td>@twitter</td>
	                                                    </tr>
	                                                </tbody>
	                                            </table>
	                                        </div>
	                                    </div>
	                                    <div class="row">
	                                        <div class="col-sm-12 col-md-6">
	                                            <div class="sub-title">Contextual classes <span class="description">( .active , .success , .info , .warning , .danger )</span></div>
	                                            <table class="table">
	                                                <thead>
	                                                    <tr>
	                                                        <th>#</th>
	                                                        <th>Column heading</th>
	                                                        <th>Column heading</th>
	                                                        <th>Column heading</th>
	                                                    </tr>
	                                                </thead>
	                                                <tbody>
	                                                    <tr class="active">
	                                                        <th scope="row">1</th>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">2</th>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                    </tr>
	                                                    <tr class="success">
	                                                        <th scope="row">3</th>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">4</th>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                    </tr>
	                                                    <tr class="info">
	                                                        <th scope="row">5</th>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">6</th>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                    </tr>
	                                                    <tr class="warning">
	                                                        <th scope="row">7</th>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                    </tr>
	                                                    <tr>
	                                                        <th scope="row">8</th>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                    </tr>
	                                                    <tr class="danger">
	                                                        <th scope="row">9</th>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                        <td>Column content</td>
	                                                    </tr>
	                                                </tbody>
	                                            </table>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-header">
	                                    <div class="card-title">
	                                    <div class="title">Panel with Table</div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                    <div class="panel panel-default">
	                                        <!-- Default panel contents -->
	                                        <div class="panel-heading">Panel heading</div>
	                                        <div class="panel-body">
	                                            <p>Some default panel content here. Nulla vitae elit libero, a pharetra augue. Aenean lacinia bibendum nulla sed consectetur. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
	                                        </div>
	                                        <!-- Table -->
	                                        <table class="table">
	                                            <thead>
	                                                <tr>
	                                                    <th>#</th>
	                                                    <th>First Name</th>
	                                                    <th>Last Name</th>
	                                                    <th>Username</th>
	                                                </tr>
	                                            </thead>
	                                            <tbody>
	                                                <tr>
	                                                    <th scope="row">1</th>
	                                                    <td>Mark</td>
	                                                    <td>Otto</td>
	                                                    <td>@mdo</td>
	                                                </tr>
	                                                <tr>
	                                                    <th scope="row">2</th>
	                                                    <td>Jacob</td>
	                                                    <td>Thornton</td>
	                                                    <td>@fat</td>
	                                                </tr>
	                                                <tr>
	                                                    <th scope="row">3</th>
	                                                    <td>Larry</td>
	                                                    <td>the Bird</td>
	                                                    <td>@twitter</td>
	                                                </tr>
	                                            </tbody>
	                                        </table>
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
