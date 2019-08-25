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
					<s:set name="books" value="#request.books"/>
					<s:if test="#books.size!=0">
						<h3><font color="blue">所有符合条件的图书</font></h3>
						<br/>
						<s:iterator value="#books" id="book">
							<table width=600 border=0>
								<tr>
									<td width=200 align="center">
										<img src="/bookstore/picture/<s:property value="#book.picture"/>" width=100/>
									</td>
									<td valign="top" width=400>
										书名：<s:property value="#book.bookname"/><br>
										价格：<s:property value="#book.price"/>元<br>
										<form action="addToCart" method="post">
											数量：<input type="text" name="quantity" id="quantity" value="0" size="4"><br>
											<input type="hidden" value="<s:property value="#book.bookid"/>" name="bookid"/>
											<input type="image" name="submit" src="/bookstore/picture/buy.gif"/>
										</form>
									</td>
								</tr>
							</table>
						</s:iterator>
					</s:if>	
					<s:else>
						对不起，没有您要找的图书！
					</s:else>				
				</div>
			</div>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>