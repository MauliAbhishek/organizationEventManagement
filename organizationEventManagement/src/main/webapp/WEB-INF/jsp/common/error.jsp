<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<jsp:include page="/header"></jsp:include>

   <h1>Opps...</h1>
      <table width = "100%" border = "1">
         <tr valign = "top">
            <td width = "40%"><b>Error:</b></td>
            <td>${pageContext.exception}</td>
         </tr>
            
         <tr valign = "top">
            <td><b>URI:</b></td>
            <td>${pageContext.errorData.requestURI}</td>
         </tr>
            
         <tr valign = "top">
            <td><b>Status code:</b></td>
            <td>${pageContext.errorData.statusCode}</td>
         </tr>
            
         <tr valign = "top">
            <td><b>Stack trace:</b></td>
            <td>
               <c:forEach var = "trace" 
                  items = "${pageContext.exception.stackTrace}">
                  <p>${trace}</p>
               </c:forEach>
            </td>
         </tr>
      </table>
      
<jsp:include page="/footer"></jsp:include>
</body>
</html>