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
	                        <span class="title">Alert</span>
	                        <div class="description">A element for notification to user action. alert, etc.</div>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-header">
	                                    <div class="card-title">
	                                        <div class="title">Alert</div>
	                                    </div>
	                                    <div class="pull-right card-action">
	                                        <div class="btn-group" role="group">
	                                            <button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalAlertExample"><i class="fa fa-code"></i></button>
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="card-body">
	                                    <div>Alert has 2 type of color. Default & Fresh color that has background color with white font color.</div>
	                                    <div class="row">
	                                        <div class="col-sm-6">
	                                            <div class="sub-title">Default Alert</div>
	                                            <div>
	                                                <div class="alert alert-success" role="alert">
	                                                    <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message.</a>
	                                                </div>
	                                                <div class="alert alert-info" role="alert">
	                                                    <strong>Heads up!</strong> This alert needs your attention, but it's not super important.
	                                                </div>
	                                                <div class="alert alert-warning" role="alert">
	                                                    <strong>Warning!</strong> Better check yourself, you're not looking too good.
	                                                </div>
	                                                <div class="alert alert-danger" role="alert">
	                                                    <strong>Oh snap!</strong> Change a few things up and try submitting again.
	                                                </div>
	                                            </div>
	                                            <div class="sub-title">With Close</div>
	                                            <div>
	                                                <div class="alert alert-warning alert-dismissible" role="alert">
	                                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                                                    <strong>Warning!</strong> Better check yourself, you're not looking too good.
	                                                </div>
	                                            </div>
	                                            <div class="sub-title">Alert Message</div>
	                                            <div>
	                                                <div class="alert alert-danger alert-dismissible fade in" role="alert">
	                                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">Ã</span></button>
	                                                    <h4 id="oh-snap!-you-got-an-error!">Oh snap! You got an error!<a class="anchorjs-link" href="#oh-snap!-you-got-an-error!"><span class="anchorjs-icon"></span></a></h4>
	                                                    <p>Change this and that and try again. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.</p>
	                                                    <p>
	                                                        <button type="button" class="btn btn-danger">Take this action</button>
	                                                        <button type="button" class="btn btn-link">Or do this</button>
	                                                    </p>
	                                                </div>
	                                            </div>
	                                        </div>
	                                        <div class="col-sm-6">
	                                            <div class="sub-title">Fresh Color Alert <span class="description">( with <code>.fresh-color</code> class )</span></div>
	                                            <div>
	                                                <div class="alert fresh-color alert-success" role="alert">
	                                                    <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message.</a>
	                                                </div>
	                                                <div class="alert fresh-color alert-info" role="alert">
	                                                    <strong>Heads up!</strong> This alert needs your attention, but it's not super important.
	                                                </div>
	                                                <div class="alert fresh-color alert-warning" role="alert">
	                                                    <strong>Warning!</strong> Better check yourself, you're not looking too good.
	                                                </div>
	                                                <div class="alert fresh-color alert-danger" role="alert">
	                                                    <strong>Oh snap!</strong> Change a few things up and try submitting again.
	                                                </div>
	                                            </div>
	                                            <div class="sub-title">With Close</div>
	                                            <div>
	                                                <div class="alert fresh-color alert-warning alert-dismissible" role="alert">
	                                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                                                    <strong>Warning!</strong> Better check yourself, you're not looking too good.
	                                                </div>
	                                            </div>
	                                            <div class="sub-title">Alert Message</div>
	                                            <div>
	                                                <div class="alert fresh-color alert-danger alert-dismissible fade in" role="alert">
	                                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">Ã</span></button>
	                                                    <h4 id="oh-snap!-you-got-an-error!">Oh snap! You got an error!<a class="anchorjs-link" href="#oh-snap!-you-got-an-error!"><span class="anchorjs-icon"></span></a></h4>
	                                                    <p>Change this and that and try again. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.</p>
	                                                    <p>
	                                                        <button type="button" class="btn btn-default">Take this action</button>
	                                                        <button type="button" class="btn btn-link">Or do this</button>
	                                                    </p>
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="modal fade" id="modalAlertExample" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                        <div class="modal-dialog modal-lg">
	                            <div class="modal-content">
	                                <div class="modal-header">
	                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                                    <h4 class="modal-title" id="myModalLabel">Alert Example</h4>
	                                </div>
	                                <div class="modal-body no-padding">
	                                    <div id="code-preview-alert" class="code-preview">&lt;div class=&quot;alert alert-success&quot; role=&quot;alert&quot;&gt;
	    &lt;strong&gt;Well done!&lt;/strong&gt; You successfully read &lt;a href=&quot;#&quot; class=&quot;alert-link&quot;&gt;this important alert message.&lt;/a&gt;
	&lt;/div&gt;
	&lt;div class=&quot;alert alert-info&quot; role=&quot;alert&quot;&gt;
	    &lt;strong&gt;Heads up!&lt;/strong&gt; This alert needs your attention, but it's not super important.
	&lt;/div&gt;
	&lt;div class=&quot;alert alert-warning&quot; role=&quot;alert&quot;&gt;
	    &lt;strong&gt;Warning!&lt;/strong&gt; Better check yourself, you're not looking too good.
	&lt;/div&gt;
	&lt;div class=&quot;alert alert-danger&quot; role=&quot;alert&quot;&gt;
	    &lt;strong&gt;Oh snap!&lt;/strong&gt; Change a few things up and try submitting again.
	&lt;/div&gt;
	
	&lt;!-- With Close --&gt;
	
	&lt;div class=&quot;alert alert-warning alert-dismissible&quot; role=&quot;alert&quot;&gt;
	    &lt;button type=&quot;button&quot; class=&quot;close&quot; data-dismiss=&quot;alert&quot; aria-label=&quot;Close&quot;&gt;&lt;span aria-hidden=&quot;true&quot;&gt;&amp;times;&lt;/span&gt;&lt;/button&gt;
	    &lt;strong&gt;Warning!&lt;/strong&gt; Better check yourself, you're not looking too good.
	&lt;/div&gt;
	
	&lt;!-- Alert Message --&gt;
	
	&lt;div class=&quot;alert alert-danger alert-dismissible fade in&quot; role=&quot;alert&quot;&gt;
	    &lt;button type=&quot;button&quot; class=&quot;close&quot; data-dismiss=&quot;alert&quot; aria-label=&quot;Close&quot;&gt;&lt;span aria-hidden=&quot;true&quot;&gt;&times;&lt;/span&gt;&lt;/button&gt;
	    &lt;h4 id=&quot;oh-snap!-you-got-an-error!&quot;&gt;Oh snap! You got an error!&lt;a class=&quot;anchorjs-link&quot; href=&quot;#oh-snap!-you-got-an-error!&quot;&gt;&lt;span class=&quot;anchorjs-icon&quot;&gt;&lt;/span&gt;&lt;/a&gt;&lt;/h4&gt;
	    &lt;p&gt;Change this and that and try again. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.&lt;/p&gt;
	    &lt;p&gt;
	        &lt;button type=&quot;button&quot; class=&quot;btn btn-danger&quot;&gt;Take this action&lt;/button&gt;
	        &lt;button type=&quot;button&quot; class=&quot;btn btn-link&quot;&gt;Or do this&lt;/button&gt;
	    &lt;/p&gt;
	&lt;/div&gt;</div>
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
