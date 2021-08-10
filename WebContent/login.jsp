<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LOGIN</title>
</head>
<body>
	<form action="loginServlet" method="post">
 
		username: <input type="text" name="username" placeholder="username">
		 <br><br>
		 password: <input type="password" name="password" placeholder="password">
		<br> <br>
		 <input type="submit" value="login">
		 <a href="register.jsp">register </a>
 
	</form>
</body>
</html>