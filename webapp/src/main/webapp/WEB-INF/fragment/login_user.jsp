<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<c:url value="/logout" var="urllogout"></c:url>
	
	<div>
		Prijavljeni ste kao ${sessionScope.login_user.username} 
		<form action="/webapprecap/application/logout" method="post" >
			<input type="submit" name="logout" value="Logout">
		</form>
	</div>
</html>