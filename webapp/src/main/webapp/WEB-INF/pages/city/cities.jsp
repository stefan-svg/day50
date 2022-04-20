<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz svih gradova</title>

<style>
.container {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction:column;
	margin-top: 7%;
}

.container h2{
	margin-bottom: 3%;
}

table {
	width: 80%;
	border-collapse: collapse;
}

th {
	border: 1px solid black;
}

</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
		<jsp:include page="/WEB-INF/fragment/login_user.jsp" flush="true" />
	</header>

	
			<div class="container">
		<h2>Svi gradovi registrovani u sistemu</h2>
				<table>
					<thead>
						<tr>
							<th>Ptt</th>
							<th>Ime</th>
							<th>Akcija</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="city" items="${cities}">
						<tr>
							<th>${city.zipCode}</th>
							<th>${city.name}</th>
							<th>
								<a href="/testwebapp/application/city/view?zipCode=${city.zipCode}">View city</a>
								<br>
								<a href="/testwebapp/application/city/delete?zipCode=${city.zipCode}">Delete city</a>
							</th>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
</body>
</html>