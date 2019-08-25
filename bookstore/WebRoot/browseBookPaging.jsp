<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
	<head>
		<title>�������</title>	
		<link href="css/bookstore.css" rel="stylesheet" type="text/css">	
	</head>
	<body>
		<!--����head.jsp-->
		<jsp:include page="head.jsp"></jsp:include>
		<div class=content>
			<div class=left>
				<div class=list_box>
					<div class=list_bk>
						<!--ִ��browseCatalog��Action�����ѽ����ʾ�ڸ�λ�ã���action�Ĺ�������ʵ���е�ͼ������ͣ��ù��ܻ��ں��潲������ͬ-->
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
									������<s:property value="#book.bookname"/><br>
									�۸�<s:property value="#book.price"/>Ԫ<br>
									<form action="addToCart" method="post">
										������<input type="text" name="quantity" id="quantity" value="0" size="4"><br>
										<input type="hidden" value="<s:property value="#book.bookid"/>" name="bookid"/>
										<input type="image" name="submit" src="/bookstore/picture/buy.gif"/>
									</form>
								</td>
							</tr>
						</table>
					</s:iterator>
					<s:set name="page" value="#request.pager"></s:set>
					<s:if test="#page.hasFirst">
						<s:a href="browseBookPaging.action?pageNow=1">��ҳ</s:a>
					</s:if>
					<s:if test="#page.hasPre">
						<a href="browseBookPaging.action?pageNow=<s:property value="#page.pageNow-1"/>">��һҳ</a>
					</s:if>
					<s:if test="#page.hasNext">
						<a href="browseBookPaging.action?pageNow=<s:property value="#page.pageNow+1"/>">��һҳ</a>
					</s:if>
					<s:if test="#page.hasLast">
						<a href="browseBookPaging.action?pageNow=<s:property value="#page.totalPage"/>">βҳ</a>
					</s:if>
					<br>
					��ǰ��<s:property value="#page.pageNow"/>ҳ���ܹ�<s:property value="#page.totalPage"/>ҳ
				</div>
			</div>
		</div>
	<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>