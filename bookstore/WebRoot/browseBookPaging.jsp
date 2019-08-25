<%@ page contentType="text/html;charset=gb2312"%>
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
					<s:iterator value="#request['books']" id="book">
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
					<s:set name="page" value="#request.pager"></s:set>
					<s:if test="#page.hasFirst">
						<s:a href="browseBookPaging.action?pageNow=1">首页</s:a>
					</s:if>
					<s:if test="#page.hasPre">
						<a href="browseBookPaging.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
					</s:if>
					<s:if test="#page.hasNext">
						<a href="browseBookPaging.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
					</s:if>
					<s:if test="#page.hasLast">
						<a href="browseBookPaging.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
					</s:if>
					<br>
					当前第<s:property value="#page.pageNow"/>页，总共<s:property value="#page.totalPage"/>页
				</div>
			</div>
		</div>
	<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>