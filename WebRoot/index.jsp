<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">

<title>君健航空</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="<%=path %>/css/index.css" type="text/css">
<link href="<%=path %>/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path %>/H-ui/static/h-ui/css/H-ui.css" type="text/css">
<link rel="stylesheet" href="<%=path %>/css/head.css" type="text/css">

<script type="text/javascript" src="<%=path %>/H-ui/lib/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/H-ui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=path %>/js/index.js"></script>
<script type="text/javascript" src="<%=path %>/js/clock.js"></script>
<script type="text/javascript" src="<%=path %>/js/judgeLogin.js"></script>

</head>

<body>
	<!-- 顶部导航栏 -->
	<div class="mynavbar-wrapper">
		<div class="mynavbar mynavbar-black">
			<div class="container cl">
				<span class="logos mynavbar-slogan " style="margin-left: 20px;"
					id="clock"></span> <a
					class="logos mynavbar-logos f-l mr-10 hidden-xs" href="<%=path %>/index.jsp">中餐厅</a>
				<span class="logos mynavbar-slogan f-l mr-10 hidden-xs">一家色香味俱全的餐厅</span>
				<nav class="mynav mynavbar-mynav mynav-collapse" role="mynavigation"id="Hui-mynavbar">

				<ul class="cl">
					<li class="current"><a href="<%=path %>/index.jsp">首页</a></li>
										
					<li class="dropDown dropDown_hover">
						<a href="javascript:;">我的餐单</a>
					</li>
										
					<li class="dropDown dropDown_hover">
						<a href="#">关于我们<i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" target="_blank">公司简介</a></li>
							<li><a href="javascript:;" target="_blank">免责条款</a></li>
							<li><a href="javascript:;" target="_blank">隐私保护</a></li>
							<li><a href="javascript:;" target="_blank">用户注册协议</a></li>
						</ul>
					</li>
					
					<s:if test="">
						<li class="dropDown dropDown_hover" style=" float:right; ">
							<a href="javascript:;">欢迎您：<i class="Hui-iconfont">&#xe6d5;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li><a  href="javascript:;">退出</a></li>
								</ul>
						</li>
					</s:if>
					<s:else>
						<li style=" float:right; "><a href="javascript:;">选桌子</a></li>
					</s:else>					
				</ul>
				</nav>
			</div>
		</div>
	</div>

	<!-- 图标logo -->
	<div style="margin: 5px auto;">
		<img alt="logo" src="<%=path %>/img/logo-login.png">
	</div>
	
<!-- 选项卡 -->
	<div id="wrapper-bg">
		<div id="wrapper">
			<!-- 左边消息栏 -->
			<div id="left-side">
				<ul>
					<!-- 订购机票 -->
					<li class="booking active">
						<div class="icon active">
							<i class="Hui-iconfont">&#xe603;</i>
						</div> 订购机票
					</li>

					<!-- 搜索航班 -->
					<li class="search">
						<div class="icon">
							<i class="Hui-iconfont">&#xe709;</i>
						</div> 搜索航班
					</li>

					<!-- 浏览航班信息 -->
					<li class="browse">
						<div class="icon">
							<i class="Hui-iconfont">&#xe667;</i>
						</div> 浏览航班信息
					</li>
					
				</ul>
			</div>
			<!-- end left-side -->

			<!-- 中间顺序条 -->
			<div id="border">
				<div id="line" class="one"></div>
			</div>

			<!-- 右边消息栏 -->
			<div id="right-side">
				<div id="first" class="active">
						<div class="icon big">
							<i  class="Hui-iconfont">&#xe603;</i> 机票
						</div>	
				</div><!-- End first -->

				<div id="second">
					<div class="icon big">
						<i  class="Hui-iconfont">&#xe709;</i>
					</div>

					<h1>Search flight`s information</h1>

				</div><!-- End second -->

				<div id="third">
					<div class="icon big">
						<i class="Hui-iconfont">&#xe667;</i>
					</div>

					<h1>Browse information</h1>

				</div><!-- End third -->

			</div><!-- end right-side -->
		</div><!-- end wrapper -->
	</div>

</body>
<script type=text/javascript>
	var clock = new Clock();
	clock.display(document.getElementById("clock"));
</script>
</html>
