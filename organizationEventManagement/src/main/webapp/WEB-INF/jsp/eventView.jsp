<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/css/custom.css" rel="stylesheet">
<link href="/css/jquery-ui.min.css" rel="stylesheet">
<link href="/css/jquery-ui.theme.min.css" rel="stylesheet">
<script src="/js/jquery-3.3.1-1.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<title>Event Management</title>
</head>
<body>
<jsp:include page="/header"></jsp:include>
	</hr>
	<div align="center">
		<b>LIST OF EVENTS</b>
	</div>
	<br />
	<div align="center">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>EVENT_ID</th>
				<th>EVENT_TITLE</th>				
				<th>DESCRIPTION</th>
				<th>ACTION</th>
			</tr>
			<c:forEach var="event" items="${events}">
				<tr>
					<td>${event.id}</td>
					<td>${event.title}</td>					
					<td>${event.description}</td>

					<td><a href="#">Edit</a>   |  <a
						href="#">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br /> <a href="/api/event/add">Add New Event</a>
	</div>
	
<jsp:include page="/footer"></jsp:include>
</body>
</html>