<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>register</title>
<link rel="stylesheet" type="text/css" href="register.css"/>
</head>
<body>
 	<form action="registerServlet" method="post">
 	


	<div id="register">  
	        <h1>register</h1>
	                <input type="text" required="required" placeholder="Username" name="username"></input>
	                <input type="text" required="required" placeholder="Password" name="password"></input>
	                <input type="text" required="required" placeholder="Email" name="email"></input>
	                <input type="text" required="required" placeholder="Gender" name="gender"></input>
	                <input type="text" required="required" placeholder="Country" name="country"></input>
	                <input type="text" required="required" placeholder="first_name" name="first_name"></input>
	                <input type="text" required="required" placeholder="Last_name" name="last_name"></input>
	                <button class="but" type="submit">Sign up</button>
	</form>
    </div>  
</body>
</html>