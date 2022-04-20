<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
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
</style>
</head>
<body>
	<header>
	<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true"/>
	<jsp:include page="/WEB-INF/fragment/login_user.jsp" flush="true"/>
	</header>
</body>
</html>
