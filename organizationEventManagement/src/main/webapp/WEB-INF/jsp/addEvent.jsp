<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page errorPage = "common/error.jsp" %>
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
<title>Add Event System</title>
</head>
<body>
<jsp:include page="/header"></jsp:include>
<hr/>
<br/>
	<div align="center">
	<div>
		<b>ADD EVENT</b>
	</div>
	<br />
<br/>
		<form:form id="resourceForm" modelAttribute="event"
			action="/api/event/create" method="post">
			<table>
				<tr>
					<td>Event Title</td>
					<td><form:input path="title" name="title" id="title" size="25" placeholder="Title" />
					<td>
				</tr>
				
				<tr>
					<td>Description</td>
					<td>
					<form:textarea path="description" name="comment" id="comment" rows="3"  placeholder="Desc"/>
					<td>
				</tr>

				<tr>
					<td>Agree & Accept</td>
					<td></td>
				</tr>

				<tr>
					<td><input class="ui-button ui-widget ui-corner-all" type="reset" value="Reset"></td>
					<td><input class="ui-button ui-widget ui-corner-all" type="submit" value="Register"></td>

				</tr>
			</table>
		</form:form>
	</div>

<jsp:include page="/footer"></jsp:include>
</body>
</html>