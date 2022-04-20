<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

a{
	margin: 0 20px;
	color: #25D6B3;
	text-decoration: none;
	transition: 0.2s ease-in-out;
}

a:hover{
	color: white;
}

.btn {
	font-size: 1.6rem;
	background-color: #25D6B3;
	color: #FFF;
	cursor: pointer;
	padding: 0.3rem 0.7rem;
	border: 1px solid #25D6B3;
	border-radius: 10px;
	transition: 0.2s ease-in-out;
}

.btn:hover {
	background-color: #FFF;
	color: #25D6B3;
	border: 1px solid #25D6B3;
}

</style>
</head>
<c:url value="/application/city/add" var="cityAdd"/>
<c:url value="/application/city" var="cities"/>
<c:url value="/application/manufacturer/add" var="manufacturerAdd"/>
<c:url value="/application/manufacturer" var="manufacturers"/>
	<nav>
		<a href="${manufacturers}">View manufacturers</a>
		<a href="${manufacturerAdd}">Add manufacturer</a>
		<a href="${cities}">View cities</a>
		<a href="${cityAdd}">Add city</a>
	</nav>
</html>