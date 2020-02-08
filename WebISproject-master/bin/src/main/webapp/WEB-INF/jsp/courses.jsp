<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Courses</h1>
	<table>
		<tr><th>title</th><th>ects</th></tr>
		<c:forEach var = "course" items = "${courses}">
			<tr>
				<td>${course.title}</td>
				<td>${course.ects}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>