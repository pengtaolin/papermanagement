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
                        <span class="title">Grid</span>
                        <div class="description">Bootstrap Grid Systems</div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">
                                        <div class="title">Grid Example</div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div>
                                        <p>See how aspects of the Bootstrap grid system work across multiple devices with a handy table.</p>
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-striped">
                                                <thead>
                                                    <tr>
                                                        <th></th>
                                                        <th>
                                                            Extra small devices
                                                            <small>Phones (&lt;768px)</small>
                                                        </th>
                                                        <th>
                                                            Small devices
                                                            <small>Tablets (â¥768px)</small>
                                                        </th>
                                                        <th>
                                                            Medium devices
                                                            <small>Desktops (â¥992px)</small>
                                                        </th>
                                                        <th>
                                                            Large devices
                                                            <small>Desktops (â¥1200px)</small>
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <th class="text-nowrap" scope="row">Grid behavior</th>
                                                        <td>Horizontal at all times</td>
                                                        <td colspan="3">Collapsed to start, horizontal above breakpoints</td>
                                                    </tr>
                                                    <tr>
                                                        <th class="text-nowrap" scope="row">Container width</th>
                                                        <td>None (auto)</td>
                                                        <td>750px</td>
                                                        <td>970px</td>
                                                        <td>1170px</td>
                                                    </tr>
                                                    <tr>
                                                        <th class="text-nowrap" scope="row">Class prefix</th>
                                                        <td><code>.col-xs-</code></td>
                                                        <td><code>.col-sm-</code></td>
                                                        <td><code>.col-md-</code></td>
                                                        <td><code>.col-lg-</code></td>
                                                    </tr>
                                                    <tr>
                                                        <th class="text-nowrap" scope="row"># of columns</th>
                                                        <td colspan="4">12</td>
                                                    </tr>
                                                    <tr>
                                                        <th class="text-nowrap" scope="row">Column width</th>
                                                        <td class="text-muted">Auto</td>
                                                        <td>~62px</td>
                                                        <td>~81px</td>
                                                        <td>~97px</td>
                                                    </tr>
                                                    <tr>
                                                        <th class="text-nowrap" scope="row">Gutter width</th>
                                                        <td colspan="4">30px (15px on each side of a column)</td>
                                                    </tr>
                                                    <tr>
                                                        <th class="text-nowrap" scope="row">Nestable</th>
                                                        <td colspan="4">Yes</td>
                                                    </tr>
                                                    <tr>
                                                        <th class="text-nowrap" scope="row">Offsets</th>
                                                        <td colspan="4">Yes</td>
                                                    </tr>
                                                    <tr>
                                                        <th class="text-nowrap" scope="row">Column ordering</th>
                                                        <td colspan="4">Yes</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="sub-title">Example </div>
                                    <div>
                                        <!-- Stack the columns on mobile by making one full-width and the other half-width -->
                                        <div class="row example">
                                            <div class="col-xs-12 col-md-8">
                                                <div>.col-xs-12 .col-md-8</div>
                                            </div>
                                            <div class="col-xs-6 col-md-4">
                                                <div>.col-xs-6 .col-md-4</div>
                                            </div>
                                        </div>
                                        <!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
                                        <div class="row example">
                                            <div class="col-xs-6 col-md-4">
                                                <div>.col-xs-6 .col-md-4</div>
                                            </div>
                                            <div class="col-xs-6 col-md-4">
                                                <div>.col-xs-6 .col-md-4</div>
                                            </div>
                                            <div class="col-xs-6 col-md-4">
                                                <div>.col-xs-6 .col-md-4</div>
                                            </div>
                                        </div>
                                        <!-- Columns are always 50% wide, on mobile and desktop -->
                                        <div class="row example">
                                            <div class="col-xs-6">
                                                <div>.col-xs-6</div>
                                            </div>
                                            <div class="col-xs-6">
                                                <div>.col-xs-6</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="sub-title">No Gap between Column <span class="description">( with .no-gap class )</span></div>
                                    <div>
                                        <!-- Stack the columns on mobile by making one full-width and the other half-width -->
                                        <div class="row no-gap example">
                                            <div class="col-xs-12 col-md-8">
                                                <div>.col-xs-12 .col-md-8</div>
                                            </div>
                                            <div class="col-xs-6 col-md-4">
                                                <div>.col-xs-6 .col-md-4</div>
                                            </div>
                                        </div>
                                        <!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
                                        <div class="row no-gap example">
                                            <div class="col-xs-6 col-md-4">
                                                <div>.col-xs-6 .col-md-4</div>
                                            </div>
                                            <div class="col-xs-6 col-md-4">
                                                <div>.col-xs-6 .col-md-4</div>
                                            </div>
                                            <div class="col-xs-6 col-md-4">
                                                <div>.col-xs-6 .col-md-4</div>
                                            </div>
                                        </div>
                                        <!-- Columns are always 50% wide, on mobile and desktop -->
                                        <div class="row no-gap example">
                                            <div class="col-xs-6">
                                                <div>.col-xs-6</div>
                                            </div>
                                            <div class="col-xs-6">
                                                <div>.col-xs-6</div>
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
