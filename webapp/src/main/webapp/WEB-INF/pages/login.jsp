<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
	<meta charset="UTF-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<title>Login</title>

<style>
	body {
  margin: 0;
}

.flex-center {
  display: flex;
  justify-content: center;
  align-items: center;
}

.h-cover {
  height: 100vh;
}

.login {
  background-image: url("https://wallpaperaccess.com/full/51381.jpg");
  background-size: cover;
}

.login-container {
  padding: 1.5rem;
  -webkit-backdrop-filter: blur(10px) brightness(0.7);
          backdrop-filter: blur(10px) brightness(0.7);
  text-align: center;
  font-size: 1.3rem;
  color: #f9e9ff;
}

.logo {
  margin-bottom: 2rem;
}
.logo h1 {
  margin-bottom: 0;
}

.input {
  margin: 2rem auto;
}

.registration-link {
  margin: 2rem auto 0.5rem;
}

input {
  font-size: 1.3rem;
}

.btn {
  cursor: pointer;
  border: none;
  background-color: #14a020;
  color: #f9e9ff;
  padding: 0.5rem;
  border-radius: 5px;
  letter-spacing:2px;
  font-size:1.6rem;
}


.input-floating {
  position: relative;
}
.input-floating input {
  width: 100%;
  border: none;
  outline: none;
  background-color: #f9e9ff;
  border-radius: 5px;
  padding: 1rem 0.5rem;
}
.input-floating input:not(:-moz-placeholder-shown) + label {
  top: 0;
  left: 0.5rem;
  font-size: 0.8rem;
  transform: none;
}
.input-floating input:not(:-ms-input-placeholder) + label {
  top: 0;
  left: 0.5rem;
  font-size: 0.8rem;
  transform: none;
}
.input-floating input:focus + label, .input-floating input:not(:placeholder-shown) + label {
  top: 0;
  left: 0.5rem;
  font-size: 0.8rem;
  transform: none;
}
.input-floating input.invalid {
  border: 2px solid red;
}
.input-floating input.invalid + label {
  color: red;
}
</style>
</head>
<body class="flex-center h-cover login">
	<div class="login-container">
		<div>${error_message}</div>
		<form action="/testwebapp/application/login" method="post">
		<div class="input input-floating">
			<input type="text" name="username" id="username" placeholder="Username">
		</div>
		<div class="input input-floating">
			<input type="password" name="password" id="password" placeholder="Password">
		</div>
		<div class="input">
				<input type="submit" value="Login" name="login" class="btn" id="login">
		</div>
		</form>
	</div>
</body>
</html>
