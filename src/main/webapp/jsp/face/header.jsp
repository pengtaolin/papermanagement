<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- 导航栏 -->
<nav class="navbar navbar-inverse navbar-fixed-top  navbar-affix" role="navigation" data-spy="affix" data-offset-top="60">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- 网站名称 -->
            <a class="navbar-brand" href="#">
                <div class="icon fa fa-paper-plane"></div>
                <div class="title">论文管理系统</div>
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse " aria-expanded="true">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="<c:url value="/index.html"/>">首页</a></li>
                <c:forEach items="${applicationScope.faceColumns }" var="fc">
                	<li>
                		<c:if test="${fc.url eq ''}">
                			<a href="<c:url value='/column/show/${fc.columnid }-1.html'/>">${fc.columnname }</a>
                		</c:if>
                		<c:if test="${fc.url ne ''}">
                			<a href="${fc.url }">${fc.columnname }</a>
                		</c:if>
                	</li>
                </c:forEach>
                <li><a href="<c:url value='/login.html'/>">登录</a></li>
	            <li class="pull-right">
	            	<form method="get" class="form-inline" action="/notice/search.html" style="margin:12px 0;">
					 	<input type="text" class="form-control" placeholder="请输入关键字" name="kw" value="" style="border:none">
					 	<input type="submit" class="btn pull-right" value="搜索" style="margin:0">
					</form>
	            </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>

<div class="jumbotron app-header">
	<div class="container">
	    <h2 class="text-center">
	    	<i class="app-logo fa fa-university fa-5x color-white"></i>
	    	<div class="color-white">赣南师范大学科技学院</div>
	    </h2>
	</div>
</div>

