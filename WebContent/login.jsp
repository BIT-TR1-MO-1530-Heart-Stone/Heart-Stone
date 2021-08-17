<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LOGIN</title>
<link rel="stylesheet" type="text/css" href="login.css"/>
</head>
<body>
<form action="loginServlet" method="post">
	<div id="login">  
        <h1>Login</h1>    
            <input type="text" required="required" placeholder="Username" name="username"></input>  
            <input type="password" required="required" placeholder="Password" name="password"></input>   
            <button class="but" type="submit">Login</button>
            <br>
            <button class="but" onclick = "window.location.href = 'register.jsp'">Sign up</button>
            

            
            
        </form>  
    </div>  
</body>
</html>
