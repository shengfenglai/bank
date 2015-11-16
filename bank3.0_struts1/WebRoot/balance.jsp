<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>B.O.D网上银行</title>

<link type="text/css" rel="stylesheet" href="css/style_1.css" />

</head>

<body>
	<div class="title">
		<!--B.O.D.银行 -->
		<div class="BOD"></div>

		<!--右上搜索 -->
		<div class="title2">
			<img src="images/search.png" /> <a href="">全球服务</a>|<a href="">English</a>|<a
				href="">繁体中文</a>
		</div>
		<div class="search">
			<form action="">
				<input name="search" type="text" value="关键词" /> <input type="image"
					src="images/search_button.png" />
			</form>
		</div>
	</div>

	<div class="line1">
		<img src="images/line1.png" height="8" width="823" />
	</div>

	<!--导航条-->
	<div class="nav">
		<ul>
			<li><a href="index.jsp">首页</a>
			</li>
			<li><a href="checkMoney.do">查询余额</a>
			</li>
			<li><a href="getMoney.jsp">取款</a>
			</li>
			<li><a href="save.jsp">存款</a>
			</li>
			<li><a href="transfer.jsp">转账</a></li>
			<li><a href="identify.html">个人资料</a>
			</li>
		</ul>
		<div class="con">服务热线：12580</div>
	</div>


	<!-- 登陆框 -->
	<div class="content">
		<%@ include file="include_log.jsp"%>
		<!-- 主要内容 -->
		<div class="main2">
		
			<div id="m1">
				您的余额为：<span>${sessionScope.user.money}</span>
			</div>
			
		</div>
	</div>

	<div class="bottom">
		<img src="images/bottom.png" height="30" width="827" />
	</div>
</body>
</html>
