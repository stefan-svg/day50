<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz proizvodjaca</title>
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

.form-container {
	width: 40%;
}

.form {
	display: flex;
	flex-direction: column;
}

.form input {
	height: 2.5rem;
	font-size: 1.6rem;
}

.form input[type="submit"] {
cursor: pointer;
  border: none;
  background-color: #14a020;
  color: #f9e9ff;
  padding: 0.5rem;
  border-radius: 5px;
  letter-spacing:3px;
  font-size:1.6rem;
  margin-top: 2%;
  width:6rem;
}

.cancel input {
  height: 2.5rem;
  cursor: pointer;
  border: none;
  background-color: #F54949;
  color: #f9e9ff;
  padding: 0.5rem;
  border-radius: 5px;
  letter-spacing:2px;
  font-size:1.6rem;
  margin-top: 2%;
}

</style>
</head>
<body>
		<header>
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
		<jsp:include page="/WEB-INF/fragment/login_user.jsp" flush="true" />
	</header>
	<div class="container">
		<h2>Trenutni podaci o proizvodjacu</h2>
			<div class="form-container">
				<form class="form"  action="/testwebapp/application/manufacturer/edit?pib=${manufacturer.pib}" method="post">
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
					<input type="submit" name="edit" value="edit"/>
				</form>
				<form class="cancel" action="/testwebapp/application/manufacturer/cancel" method="post">
						<input type="submit" name="cancel" value="cancel"/>
				</form>
			</div>
		</div>
</body>
</html>