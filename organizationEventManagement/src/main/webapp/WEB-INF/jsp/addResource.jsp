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
<title>Add Resource System</title>
</head>
<body>
	<jsp:include page="/header"></jsp:include>
	<hr/>
<br/>
	<div align="center">
		<div>
			<b>ADD EMPLOYEE</b>
		</div>
<br/>
		<form:form id="resourceForm" modelAttribute="resource"
			action="/api/admin/save" method="POST">
			<table>
				<tr>
					<td>Employee Name</td>
					<td><form:input path="name" name="name" id="name" size="25" placeholder="Full Name"/>
					<td>
				</tr>

				<tr>
					<td>Join Date</td>
					<td><form:input path="joinDate" name="joinDate" id="joinDate"
							size="15" placeholder="dd/mm/yyyy"/>
					<td>
				</tr>

				<tr>
					<td>Email Address</td>
					<td><form:input path="emailId" name="emailId" id="emailId"
							size="30" placeholder="Valid Email"/>
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
	<br />


	<jsp:include page="/footer"></jsp:include>
</body>
</html>