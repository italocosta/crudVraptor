<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListClients</title>
</head>
<body>
	<a href="#">New client</a>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Date Of Birth</th>
			<th>Height</th>
			<th>Active</th>
		</tr>
		<c:forEach items="${clientList}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.birthDay}" /></td>
				<td>${c.height}</td>
				<td>${c.active}</td>
				<td><a href="${linkTo[ClientController].editClient(c.id)}">Edit</a></td>
				<td><a href="#">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>