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
a{
text-decoration: none;
}
</style>
</head>
<c:url value="/application/city/add" var="cityAdd"/>
<c:url value="/application/city" var="cities"/>
<c:url value="/application/manufacturer/add" var="manufacturerAdd"/>
<c:url value="/application/manufacturer" var="manufacturers"/>
<div>
	<nav>
		<a href="${cityAdd}">Add city</a>
		<a href="${cities}">View cities</a>
		<a href="${manufacturerAdd}">Add manufacturer</a>
		<a href="${manufacturers}">View manufacturers</a>
	</nav>

</div>

</html>