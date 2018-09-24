<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieSearch</title>
</head>
<body>
	<spring:url value="/searchTagsubmit" var="searchsubmit"/>
	<form:form action="${searchsubmit}" method="POST" modelAttribute="Tag">
		Select Field
		<select id="selectedRecord" name="selectedRecord">
			<option value="">-- select one -- </option>
			<c:forEach var="tagFields" items="${tagFields}">
				<option value="${tagFields.getName()}">${tagFields.getName()}</option>
			</c:forEach>
		</select>
		<input type="text" id=searchField name=searchField>
		<button type="submit">Search</button>
	</form:form>
	<table border=1>
	<thead>
		<tr>
			<th>UserID</th>
			<th>MovieID</th>	
			<th>Tag</th>	
			<th>TimeStamp</th>	
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listTags}" var="tag">
		<tr>
			<td>${tag.userID}</td>
			<td>${tag.movieID}</td>
			<td>${tag.tag}</td>
			<td>${tag.timeStamp}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>