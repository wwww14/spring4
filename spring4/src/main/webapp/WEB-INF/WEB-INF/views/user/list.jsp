<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h2>user list info !!!</h2>
	<c:if test="${empty requestScope.user }">
		没有记录
	</c:if>
	<c:if test="${!empty requestScope.user }">
		<table>
			<tr>
				<th>ID</th>
				<th>userName</th>
				<th>loginName</th>
				<th>department</th>
			</tr>
			<c:forEach items="${requestScope.user}" var="u" varStatus="">
				<tr>
					<td>${u.id }</td>
					<td>${u.loginName }</td>
					<td>${u.displayName }</td>
					<td>${u.department.name }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>