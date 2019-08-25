<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
	<head>
		<title>���Ϲ���ϵͳ</title>
		<link href="css/bookstore.css" rel="stylesheet" type="text/css">
	</head>
	<script language="javascript">
<!--
	function check(thisobject){
		var stmp="";
		stmp=thisobject.value;
		if(isnan(stmp)){
			alert("����������");
			thisobject.select();
		}
}
//-->
</script>
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
					<s:set name="items" value="#session.cart.items" />
					<s:if test="#items.size != 0">
						<h3>	
							<font color="blue">�����ﳵ��ͼ��</font>
						</h3>
						<div class="info_bk1">
						<s:iterator value="items" id="item">
							<s:form action="updateCart.action" method="post">
								<table width="600" border="0">
									<tr align="left">
										<td width="50">
											������
										</td>
										<td width="100">
											<s:property value="value.book.bookname" />
										</td>
										<td width="50">
											�۸�
										</td>
										<td width="50">
											<s:property value="value.book.price" />
										</td>
										<td width="50">
											������
										</td>
										<td width="50">
											<input type="text" name="quantity" value="<s:property  value="value.quantity"/>" size="4"
												onblur="check(this)" />
											<input type="hidden" name="bookid" value="<s:property  value="value.book.bookid"/>" />
										</td>
										<td width="50">
											<input type="submit" value="����" />
										</td>
									</tr>
								</table>
							</s:form>
						</s:iterator>
						</div>
					���ѽ��:
					<s:property value="#session.cart.totalPrice" />
					Ԫ&nbsp;&nbsp;&nbsp;
					<a href="checkout.action"><img src="/bookstore/picture/count.gif" /> </a>
					</s:if>
					<s:else>
						�Բ���,����û��ѡ���κ��鼮!
					</s:else>
				</div>
			</div>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>
