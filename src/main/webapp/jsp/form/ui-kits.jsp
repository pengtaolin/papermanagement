<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp" %>
<!DOCTYPE html>
<!--用户界面组件-->
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
							<span class="title">Form UI Kits</span>
							<div class="description">A ui elements use in form, input, select, etc.</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">
											<div class="title">Form Elements</div>
										</div>
									</div>
									<div class="card-body">
										Examples of standard form controls. such as input, textarea, select, checkboxes and radios , static control, etc.
										<div class="sub-title">Input</div>
										<div>
											<input type="text" class="form-control" placeholder="Text input">
										</div>
										<div class="sub-title">Textarea</div>
										<div>
											<textarea class="form-control" rows="3"></textarea>
										</div>
										<div class="sub-title">Checkboxes and radios <span class="description">( with <a href="https://github.com/tui2tone/checkbox3">checkbox3</a> )</span></div>
										<div>
											<div class="checkbox3 checkbox-round">
												<input type="checkbox" id="checkbox-2">
												<label for="checkbox-2">
                                            Option one is this and that&mdash;be sure to include why it's great
                                          </label>
											</div>
											<div class="checkbox3 checkbox-round">
												<input type="checkbox" id="checkbox-3" disabled="">
												<label for="checkbox-3">
                                            Option two is disabled
                                          </label>
											</div>
											<div class="radio3">
												<input type="radio" id="radio1" name="radio1" value="option1">
												<label for="radio1">
                                            Option one is this and that&mdash;be sure to include why it's great
                                          </label>
											</div>
											<div class="radio3">
												<input type="radio" id="radio2" name="radio1" value="option2">
												<label for="radio2">
                                            Option two can be something else and selecting it will deselect option one
                                          </label>
											</div>
											<div class="sub-title">Inline</div>
											<div>
												<div class="checkbox3 checkbox-inline checkbox-check checkbox-light">
													<input type="checkbox" id="checkbox-fa-light-1" checked="">
													<label for="checkbox-fa-light-1">
                                              Option1
                                            </label>
												</div>
												<div class="checkbox3 checkbox-success checkbox-inline checkbox-check checkbox-round  checkbox-light">
													<input type="checkbox" id="checkbox-fa-light-2" checked="">
													<label for="checkbox-fa-light-2">
                                              Option Round
                                            </label>
												</div>
												<div class="checkbox3 checkbox-danger checkbox-inline checkbox-check  checkbox-circle checkbox-light">
													<input type="checkbox" id="checkbox-fa-light-3" checked="">
													<label for="checkbox-fa-light-3">
                                              Option Circle
                                            </label>
												</div>
											</div>
											<div>
												<div class="radio3 radio-check radio-inline">
													<input type="radio" id="radio4" name="radio2" value="option1" checked="">
													<label for="radio4">
                                              Option 1
                                            </label>
												</div>
												<div class="radio3 radio-check radio-success radio-inline">
													<input type="radio" id="radio5" name="radio2" value="option2">
													<label for="radio5">
                                              Option 2
                                            </label>
												</div>
												<div class="radio3 radio-check radio-warning radio-inline">
													<input type="radio" id="radio6" name="radio2" value="option3">
													<label for="radio6">
                                              Option 3
                                            </label>
												</div>
											</div>
										</div>
										<div class="sub-title">Toggle <span class="description">( with <a href="https://github.com/nostalgiaz/bootstrap-switch">bootstrap-switch</a> )</span></div>
										<div>
											<input type="checkbox" class="toggle-checkbox" name="my-checkbox" checked>
										</div>
										<div class="sub-title">Select <span class="description">( with <a href="https://select2.github.io/">select2</a> )</span></div>
										<div>
											<select>
												<optgroup label="Alaskan/Hawaiian Time Zone">
													<option value="AK">Alaska</option>
													<option value="HI">Hawaii</option>
												</optgroup>
												<optgroup label="Pacific Time Zone">
													<option value="CA">California</option>
													<option value="NV">Nevada</option>
													<option value="OR">Oregon</option>
													<option value="WA">Washington</option>
												</optgroup>
												<optgroup label="Mountain Time Zone">
													<option value="AZ">Arizona</option>
													<option value="CO">Colorado</option>
													<option value="ID">Idaho</option>
													<option value="MT">Montana</option>
													<option value="NE">Nebraska</option>
													<option value="NM">New Mexico</option>
													<option value="ND">North Dakota</option>
													<option value="UT">Utah</option>
													<option value="WY">Wyoming</option>
												</optgroup>
												<optgroup label="Central Time Zone">
													<option value="AL">Alabama</option>
													<option value="AR">Arkansas</option>
													<option value="IL">Illinois</option>
													<option value="IA">Iowa</option>
													<option value="KS">Kansas</option>
													<option value="KY">Kentucky</option>
													<option value="LA">Louisiana</option>
													<option value="MN">Minnesota</option>
													<option value="MS">Mississippi</option>
													<option value="MO">Missouri</option>
													<option value="OK">Oklahoma</option>
													<option value="SD">South Dakota</option>
													<option value="TX">Texas</option>
													<option value="TN">Tennessee</option>
													<option value="WI">Wisconsin</option>
												</optgroup>
												<optgroup label="Eastern Time Zone">
													<option value="CT">Connecticut</option>
													<option value="DE">Delaware</option>
													<option value="FL">Florida</option>
													<option value="GA">Georgia</option>
													<option value="IN">Indiana</option>
													<option value="ME">Maine</option>
													<option value="MD">Maryland</option>
													<option value="MA">Massachusetts</option>
													<option value="MI">Michigan</option>
													<option value="NH">New Hampshire</option>
													<option value="NJ">New Jersey</option>
													<option value="NY">New York</option>
													<option value="NC">North Carolina</option>
													<option value="OH">Ohio</option>
													<option value="PA">Pennsylvania</option>
													<option value="RI">Rhode Island</option>
													<option value="SC">South Carolina</option>
													<option value="VT">Vermont</option>
													<option value="VA">Virginia</option>
													<option value="WV">West Virginia</option>
												</optgroup>
											</select>
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
											<div class="title">Basic example</div>
										</div>
									</div>
									<div class="card-body">
										<form>
											<div class="form-group">
												<label for="exampleInputEmail1">Email address</label>
												<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
											</div>
											<div class="form-group">
												<label for="exampleInputPassword1">Password</label>
												<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
											</div>
											<div class="form-group">
												<label for="exampleInputFile">File input</label>
												<input type="file" id="exampleInputFile">
												<p class="help-block">Example block-level help text here.</p>
											</div>
											<div class="checkbox">
												<div class="checkbox3 checkbox-round">
													<input type="checkbox" id="checkbox-1">
													<label for="checkbox-1">
                                              Check me out
                                            </label>
												</div>
											</div>
											<button type="submit" class="btn btn-default">Submit</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">
											<div class="title">Inline form</div>
										</div>
									</div>
									<div class="card-body">
										<form class="form-inline">
											<div class="form-group">
												<label for="exampleInputName2">Name</label>
												<input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
											</div>
											<div class="form-group">
												<label for="exampleInputEmail2">Email</label>
												<input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
											</div>
											<button type="submit" class="btn btn-default">Send invitation</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">
											<div class="title">Horizontal form</div>
										</div>
									</div>
									<div class="card-body">
										<form class="form-horizontal">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
												<div class="col-sm-10">
													<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
												</div>
											</div>
											<div class="form-group">
												<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
												<div class="col-sm-10">
													<input type="password" class="form-control" id="inputPassword3" placeholder="Password">
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-offset-2 col-sm-10">
													<div class="checkbox3 checkbox-round checkbox-check checkbox-light">
														<input type="checkbox" id="checkbox-10">
														<label for="checkbox-10">
                                                  Remember me
                                                </label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-offset-2 col-sm-10">
													<button type="submit" class="btn btn-default">Sign in</button>
												</div>
											</div>
										</form>
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