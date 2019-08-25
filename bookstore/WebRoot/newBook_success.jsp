<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="css/bookstore.css" rel="stylesheet" type="text/css">	
<h1><span class="green14b">新书展示</span></h1>
<br>
<div class=info_bk1>
	<s:iterator value="#request['books']" id="book">
		<div class=xh5>
			<img height=105 width=80 src="/bookstore/picture/<s:property value="#book.picture"/>"/><br>
			<s:property value="#book.bookname"/><br>
			价格：<s:property value="#book.price"/>元<br>
			<form action="addToCart" method="post">
				数量：<input type="text" name="quantity" id="quantity" value="0" size="4"><br>
				<input type="hidden" value="<s:property value="#book.bookid"/>" name="bookid"/>
				<input type="image" name="submit" src="/bookstore/picture/buy.gif"/>
			</form>
		</div>
	</s:iterator>
</div>