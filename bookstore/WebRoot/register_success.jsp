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
					<font face=����></font><font face=����></font><font face=����></font><font face=����></font>
				<div class=banner></div>
				<div class=info_bk1>
					<div align="center">
						���ã��û� <s:property value="user.username"/> ��ϲ��ע��ɹ���
						<a href="login.jsp">��¼</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
	</body>
</html>
