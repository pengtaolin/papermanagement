<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
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
                        <span class="title">Panel</span>
                        <div class="description">Just like Card Block.</div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="card">
                                <div class="card-header">

                                    <div class="card-title">
                                    <div class="title">Panel</div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div>
                                        <div class="panel panel-default">
                                            <div class="panel-body">
                                                Basic panel example
                                            </div>
                                        </div>
                                    </div>
                                    <div class="sub-title">Panel with Header</div>
                                    <div>
                                        <div class="panel panel-default">
                                            <div class="panel-heading">Panel heading without title</div>
                                            <div class="panel-body">
                                                Panel content
                                            </div>
                                        </div>
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">Panel title</h3>
                                            </div>
                                            <div class="panel-body">
                                                Panel content
                                            </div>
                                        </div>
                                    </div>
                                    <div class="sub-title">Panel Colors</div>
                                    <div class="row row-example">
                                        <div class="col-sm-4">
                                            <div class="panel panel-primary">
                                                <div class="panel-heading">.panel-primary</div>
                                                <div class="panel-body">
                                                    Panel content
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="panel panel-success">
                                                <div class="panel-heading">.panel-success</div>
                                                <div class="panel-body">
                                                    Panel content
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="panel panel-info">
                                                <div class="panel-heading">.panel-info</div>
                                                <div class="panel-body">
                                                    Panel content
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="panel panel-warning">
                                                <div class="panel-heading">.panel-warning</div>
                                                <div class="panel-body">
                                                    Panel content
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="panel panel-danger">
                                                <div class="panel-heading">.panel-danger</div>
                                                <div class="panel-body">
                                                    Panel content
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="sub-title">Panel with Fresh Colors <span class="description">( .fresh-color )</span></div>
                                    <div class="row row-example">
                                        <div class="col-sm-4">
                                            <div class="panel fresh-color panel-primary">
                                                <div class="panel-heading">.panel-primary</div>
                                                <div class="panel-body">
                                                    Panel content
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="panel fresh-color panel-success">
                                                <div class="panel-heading">.panel-success</div>
                                                <div class="panel-body">
                                                    Panel content
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="panel fresh-color panel-info">
                                                <div class="panel-heading">.panel-info</div>
                                                <div class="panel-body">
                                                    Panel content
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="panel fresh-color panel-warning">
                                                <div class="panel-heading">.panel-warning</div>
                                                <div class="panel-body">
                                                    Panel content
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="panel fresh-color panel-danger">
                                                <div class="panel-heading">.panel-danger</div>
                                                <div class="panel-body">
                                                    Panel content
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
