<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="include_jstl.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 登陆框 -->

	<div class="login">
		<div class="regist">
			<a href="register.jsp">注册</a>
		</div>
		<!--未登录-->
		<c:if test="${empty sessionScope.user}">
			<div class="loginM">
				<form action="login.do" method="post" id="logForm">
					<table>

						<tr>
							<td><img src="images/username.png" /></td>
							<td><input type="text" name="username" id="username" /></td>
						</tr>

						<tr height="60">
							<td><img src="images/password.png" /></td>
							<td><input type="text" name="password" id="password" /></td>
						</tr>
						<tr>
							<td><span class="word_orange" id="login"></span></td>
						</tr>
						<tr height="50">
							<td colspan="2" align="center">
							<input type="image" src="images/loginM.png" onclick="login();return false" />
								忘记账号或密码</td>
						</tr>
					</table>
				</form>
			</div>
			<!--未登录结束-->
		</c:if>
		<c:if test="${not empty sessionScope.user}">
			<!--已登录-->
			<div class="logined">
				<span><a href="">${sessionScope.user.username}</a>
				</span><br /> <br />欢迎您使用B.O.D网上银行<br> <input type="button"
					value="注销" onclick="window.location.href='user.do?command=logout'" />
			</div>
			<!--已登录结束-->
		</c:if>
	</div>