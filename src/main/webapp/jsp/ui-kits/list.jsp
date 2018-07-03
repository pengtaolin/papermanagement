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
                        <span class="title">List</span>
                        <div class="description">A list-group elements.</div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">
                                        <div class="title">List</div>
                                    </div>
                                    <div class="pull-right card-action">
                                        <div class="btn-group" role="group">
                                            <button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalListExample"><i class="fa fa-code"></i></button>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div>
                                        <ul class="list-group">
                                            <li class="list-group-item">Cras justo odio</li>
                                            <li class="list-group-item">Dapibus ac facilisis in</li>
                                            <li class="list-group-item">Morbi leo risus</li>
                                            <li class="list-group-item">Porta ac consectetur ac</li>
                                            <li class="list-group-item">Vestibulum at eros</li>
                                        </ul>
                                    </div>
                                    <div class="sub-title">With Badges</div>
                                    <div>
                                        <ul class="list-group">
                                            <li class="list-group-item">
                                                <span class="badge">14</span> Cras justo odio
                                            </li>
                                            <li class="list-group-item">
                                                <span class="badge">1</span> Morbi leo risus
                                            </li>
                                            <li class="list-group-item">
                                                <span class="badge">2</span> Vestibulum at eros
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="sub-title">Using Link</div>
                                    <div>
                                        <div class="list-group">
                                            <a href="#" class="list-group-item">
                                                <span class="badge">14</span> Cras justo odio
                                            </a>
                                            <a href="#" class="list-group-item">
                                                <span class="badge">1</span> Morbi leo risus
                                            </a>
                                            <a href="#" class="list-group-item">
                                                <span class="badge">2</span> Vestibulum at eros
                                            </a>
                                        </div>
                                    </div>

                                    <div class="sub-title">Active Items</div>
                                    <div>
                                        <ul class="list-group">
                                            <li class="list-group-item active">
                                                <span class="badge">14</span> Cras justo odio
                                            </li>
                                            <li class="list-group-item">
                                                <span class="badge">1</span> Morbi leo risus
                                            </li>
                                            <li class="list-group-item">
                                                <span class="badge">2</span> Vestibulum at eros
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="sub-title">Disabled Items</div>
                                    <div>
                                        <ul class="list-group">
                                            <li class="list-group-item">
                                                <span class="badge">14</span> Cras justo odio
                                            </li>
                                            <li class="list-group-item disabled">
                                                <span class="badge">1</span> Morbi leo risus
                                            </li>
                                            <li class="list-group-item">
                                                <span class="badge">2</span> Vestibulum at eros
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="sub-title">Contextual classes</div>
                                    <div>
                                        <ul class="list-group">
                                            <li class="list-group-item list-group-item-success">
                                                <span class="badge">14</span> Cras justo odio
                                            </li>
                                            <li class="list-group-item list-group-item-info">
                                                <span class="badge">1</span> Morbi leo risus
                                            </li>
                                            <li class="list-group-item list-group-item-warning">
                                                <span class="badge">2</span> Vestibulum at eros
                                            </li>
                                            <li class="list-group-item list-group-item-danger">
                                                <span class="badge">0</span> Porta ac consectetur ac
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="modalListExample" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel">List Example</h4>
                                </div>
                                <div class="modal-body no-padding">
                                    <div id="code-preview-list" class="code-preview">&lt;ul class=&quot;list-group&quot;&gt;
    &lt;li class=&quot;list-group-item&quot;&gt;Cras justo odio&lt;/li&gt;
    &lt;li class=&quot;list-group-item&quot;&gt;Dapibus ac facilisis in&lt;/li&gt;
    &lt;li class=&quot;list-group-item&quot;&gt;Morbi leo risus&lt;/li&gt;
    &lt;li class=&quot;list-group-item&quot;&gt;Porta ac consectetur ac&lt;/li&gt;
    &lt;li class=&quot;list-group-item&quot;&gt;Vestibulum at eros&lt;/li&gt;
&lt;/ul&gt;</div>
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
