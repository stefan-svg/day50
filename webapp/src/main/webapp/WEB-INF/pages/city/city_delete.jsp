<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikazi grad</title>
<style>
	body{
		background-image: url("https://wallpaperaccess.com/full/123427.jpg");
 		background-size: cover;
	}
	main{ 		
		display:flex;
 		flex-direction:column;
 		justify-content: center;
 		align-items:center;
		
	}
</style>
</head>
<body>
		<header>
		<jsp:include page="/WEB-INF/fragment/login_user.jsp" flush="true" />
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
	</header>

	<main>
		<h2>Trenutni podaci o gradu</h2>

		<article>
			<div>
				<form >
					<label>Postanski broj</label>
					<input type="text" name="zipCode" value="${city.zipCode}" readonly="readonly"/>
					
					<label>Naziv</label>
					<input type="text" name="name" value="${city.name}" readonly="readonly"/>
				</form>
				<form action="/testwebapp/application/city/cancel" method="post">
					<div>
						<input type="submit" name="cancel" value="cancel"/>
					</div>
				</form>
				<form action="/testwebapp/application/city/delete?zipCode=${city.zipCode}" method="post">
					<div>
						<input type="submit" name="delete" value="delete"/>
					</div>
				</form>	
			</div>
		</article>
	</main>

	
</body>
</html>