<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 公告管理 -->
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
	                        <span class="title">公告添加</span>
	                    </div>
						<div class="row">
						 	<div class="col-xs-12">
								<br>
								<div class="tab-content">
									<div class="tab-pane active in">
										<form id="tab" action="<c:url value="/notice/save.html"/>" method="post" enctype="multipart/form-data">
											<div class="form-group">
												<label>所属栏目</label>
												<select name="columnid" class="form-control">
													<c:forEach items="${allFaceColumn }" var="face">
														<option value="${face.columnid }" <c:if test="${notice.columnid eq face.columnid}">selected</c:if>>${face.columnname }</option>
													</c:forEach>
												</select>
											</div>
												
											<div class="form-group">
												<label>标题</label>
												<input name="noticetitle" type="text" value="${notice.noticetitle }" class="form-control" required>
											</div>
											<div class="card">
												 <div class="card-body no-padding">
				                                    <div role="tabpanel">
				                                        <ul class="nav nav-tabs" role="tablist">
				                                            <li role="内容" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">内容</a></li>
				                                            <li role="文件"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">文件</a></li>
				                                        </ul>
				                                        <!-- Tab panes -->
				                                        <div class="tab-content">
				                                            <div role="tabpanel" class="tab-pane active" id="home">
				                                            	<div class="form-group">
																	<label>内容</label>
													            	<textarea name="noticecontent" cols="100" rows="20" style="width: 100%">
													            		${notice.noticecontent }
																	</textarea>
																</div>
				                                            </div>
				                                            <div role="tabpanel" class="tab-pane" id="profile">
				                                        		<div class="form-group">
																	<label>文件(*.doc,*.docx)</label>	 <label style="color: red">${fileError }</label>
																	<input class="btn btn-success" name="file" value="${notice.fileurl }" type="file" accept=".doc,.docx">
																</div>
				                                        	</div>
				                                        </div>
				                                    </div>
				                                </div>
			                                </div>
											
											<div class="form-group">
												<label>状态</label>
												<select name="noticestate" class="form-control">
													<option value="0" <c:if test="${notice.noticestate eq 0}">selected</c:if>>正常</option>
													<option value="1" <c:if test="${notice.noticestate eq 1}">selected</c:if>>删除</option>
												</select>
											</div>
											
											<div class="btn-toolbar list-toolbar">
												<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
												<a href="<c:url value="/notice/index.html"/>" class="btn btn-primary pull-right"><i class="fa fa-mail-reply"></i> 返回</a>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 底部 -->
				<jsp:include page="/jsp/common/footer.jsp"/>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="<c:url value='/editor/kindeditor.js'/>"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="noticecontent"]', {
				cssPath : '<c:url value="/editor/plugins/code/prettify.css"/>',
				uploadJson : '<c:url value="/editor/jsp/upload_json.jsp"/>',
				fileManagerJson : '<c:url value="/editor/jsp/file_manager_json.jsp"/>',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</html>