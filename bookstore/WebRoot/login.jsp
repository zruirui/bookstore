<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
	<head>
		<title>网上购书系统</title>
		<link href="css/bookstore.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<jsp:include page="head.jsp"></jsp:include>
		<div class=content>
			<div class=left>
				<div class=list_box>
					<div class=list_bk>
						<s:action name="browseCatalog" executeResult="true" />
					</div>
				</div>
			</div>
			<div class=right>
				<div class=right_box>
					<font face=宋体></font><font face=宋体></font><font face=宋体></font><font
						face=宋体></font>
					<div class=banner>
					</div>
					<div class=info_bk1>
						<div align="center">
							<form action="login.action" method="post" name="login">
								用户登录
								<br>
								用户名:
								<input type="text" name="user.username" size=20 id="username">
								<br>
								密&nbsp;&nbsp;&nbsp;&nbsp;码:
								<input type="password" name="user.password" size=21 id="password">
								<br>
								<input type="submit" value="登录">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>