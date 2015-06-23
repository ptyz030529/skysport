<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ include file="base/path.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>翊凯-供应链管理系统</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="shortcut icon" href="<%=path%>/resources/images/favicon.ico" type="image/x-icon">
		<meta name="keywords" content="skysport,翊凯" />
		<meta name="description" content="skysport,翊凯" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<jsp:include page="base/headResources.jsp"></jsp:include>
	</head>

	<body  class="no-skin">
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<!-- #section:basics/sidebar.mobile.toggle -->
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							SkySport-供应链管理系统
						</small>
					</a><!-- /.brand -->
				</div>
				<!-- #section:basics/navbar.dropdown -->
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="grey">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-tasks"></i>
								<span class="badge badge-grey">4</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-check"></i>
									4 Tasks to complete
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar">
										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Software Update</span>
													<span class="pull-right">65%</span>
												</div>

												<div class="progress progress-mini">
													<div style="width:65%" class="progress-bar"></div>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Hardware Upgrade</span>
													<span class="pull-right">35%</span>
												</div>

												<div class="progress progress-mini">
													<div style="width:35%" class="progress-bar progress-bar-danger"></div>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Unit Testing</span>
													<span class="pull-right">15%</span>
												</div>

												<div class="progress progress-mini">
													<div style="width:15%" class="progress-bar progress-bar-warning"></div>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Bug Fixes</span>
													<span class="pull-right">90%</span>
												</div>

												<div class="progress progress-mini progress-striped active">
													<div style="width:90%" class="progress-bar progress-bar-success"></div>
												</div>
											</a>
										</li>
									</ul>
								</li>

								<li class="dropdown-footer">
									<a href="#">
										See tasks with details
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span class="badge badge-important">8</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-exclamation-triangle"></i>
									8 Notifications
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar navbar-pink">
										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">
														<i class="btn btn-xs no-hover btn-pink fa fa-comment"></i>
														New Comments
													</span>
													<span class="pull-right badge badge-info">+12</span>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<i class="btn btn-xs btn-primary fa fa-user"></i>
												Bob just signed up as an editor ...
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">
														<i class="btn btn-xs no-hover btn-success fa fa-shopping-cart"></i>
														New Orders
													</span>
													<span class="pull-right badge badge-success">+8</span>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">
														<i class="btn btn-xs no-hover btn-info fa fa-twitter"></i>
														Followers
													</span>
													<span class="pull-right badge badge-info">+11</span>
												</div>
											</a>
										</li>
									</ul>
								</li>

								<li class="dropdown-footer">
									<a href="#">
										See all notifications
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">5</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-envelope-o"></i>
									5 Messages
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar">
										<li>
											<a href="#" class="clearfix">
												<img src="<%=path %>/resources/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" />
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">Alex:</span>
														Ciao sociis natoque penatibus et auctor ...
													</span>

													<span class="msg-time">
														<i class="ace-icon fa fa-clock-o"></i>
														<span>a moment ago</span>
													</span>
												</span>
											</a>
										</li>

										<li>
											<a href="#" class="clearfix">
												<img src="<%=path %>/resources/avatars/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">Susan:</span>
														Vestibulum id ligula porta felis euismod ...
													</span>

													<span class="msg-time">
														<i class="ace-icon fa fa-clock-o"></i>
														<span>20 minutes ago</span>
													</span>
												</span>
											</a>
										</li>

										<li>
											<a href="#" class="clearfix">
												<img src="<%=path %>/resources/avatars/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">Bob:</span>
														Nullam quis risus eget urna mollis ornare ...
													</span>

													<span class="msg-time">
														<i class="ace-icon fa fa-clock-o"></i>
														<span>3:15 pm</span>
													</span>
												</span>
											</a>
										</li>

										<li>
											<a href="#" class="clearfix">
												<img src="<%=path %>/resources/avatars/avatar2.png" class="msg-photo" alt="Kate's Avatar" />
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">Kate:</span>
														Ciao sociis natoque eget urna mollis ornare ...
													</span>

													<span class="msg-time">
														<i class="ace-icon fa fa-clock-o"></i>
														<span>1:33 pm</span>
													</span>
												</span>
											</a>
										</li>

										<li>
											<a href="#" class="clearfix">
												<img src="<%=path %>/resources/avatars/avatar5.png" class="msg-photo" alt="Fred's Avatar" />
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">Fred:</span>
														Vestibulum id penatibus et auctor  ...
													</span>

													<span class="msg-time">
														<i class="ace-icon fa fa-clock-o"></i>
														<span>10:09 am</span>
													</span>
												</span>
											</a>
										</li>
									</ul>
								</li>

								<li class="dropdown-footer">
									<a href="inbox.html">
										See all messages
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<!-- #section:basics/navbar.user_menu -->
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="<%=path %>/resources/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									Jason
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										Settings
									</a>
								</li>

								<li>
									<a href="profile.html">
										<i class="ace-icon fa fa-user"></i>
										Profile
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>

						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>

			</div><!-- /.navbar-header -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

				<div class="sidebar responsive" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="ace-icon fa fa-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="ace-icon fa fa-pencil"></i>
							</button>

							<!-- #section:basics/sidebar.layout.shortcuts -->
							<button class="btn btn-warning">
								<i class="ace-icon fa fa-users"></i>
							</button>

							<button class="btn btn-danger">
								<i class="ace-icon fa fa-cogs"></i>
							</button>

							<!-- /section:basics/sidebar.layout.shortcuts -->
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- /.sidebar-shortcuts -->


					<ul class="nav nav-list">
					    <li class="active">
							<a href="#">
								
								<span class="menu-text"> 市场部 </span>
							</a>
						</li>
						<li>
							<a href="#"  class="dropdown-toggle">
								
								<span class="menu-text"> 开发 </span>
								<b class="arrow fa fa-angle-down"></b>
							</a>
							<ul class="submenu">
								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
											项目
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												项目列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												项目信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												项目新建
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="mobile-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												Default Mobile Menu
											</a>

											<b class="arrow"></b>
										</li>
									</ul>
								</li>
								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										BOM
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												BOM列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												BOM信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												BOM新建
											</a>

											<b class="arrow"></b>
										</li>

									</ul>
								</li>
								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										预成本核算
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												成本核算列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												成本核算信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												成本核算新建
											</a>

											<b class="arrow"></b>
										</li>

									</ul>
								</li>
								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										预报价报价单
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												报价单列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												报价单信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												报价单新建
											</a>

											<b class="arrow"></b>
										</li>
									</ul>
								</li>
								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										预报价客户反馈
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												客户反馈列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												客户反馈信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												客户反馈新建
											</a>

											<b class="arrow"></b>
										</li>


									</ul>
								</li>
								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										面辅料生产通知单
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												面辅料生产通知单列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												面料生产通知单信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
											<i class="menu-icon fa fa-caret-right"></i>
											辅料生产通知单
										</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="mobile-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												成衣厂生产通知单
											</a>
											<b class="arrow"></b>
										</li>
									</ul>
								</li>
								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										色样成本核算
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												成本核算列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												成本核算信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												成本核算新建
											</a>

											<b class="arrow"></b>
										</li>


									</ul>
								</li>
								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										色样报价
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												色样报价列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												色样报价信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												色样报价新建
											</a>

											<b class="arrow"></b>
										</li>

									</ul>
								</li>
								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										色样客户端反馈
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												色样客户端反馈列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												色样客户端反馈信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												色样客户端反馈新建
											</a>

											<b class="arrow"></b>
										</li>


									</ul>
								</li>


								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										开发样
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												开发样列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												开发样信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												开发样新建
											</a>

											<b class="arrow"></b>
										</li>


									</ul>
								</li>



								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										开发样成本核算
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												开发样成本核算列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												开发样成本核算信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												开发样成本核算新建
											</a>

											<b class="arrow"></b>
										</li>


									</ul>
								</li>



								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										开发样报价
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												开发样报价列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												开发样报价信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												开发样报价新建
											</a>

											<b class="arrow"></b>
										</li>


									</ul>
								</li>

								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										正式BOM完善
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="top-menu.html">
												<i class="menu-icon fa fa-caret-right"></i>
												BOM列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												BOM信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												BOM新建
											</a>
											<b class="arrow"></b>
										</li>


									</ul>
								</li>

										<li>
											<a href="javascript:onclick('development/design/list')">
												设计
											</a>
										</li>
										<li>
											<a href="#">
												打样管理
											</a>
										</li>
										<li>
											<a href="javascript:onclick('development/design/wizard.html')">
												开发进度
											</a>
										</li>
										<li>
											<a href="#">
												产品要求清单
											</a>
										</li>
							</ul>			
						</li>
						
						<li>
							<a href="#"  class="dropdown-toggle">
								
								<span class="menu-text"> 品管 </span>
								<b class="arrow fa fa-angle-down"></b>
							</a>
							<ul class="submenu">
										<li>
											<a href="#">
												设计
											</a>
										</li>
										<li>
											<a href="#">
												打样要求
											</a>
										</li>
										<li>
											<a href="#">
												产品要求清单
											</a>
										</li>
							</ul>			
						</li>
						<li>
							<a href="#"  class="dropdown-toggle">
								
								<span class="menu-text"> 财务 </span>
								<b class="arrow fa fa-angle-down"></b>
							</a>
							<ul class="submenu">
										<li>
											<a href="#">
												设计
											</a>
										</li>
										<li>
											<a href="#">
												打样要求
											</a>
										</li>
										<li>
											<a href="#">
												产品要求清单
											</a>
										</li>
							</ul>			
						</li>
						
						<li>
							<a href="#"  class="dropdown-toggle">
								
								<span class="menu-text"> 管理部 </span>
								<b class="arrow fa fa-angle-down"></b>
							</a>
							<ul class="submenu">
										<li>
											<a href="#">
												目标管理
											</a>
										</li>
										<li>
											<a href="#">
												文件管理
											</a>
										</li>
										<li>
											<a href="#">
												人事管理
											</a>
										</li>
										<li>
											<a href="#">
												行政管理
											</a>
										</li>
										<li>
											<a href="#">
												财务管理
											</a>
										</li>
										<li>
											<a href="#">
												供应商管理
											</a>
										</li>
										<li>
											<a href="#">
												客户管理
											</a>
										</li>
										<li>
											<a href="#">
												仓库管理
											</a>
										</li>
										<li>
											<a href="#">
												销售管理
											</a>
										</li>										
							</ul>			
						</li>
						<li>
							<a href="#"  class="dropdown-toggle">
								
								<span class="menu-text"> 采购部</span>
								<b class="arrow fa fa-angle-down"></b>
							</a>
							<ul class="submenu">
										<li>
											<a href="#">
												设计
											</a>
										</li>
										<li>
											<a href="#">
												打样要求
											</a>
										</li>
										<li>
											<a href="#">
												产品要求清单
											</a>
										</li>
							</ul>			
						</li>
						<li>
							<a href="#"  class="dropdown-toggle">
								
								<span class="menu-text"> 客户接口 </span>
								<b class="arrow fa fa-angle-down"></b>
							</a>
							<ul class="submenu">
										<li>
											<a href="#">
												设计
											</a>
										</li>
										<li>
											<a href="#">
												打样要求
											</a>
										</li>
										<li>
											<a href="#">
												产品要求清单
											</a>
										</li>
							</ul>			
						</li>
						<li>
							<a href="#"  class="dropdown-toggle">
								
								<span class="menu-text"> 供应商接口 </span>
								<b class="arrow fa fa-angle-down"></b>
							</a>
							<ul class="submenu">
										<li>
											<a href="#">
												设计
											</a>
										</li>
										<li>
											<a href="#">
												打样要求
											</a>
										</li>
										<li>
											<a href="#">
												产品要求清单
											</a>
										</li>
							</ul>			
						</li>
						<li>
							<a href="#"  class="dropdown-toggle">
								
								<span class="menu-text"> 运营 </span>
								<b class="arrow fa fa-angle-down"></b>
							</a>
							<ul class="submenu">
										<li>
											<a href="#">
												设计
											</a>
										</li>
										<li>
											<a href="#">
												打样要求
											</a>
										</li>
										<li>
											<a href="#">
												产品要求清单
											</a>
										</li>
							</ul>			
						</li>
						<li>
							<a href="javascript:onclick('<%=path%>/system/sp/list')"  class="dropdown-toggle">
								
								<span class="menu-text"> 系统管理 </span>
								<b class="arrow fa fa-angle-down"></b>
							</a>
							<ul class="submenu">

								<li class="">
									<a href="#" class="dropdown-toggle">
										<i class="menu-icon fa fa-caret-right"></i>
										物料管理
										<b class="arrow fa fa-angle-down"></b>
									</a>

									<b class="arrow"></b>

									<ul class="submenu">
										<li class="">
											<a href="javascript:onclick('system/material/list')">
												<i class="menu-icon fa fa-caret-right"></i>
												物料列表
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-1.html">
												<i class="menu-icon fa fa-caret-right"></i>
												物料信息
											</a>

											<b class="arrow"></b>
										</li>

										<li class="">
											<a href="two-menu-2.html">
												<i class="menu-icon fa fa-caret-right"></i>
												物料新建
											</a>
											<b class="arrow"></b>
										</li>

									</ul>
								</li>
										<li>
											<a href="javascript:onclick('system/sp/list')">
												供应商信息
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/factory/list')">
												成衣厂
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/customer/list')">
												客户信息
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/area/list')">
												区域信息
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/series/list')">
												系列信息
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/pantone/list')">
												PANTONE
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/product_kind/list')">
												品类级别
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/sex/list')">
												性别属性
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/material_type/list')">
												材料类别
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/material_classic/list')">
												材质分类
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/product_type/list')">
												品名信息
											</a>
										</li>
										<li>
											<a href="javascript:onclick('system/sp_kind/list')">
												主颜色
											</a>
										</li>
									<%--	<li>
											<a href="javascript:onclick('system/year_conf/list')">
												年份管理
											</a>
										</li>
