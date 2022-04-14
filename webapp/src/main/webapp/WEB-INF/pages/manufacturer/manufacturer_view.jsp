<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikazi proizvodjaca</title>
</head>
<body>
		<header>
		<jsp:include page="/WEB-INF/fragment/login_user.jsp" flush="true" />
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
	</header>

	<main>
		<h2>Trenutni podaci o proizvodjacu</h2>

		<article>
			<div>
				<form  action="/webapprecap/application/manufacturer/edit?pib=${manufacturer.pib}" method="post">
					<div>
						${error_message}
					</div>
					<label>PIB</label>
					<input type="text" name="pib" value="${manufacturer.pib}" readonly="readonly"/>
					<label>Maticni broj</label>
					<input type="text" name="matbr" value="${manufacturer.matbr}" readonly="readonly"/>
					<label>Adresa</label>
					<input type="text" name="adresa" value="${manufacturer.adresa}" readonly="readonly"/>
					<label>Grad</label>
					<input type="text" name="grad" value="${manufacturer.city.name}" readonly="readonly"/>
					<div>
						<input type="submit" name="edit" value="edit"/>
					</div>

				</form>
				<form action="/testwebapp/application/manufacturer/cancel" method="post">
					<div>
						<input type="submit" name="cancel" value="cancel"/>
					</div>
				</form>
			</div>

		</article>
	</main>

	
</body>
</html>