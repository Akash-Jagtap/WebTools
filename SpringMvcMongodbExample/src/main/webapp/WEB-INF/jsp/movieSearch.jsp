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
	<spring:url value="/searchsubmit" var="searchsubmit"/>
	<form:form action="${searchsubmit}" method="POST" modelAttribute="Movie">
		Select Field
		<select id="selectedRecord" name="selectedRecord">
			<option value="">-- select one -- </option>
			<c:forEach var="movieFields" items="${movieFields}">
				<option value="${movieFields.getName()}">${movieFields.getName()}</option>
			</c:forEach>
		</select>
		<input type="text" id=searchField name=searchField>
		<button type="submit">Search</button>
	</form:form>
	<table border=1>
	<thead>
		<tr>
			<th>MovieID</th>
			<th>Title</th>	
			<th>Genre</th>		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listMovies}" var="movie">
		<tr>
			<td>${movie.movieID}</td>
			<td>${movie.title}</td>
			<td>${movie.listGenre}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>