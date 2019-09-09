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
<title>Event Management</title>
</head>
<body>
<jsp:include page="/header"></jsp:include>


	
	<br />
	<div class="container">
		<form:form id="eventManageForm" modelAttribute="evtReg"
			action="/api/event/register" method="post">
			<table align="center">
				<tr>
					<td><form:label path="eventLbl">
							<a href="/api/event/view">Event</a>
						</form:label></td>
					<td><form:select path="eventId" id="eventId">							
							<form:options items="${events}" />
						</form:select></td>
				</tr>
			<%-- 	<tr>
					<td><form:label path="descriptionLbl">Description</form:label></td>
					<td><form:textarea path="description" name="desc"
							id="desc" placeholder="Desc"/></td>
				</tr> --%>
				
				<tr>
					<td><form:label path="resourcesLbl">
							<a href="/api/admin/view">Resources </a>
						</form:label></td>
					<td><form:select path="mid" id="resourcesId">
							<form:options items="${resources}" />
						</form:select></td>
				</tr>

				<tr>
					<td><input class="ui-button ui-widget ui-corner-all"
						type="submit" value="Register"></td>
					<td><a class="ui-button ui-widget ui-corner-all" href="#">Cancel</a></td>
				</tr>
			</table>

		</form:form>

	</div>
<hr/>
<c:if test="${scheduledEvents.size() > 0}">
<div align="center">
<p><b><u>Upcoming Events</u></b> </p>
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th align="center">EVENT TITLE</th>				
				<th align="center">EVENT DESCRIPTION</th>
				<th align="center">SCHEDULED FOR</th>
			<!-- 	<th align="center">ACTIONS</th> -->
			</tr>
			<c:forEach var="schEvt" items="${scheduledEvents}">
				<tr>
					<td align="center">${schEvt.title}</td>
					<td align="center">${schEvt.description}</td>
					<td align="center">M104${schEvt.mid}</td>

					<!-- <td align="center"> <a
						href="#">Cancel</a></td> -->
				</tr>
			</c:forEach>
		</table>

</div>

</c:if>

	<jsp:include page="/footer"></jsp:include>
	<script src="js/custom.js"></script>
</body>
</html>