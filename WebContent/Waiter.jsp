<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>点餐页面</title>

<link rel="stylesheet" type="text/css"
	href="/WirelessOrder/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="/WirelessOrder/css/theme.css">
<link rel="stylesheet"
	href="/WirelessOrder/font-awesome/css/font-awesome.css">


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="/WirelessOrder/bootstrap/js/bootstrap.js"></script>

<link rel="stylesheet"
	href="/WirelessOrder/bootstrap/css/bootstrap-switch.css" />
<script src="/WirelessOrder/bootstrap/js/bootstrap-switch.js"></script>

<script charset="UTF-8" type="text/javascript" src="js/Waiter.js"></script>


<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>


</head>
<body class="">
	<!--<![endif]-->

	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">
				<li id="fat-menu" class="dropdown"><a href="javascript:"
					role="button" class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i>${user.username} <i class="icon-caret-down"></i>
				</a>

					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="#">退出</a></li>
					</ul></li>

			</ul>
			<a class="brand" href="javascript:"><span class="first">无线点餐</span>
				<span class="second">前台</span></a>
			<center style="margin-top: 10px;">
				<span style="color: #ccc;">桌号：<span id="showtable"><%=session.getAttribute("tablenum")%></span></span>
			</center>
		</div>
	</div>




	<div class="sidebar-nav">
		<form class="search form-inline">
			<input id="tablenum" type="text" placeholder="请输入餐桌号"> <input
				id="table" type="button" value="确定">
		</form>

		<a href="javascript:" class="nav-header collapsed"
			data-toggle="collapse"><i class="icon-reorder"></i>服务</a>
		<ul id="menu-menu" class="nav nav-list collapse in">
			<li><a href="Waiter.jsp">点餐</a></li>
			<li><a href="WaiterOrder.jsp">点餐车</a></li>
			<li><a href="Message.jsp">查看菜的烹饪情况</a></li>
		</ul>
	</div>

	<!-- 内容 开始 -->
	<div class="content">
		<div class="header">
			<h1 class="page-title">菜谱</h1>
		</div>

		<div class="container-fluid">
			<div class="row-fluid">
				<!-- 
            <div class="row-fluid">
				    <div class="alert alert-info">
				        <button type="button" class="close" data-dismiss="alert">×</button>
				        <strong>小提示：</strong> 添加成功！！
				    </div>
                
            </div> 
-->

				<div class="well">
					<ul id="showItem" class="thumbnails"></ul>
				</div>
				<div class="pagination"></div>
				<footer>
				<hr>
				<p class="pull-right">
					&copy; 2017.6 <a href="#" target="_blank">点餐系统</a>
				</p>
				</footer>
			</div>
		</div>
	</div>




	<script type="text/javascript">
		function del(obj) {
			var delid = $(obj).attr("delid");
			var pNow = $(obj).attr("pNow");
			var delurl = "/WirelessOrder/menu.do?flag=delMenu&delid=" + delid
					+ "&pageNow=" + pNow;
			$("#myModal").modal("show").on("shown", function() {
				$("#delbtn2").attr('href', delurl);
			});
		}
	</script>
</body>
</html>
