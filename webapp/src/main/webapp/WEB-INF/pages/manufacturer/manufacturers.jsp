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
<body>
	<header>
		<jsp:include page="/WEB-INF/fragment/login_user.jsp" flush="true" />
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
	</header>

	<main>
		<h2>Svi proizvodjaci registrovani u sistemu</h2>

		<article>
			<div>
				<table>
					<thead>
						<tr>
							<th>Pib</th>
							<th>Maticni broj</th>
							<th>Adresa</th>
							<th>Grad</th>
							<th>Akcija</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="manufacturer" items="${manufacturers}">
						<tr>
							<th>${manufacturer.pib}</th>
							<th>${manufacturer.matbr}</th>
							<th>${manufacturer.adresa}</th>
							<th>${manufacturer.city.name}</th>
							<th>
								<a href="/testwebapp/application/manufacturer/view?pib=${manufacturer.pib}">View manufacturer</a>
								<br>
								<a href="/testwebapp/application/manufacturer/delete?pib=${manufacturer.pib}">Delete manufacturer</a>
							</th>
						</tr>
						</c:forEach>
					</tbody>

				</table>


			</div>

		</article>
	</main>


</body>
</html>