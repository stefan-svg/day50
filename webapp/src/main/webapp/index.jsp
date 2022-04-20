<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
body {
  display: flex;
  justify-content: center;
  margin-top: 200px;
  background-image:url('https://wallpaperaccess.com/full/51367.jpg');
  background-size:cover;
  margin-top:360px;
}
a{
	text-decoration: none;
  	cursor: pointer;
    background-color: #14a020;
    color: #f9e9ff;
    padding: 0.5rem;
    border-radius: 5px;
    letter-spacing:2px;
    font-size:2rem;
}
</style>
</head>

<body>
	<div>
		<c:url value="/application/login" var="urlLogin"/>
		<a href="${urlLogin}">Prijavi se</a>
	</div>

</body>
</html>
