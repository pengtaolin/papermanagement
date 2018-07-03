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
	                                                <th>开始时间</th>
	                                                <th>结束时间</th>
	                                                <th>修改意见</th>
	                                                <th>状态</th>
	                                                <th>操作</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${progressList }" var="progress" varStatus="i">
	                                        		<tr>
		                                                <th scope="row">${i.index+1 }</th>
		                                                <td>${progress.progressname }</td>
		                                                <td>
		                                                	<fmt:formatDate value="${progress.starttime }" pattern="yyyy-MM-dd"/>
		                                                </td>
		                                                <td>
		                                                	<fmt:formatDate value="${progress.endtime }" pattern="yyyy-MM-dd"/>
		                                                </td>
		                                                <td>
		                                                	<a data-toggle="modal" data-target="#modalCardProfileExample${i.index }">意见详情</a>
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
		                                                	<c:if test="${progress.progressstate eq 0}">
																<a href="/progress/stu/up/${progress.progressid }.html">提交</a>
															</c:if>
		                                                	<c:if test="${progress.progressstate eq 1}">审核中</c:if>
		                                                	<c:if test="${progress.progressstate eq 2}">已通过</c:if>
		                                                	<c:if test="${progress.progressstate eq 3}">
		                                                		<a href="/progress/stu/up/${progress.progressid }.html">重新提交</a>
		                                                	</c:if>
	                                                	</td>
		                                                <td>
		                                                	<c:if test="${not empty progress.paperid}">
		                                                		<a href="/paper/download/${progress.progressid }.html">下载</a>
		                                                	</c:if>
		                                                	<c:if test="${progress.progressstate ne 2 && progress.progressstate ne 1}">
	                                                			<a data-toggle="modal" data-target="#modalCardProfileExample">上传</a>
		                                                	</c:if>
														</td>
		                                            </tr>
	                                        	</c:forEach>
	                                        </tbody>
	                                    </table>
	                                    <div class="modal fade" id="modalCardProfileExample" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					                        <div class="modal-dialog modal-lg">
					                            <div class="modal-content">
					                                <div class="modal-header">
					                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					                                    <h4 class="modal-title" id="myModalLabel">上传论文</h4>
					                                </div>
					                                <div class="modal-body ">
					                                	<!-- 上传列表 -->
					                                    <form id="tab" action="<c:url value="/paper/stu/upload.html"/>" method="post" enctype="multipart/form-data">
																
															<div class="form-group">
																<label>标题</label>
																<input id="filename" name="papername" type="text" class="form-control" required>
															</div>
															<div class="form-group">
																<label>文件(*.doc,*.docx,*.zip,*.rar)</label>	 <label style="color: red">${fileError }</label>
																<input class="btn btn-success" name="file" id="fileid" onchange="getfilename();" type="file" accept=".doc,.docx,.zip,.rar">
															</div>
															
															<div class="btn-toolbar list-toolbar">
																<button type="submit" class="btn btn-primary pull-right"><i class="fa fa-save"></i> 上传</button>
															</div>
														</form>
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
