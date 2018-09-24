<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<spring:url value="/searchMovie" var="searchMovie"/>
	To search Movies Collection 
	<a href="${searchMovie}">Click here</a>
	<br>
	<spring:url value="/searchRatings" var="searchRatings"/>
	To search Ratings Collection 
	<a href="${searchRatings}">Click here</a>
	<br>
	<spring:url value="/searchTags" var="searchTags"/>
	To search Tags Collection 
	<a href="${searchTags}">Click here</a>	
</body>
</html>