--%>

										<li>
											<a href="#<%--javascript:onclick('system/time_conf/list')--%>">
												时间节点
											</a>
										</li>

										
							</ul>			
							
						</li>
						<li>
							<a href="#"  class="dropdown-toggle">
								
								<span class="menu-text"> 其他管理 </span>
								<b class="arrow fa fa-angle-down"></b>
							</a>
							<ul class="submenu">
										<li>
											<a href="#">
												用户信息
											</a>
										</li>
										<li>
											<a href="#">
												权限分配
											</a>
										</li>
										<li>
											<a href="#">
												收件箱
											</a>
										</li>
										<li>
											<a href="#">
												改密码
											</a>
										</li>
										<li>
											<a href="#">
												登陆 & 注册 
											</a>
										</li>
										
							</ul>			
							
						</li>
					</ul><!-- /.nav-list -->

					<!-- #section:basics/sidebar.layout.minimize -->
					<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
						<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
					</div>

					<!-- /section:basics/sidebar.layout.minimize -->
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>
				<div class="main-content">
					<iframe  id="mainIframe" src="pages/content.jsp"  width="100%"    onLoad="iFrameHeight()"></iframe>
				</div><!-- /.main-content -->

			    <jsp:include page="base/foot.jsp"></jsp:include>

		</div><!-- /.main-container -->

		<!-- basic scripts -->

	
 		<jsp:include page="base/footResources.jsp"></jsp:include>

		<script type="text/javascript">

		</script>
		<script type="text/javascript" language="javascript">
			function onclick(frameSrc){
				$('iframe').attr("src", frameSrc);
			}
			function iFrameHeight() { 
				$("#mainIframe").height($(window.frames["mainIframe"]).contents().height());
			} 
		</script>
</body>
</html>

