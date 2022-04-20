<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
body {
	font-size: 2rem;
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

header {
	position: relative;
	display: flex;
	width: 100%;
	height: 10vh;
	background-color: black;
	align-items: center;
	justify-content: space-between;
	border-radius: 0 0 10px 10px;
}
p{
	margin: 0 20px;
	color: #25D6B3;
	text-decoration: none;
}

form{
	display: flex;
	margin: 0 20px;
}
</style>
</head>

<c:url value="/logout" var="urllogout"></c:url>
		<form action="/testwebapp/application/logout" method="post" >
		<p>Prijavljeni ste kao: ${sessionScope.login_user.username} </p>
			<input class="btn" type="submit" name="logout" value="Logout">
		</form>
</html>