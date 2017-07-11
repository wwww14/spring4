<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/style/public/title_setting.jsp" %>
<html>
<head>
	<title>${sys_title}</title>
</head>
<frameset rows="100,*,65" framespacing=0 border=0 frameborder="0">
		<frame noresize name="TopMenu" scrolling="no" src="${ctx}/frame/top">
		<frameset cols="200,*" id="resize">
			<frame noresize name="menu" scrolling="yes" src="${ctx}/frame/left">
			<frame noresize name="right" scrolling="yes" src="${ctx}/frame/right">
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="${ctx}/frame/bottom">
	</frameset>
	<noframes>
<body>
</body>
</noframes>
</html>



