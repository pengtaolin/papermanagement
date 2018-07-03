<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!-- 进度管理 -->
<html>
	<script>
		//同步文件输入默认名
		function getfilename(){
		   var file = $("#fileid").val();
		   var pos=file.lastIndexOf("\\");
		   //alert(file.substring(pos+1));
		  /* 方法二：正则表达式*/
		  var strFileName=file.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1");  //正则表达式获取文件名，不带后缀
		  $("#filename").val(strFileName);
		  //var FileExt=file.replace(/.+\./,"");   //正则表达式获取后缀 
		}
	</script>
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
	                        <span class="title">进度管理</span>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-12">
	                            <div class="card">
	                                <div class="card-body">
	                                    <table class="table table-hover">
	                                        <thead>
	                                            <tr>
	                                                <th>序号</th>
	                                                <th>进度名称</th>
	                                                <th>学生</th>
	                                                <th>审核意见</th>
	                                                <th>文档操作</th>
	                                                <th>控制操作</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${progressList }" var="progress" varStatus="i">
	                                        		<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td>${progress.progressname }</td>
		                                                <td>${progress.userid }</td>
		                                                <td>
		                                                	<a data-toggle="modal" data-target="#modalCardProfileExample${i.index }">意见详情</a>
		                                                	<!-- 意见弹窗 -->
		                                                	<div class="modal fade" id="modalCardProfileExample${i.index }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										                        <div class="modal-dialog modal-lg">
										                            <div class="modal-content">
										                                <div class="modal-header">
										                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										                                    <h4 class="modal-title" id="myModalLabel">意见详情</h4>
										                                </div>
										                                <div class="modal-body">
																			<div class="form-group">
																				<textarea class="form-control">${progress.advice }</textarea>
																			</div>
										                                </div>
										                            </div>
										                        </div>
										                    </div>
		                                                </td>
		                                                <td>
		                                                	<c:if test="${not empty progress.paperid}">
		                                                		<a href="/paper/download/${progress.progressid }.html">下载</a>
		                                                	</c:if>
		                                                	<c:if test="${empty progress.paperid}">
		                                                		未上传
		                                                	</c:if>
		                                                	&nbsp;
		                                                	<c:if test="${not empty progress.advice}">
		                                                		<a data-toggle="modal" data-target="#modalCardProfileExampled${i.index }">重改</a>
		                                                	</c:if>
		                                                	<c:if test="${empty progress.advice}">
		                                                		<a data-toggle="modal" data-target="#modalCardProfileExampled${i.index }">批改</a>
		                                                	</c:if>
		                                                	<!-- 批改弹窗 -->
		                                                	<div class="modal fade" id="modalCardProfileExampled${i.index }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										                        <div class="modal-dialog modal-lg">
										                            <div class="modal-content">
										                                <div class="modal-header">
										                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										                                    <h4 class="modal-title" id="myModalLabel">批改论文</h4>
										                                </div>
										                                <div class="modal-body ">
										                                	<!-- 上传列表 -->
										                                    <form id="tab" action="<c:url value="/progress/teach/advice/${progress.progressid}.html"/>" method="post">
																				<div class="form-group">
																					<label>意见</label>
																					<textarea name="advice" class="form-control" required></textarea>
																				</div>
																				
																				<div class="btn-toolbar list-toolbar">
																					<button type="submit" class="btn btn-primary pull-right"><i class="fa fa-save"></i> 确定</button>
																				</div>
																			</form>
										                                </div>
										                            </div>
										                        </div>
										                    </div>
										                    &nbsp;
										                    <a data-toggle="modal" data-target="#modalCardProfileExampleup${i.index }">上传</a>
										                    <!-- 上传弹窗 -->
		                                                	<div class="modal fade" id="modalCardProfileExampleup${i.index }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										                        <div class="modal-dialog modal-lg">
										                            <div class="modal-content">
										                                <div class="modal-header">
										                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										                                    <h4 class="modal-title" id="myModalLabel">上传${progress.userid }的${progress.progressname }修改之后的文档</h4>
										                                </div>
										                                <div class="modal-body ">
										                                	<!-- 上传列表 -->
										                                    <form id="tab" action="<c:url value="/paper/teach/upload.html"/>" method="post" enctype="multipart/form-data">
																				<div class="form-group">
																					<label>标题</label>
																					<input id="filename" name="papername" type="text" class="form-control" required>
																					<input name="paperid" type="hidden" value="${progress.progressid }">
																				</div>
																				<div class="form-group">
																					<label>文件(*.doc,*.docx,*.zip,*.rar)</label>	 <label style="color: red">${fileError }</label>
																					<input class="btn btn-success" name="file" id="fileid" id="fileid" onchange="getfilename();" type="file" accept=".doc,.docx,.zip,.rar">
																				</div>
																				
																				<div class="btn-toolbar list-toolbar">
																					<button type="submit" class="btn btn-primary pull-right"><i class="fa fa-save"></i> 上传</button>
																				</div>
																			</form>
										                                </div>
										                            </div>
										                        </div>
										                	</div>
														</td>
		                                                <td>
															<a href="/progress/teach/pass/${progress.progressid }.html">通过</a>
															&nbsp;
															<a href="/progress/teach/nopass/${progress.progressid }.html">不通过</a>
														</td>
		                                            </tr>
	                                        	</c:forEach>
	                                        </tbody>
	                                    </table>
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
