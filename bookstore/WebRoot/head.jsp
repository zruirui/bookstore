<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>������꣨bookstore��</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class=head>
			<div class=head_left>
				<a href="#"><img hspace=11 src="picture/logo_dear.gif" vspace=5>
				</a>
				<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����ṩרҵ����
			</div>
			<div class=head_right>
				<div class=head_right_nei>
					<div class=head_top>
						<div class=head_buy>
							<strong> <a href="/bookstore/showCart.jsp">
							<IMG height=15 src="picture/buy01.jpg" width=16>&nbsp;���ﳵ</a>
							</strong> |
							<a href="#">�û�FAQ</a>
						</div>
					</div>
					<div class=head_middle>
						<a class="title01" href="index.jsp" target=_top> 
								 <span>&nbsp;&nbsp;��ҳ&nbsp;&nbsp;</span>
						</a>
						<s:if test="#session.user==null">
							<a class=title01 href="login.jsp"> 
								<span>&nbsp;&nbsp;��¼&nbsp;&nbsp;</span>
							</a>
						</s:if>
						<s:else>
							<a class=title01 href="logout.action"> 
								<span>&nbsp;&nbsp;ע��&nbsp;&nbsp;</span> 
							</a>
						</s:else>
						<a class=title01 href="register.jsp" target=_top>
							<span>&nbsp;&nbsp;ע��&nbsp;&nbsp;</span> 
						</a>
						<a class=title01 href="#">
							<span class="style3">��ϵ����&nbsp;&nbsp;&nbsp;</span> 
						</a>
						<a class=title01 href="#" target=_top>
							<span class="style3">&nbsp;��վ��ͼ&nbsp;&nbsp;&nbsp;</span>
						</a>
					</div>
					<div class=head_bottom>
						<form action="searchBook.action" method="post">
							<input type="text" name="bookname" size="50" />
							<input type="image" name="submit" src="picture/search02.jpg"
								style="width: 48px; height: 22px" />
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>