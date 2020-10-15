<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
<%@include file="menu.jsp" %>

<h5>Vous êtes connecté en tant que <%= session.getAttribute("login") %></h5>

</body>
</html>