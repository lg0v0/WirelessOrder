<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <title>查看菜的烹饪情况页面</title>
    
    <link rel="stylesheet" type="text/css" href="/WirelessOrder/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/WirelessOrder/css/theme.css">
    <link rel="stylesheet" href="/WirelessOrder/font-awesome/css/font-awesome.css">
    

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="/WirelessOrder/bootstrap/js/bootstrap.js"></script>
   
    <link rel="stylesheet" href="/WirelessOrder/bootstrap/css/bootstrap-switch.css" />
    <script src="/WirelessOrder/bootstrap/js/bootstrap-switch.js"></script>
    
    


    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
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
    <script charset="UTF-8" type="text/javascript" src="js/Message.js"></script>
        <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                        <a href="javascript:" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i>
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="/WirelessOrder/login.do?flag=logout">退出</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="javascript:"><span class="first">无线点餐</span> <span class="second">前台</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">

        <a href="javascript:" class="nav-header collapsed" data-toggle="collapse"><i class="icon-reorder"></i>服务</a>
        <ul id="menu-menu" class="nav nav-list collapse in">
            <li ><a href="Waiter.jsp">点餐</a></li>
            <li ><a href="WaiterOrder.jsp">点餐车</a></li>
            <li ><a href="Message.jsp">查看菜的烹饪情况</a></li>
        </ul>
    </div>
    
    <!-- 内容 开始 -->
<div class="content">
        <div class="header">
            <h1 class="page-title">点餐车</h1>
        </div>

        <div class="container-fluid">
            <div class="row-fluid">
            
                <div class="well">
                    <table class="table table-striped" id="table">
   						<thead>
      						<tr>
         						<th>桌号</th>
        						<th>菜名</th>
        						<th>数量</th>
        						<th>状态</th>
      						</tr>
   						</thead>
   						<tbody id="body">
   						</tbody>
					</table>
                </div>
                <div class="pagination">
</div>  
			<footer>
			<hr>
			<p class="pull-right">&copy; 2017.6 <a href="#" target="_blank">点餐系统</a></p>
			</footer>
            </div>
        </div>
    </div>




			<script type="text/javascript">
				function del(obj) {
					var delid = $(obj).attr("delid");
					var pNow = $(obj).attr("pNow");
					var delurl = "/WirelessOrder/menu.do?flag=delMenu&delid="
							+ delid + "&pageNow=" + pNow;
					$("#myModal").modal("show").on("shown", function() {
						$("#delbtn2").attr('href', delurl);
					});
				}
			</script>
  </body>
</html>
