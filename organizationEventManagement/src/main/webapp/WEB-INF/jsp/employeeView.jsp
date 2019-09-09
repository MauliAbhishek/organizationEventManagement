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
<title>View Employee</title>
</head>
<body>
<jsp:include page="/header"></jsp:include>


	</hr>
	<div align="center">
		<b>LIST OF EMPLOYEES</b>
	</div>
	<br />
	<div align="center">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th align="center">EMPLOYEE ID</th>
				<th align="center">EMPLOYEE NAME</th>
				<th align="center">JOIN_DATE</th>
				<th align="center">EMAIL_ID</th>
				<!-- <th align="center">ACTION</th> -->
			</tr>
			<c:forEach var="emp" items="${events}">
				<tr>
					<td align="center">M104${emp.mid}</td>
					<td align="center">${emp.name}</td>
					<td align="center">${emp.joinDate}</td>
					<td align="center">${emp.emailId}</td>
					<!-- <td align="center"><a href="#">Edit</a>  | <a
						href="#">Delete</a></td> -->
				</tr>
			</c:forEach>
		</table>
		<br /> <a href="/api/admin/add">Add New Employee</a>
	</div>
	
	<jsp:include page="/footer"></jsp:include>
</body>
</html>