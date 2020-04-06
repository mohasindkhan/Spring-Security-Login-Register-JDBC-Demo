<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title> Spring Registration Form </title>

</head>

<body>

	<div>

		<h1> Spring Custom Registration Form </h1> <hr>

	</div>
	
	<!---------------------------------- Registration Form -------------------------------------------->
	
	<form:form action="${pageContext.request.contextPath}/registerNewCustomer" modelAttribute="cust">
	
		<h2> Username: <form:input path="username" name="username" /> </h2>
		
		<h2> Password: <form:password path="password" name="password" /> </h2>
		
		<h2> <input type="submit" value="Register"> </h2>
	
	</form:form>
	
	<!---------------------------------- Registration Form -------------------------------------------->
	
	<div>
	
		<a href="${pageContext.request.contextPath}/showLoginForm"> Back To Login</a>
	
	</div>

</body>

</html>