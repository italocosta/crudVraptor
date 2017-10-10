<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Client</title>
</head>
<body>

	<form action="${linkTo[ClientController].toAdd(client)}" method="post">
		<c:forEach var="error" items="${errors}">
	   		${error.category} - ${error.message}<br />
		</c:forEach>
		<label>ID:</label>
		<input name="client.id"	value="${client.id }"/><br />
		<label>Name:</label>
		<input name="client.name" value="${client.name }" type="text" /><br />
		<label>Date	of birthday:</label>
		<fmt:formatDate value="${client.birthDay }" pattern="yyyy-MM-dd" var="fmt" />
		<input name="client.birthDay" value="${fmt }" type="date" /><br />
		<label>Active:</label>
		<input type="checkbox" name="client.active"
		 <c:if test="${client.active }">checked="checked"</c:if>/><br/>
		<label>Height:</label> <input name="client.height"
			value="${client.height }" type="number" step="0.01" min="0.01"
			max="2.99" /><br />
		<button type="submit">Save</button>
		<a href="${linkTo[ClientController].listClients()}">Cancel</a>

	</form>
</body>
</html>