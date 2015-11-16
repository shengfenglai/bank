<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>B.O.D网上银行</title>

<link type="text/css" rel="stylesheet" href="css/style_1.css" />
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/transfer.js" ></script>
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
			<li><a href="user.do?command=balance">查询余额</a>
			</li>
			<li><a href="getMoney.jsp">取款</a>
			</li>
			<li><a href="save.jsp">存款</a>
			</li>
			<li><a href="transfer.jsp">转账</a></li>
			</li>
		</ul>
		<div class="con">服务热线：12580</div>
	</div>


	<!-- 登陆框 -->
	<div class="content">
		<%@ include file="include_log.jsp"%>
		<!-- 主要内容 -->
		<div class="main2">
			<div id="m">
				<form action="user.do?command=transferMoney" method = "post" id="tranForm">
					<table>
						<tr height="30">
							<td align="right" width="70">转账金额：</td>
							<td align="left" width="150">
								<input type="text" name="money" id="money"/>
							</td>
						</tr>
						<tr height="30">
							<td align="right" width="70">收款账户：</td>
							<td align="left" width="150">
								<input type="text" name="username" id="username"/>
								<span class="word_orange" id="uName"></span>
							</td>
						</tr>
						
						<tr height="30">
							<td>
								<span class="word_orange" id="transfer"></span>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center" height="70">
							<input type="image" src="images/sure.png" onclick="transfer();return false"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>

	<div class="bottom">
		<img src="images/bottom.png" height="30" width="827" />
	</div>
</body>
</html>
