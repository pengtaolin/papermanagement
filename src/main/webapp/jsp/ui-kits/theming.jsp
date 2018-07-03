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
                        <span class="title">Theming</span>
                        <div class="description">Color Scheme and Theme Layout Configuration</div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">
                                        <div class="title">Theming</div>
                                    </div>
                                </div>
                                <div class="card-body">
                                  <p>Choose your navbar and sidebar color pattern. Default or Inverse Color.</p>
                                  <div class="sub-title">Navbar</div>
                                  <div>
                                    <div class="radio3 radio-check radio-inline">
                                      <input type="radio" id="radio1" name="radio-navbar" value="default" checked="">
                                      <label for="radio1">
                                        Default
                                      </label>
                                    </div>
                                    <div class="radio3 radio-check radio-inline">
                                      <input type="radio" id="radio2" name="radio-navbar" value="inverse">
                                      <label for="radio2">
                                        Inverse
                                      </label>
                                    </div>
                                  </div>
                                  <div class="sub-title">Sidebar</div>
                                  <div>
                                    <div class="radio3 radio-check radio-inline">
                                      <input type="radio" id="radio3" name="radio-sidebar" value="default">
                                      <label for="radio3">
                                        Default
                                      </label>
                                    </div>
                                    <div class="radio3 radio-check radio-inline">
                                      <input type="radio" id="radio4" name="radio-sidebar" value="inverse" checked="">
                                      <label for="radio4">
                                        Inverse
                                      </label>
                                    </div>
                                  </div>
                                  <div class="sub-title">Color Scheme</div>
                                  <div>
                                    <div class="radio3 radio-check radio-inline">
                                      <input type="radio" id="radio-blue" name="radio-color" value="blue" checked="">
                                      <label for="radio-blue">
                                        Blue (Default)
                                      </label>
                                    </div>
                                    <div class="radio3 radio-check radio-success radio-inline">
                                      <input type="radio" id="radio-green" name="radio-color" value="green">
                                      <label for="radio-green">
                                        Green
                                      </label>
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
