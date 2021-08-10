
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>register</title>
</head>
<body>
 
	<form action="registerServlet" method="post">
		<input type="text" name="username" placeholder="username"> <input
			type="password" name="password" placeholder="password"><input
			type="email" name="email" placeholder="email"><input
			type="text" name="gender" placeholder="gender"><input
			type="text" name="country" placeholder="country"><input
			type="text" name="first_name" placeholder="first_name"><input
			type="text" name="last_name" placeholder="last_name"> <input
			type="submit" value="register">
	</form>
 
</body>
</html>