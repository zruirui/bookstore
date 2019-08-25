<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
	<head>
		<title>网上书店</title>	
		<link href="css/bookstore.css" rel="stylesheet" type="text/css">	
	</head>
	<body>
		<!--导入head.jsp-->
		<jsp:include page="head.jsp"></jsp:include>
		<div class=content>
			<div class=left>
				<div class=list_box>
					<div class=list_bk>
						<!--执行browseCatalog的Action，并把结果显示在该位置，该action的功能是现实所有的图书的类型，该功能会在后面讲述，下同-->
						<s:action name="browseCatalog" executeResult="true" />
					</div>
				</div>
			</div>
			<div class=right>
				<div class=right_box>
					<font face=宋体>图书添加成功！</font>
					<form action="browseBookPaging" method="post">
						<input type="hidden" value="<s:property value="#book.bookid"/>" name="bookid"/>
						<input type="image" name="submit" src="/bookstore/picture/continue.gif"/>
					</form>
				</div>
			</div>
		</div>
	<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>
