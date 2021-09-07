<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>register</title>
<link rel="stylesheet" type="text/css" href="css/register.css"/>
</head>
<body>
 	<form action="registerServlet" method="post">
 	


	<div id="register">  
	        <h1>register</h1>
	                <input type="text" required="required" placeholder="email" name="email"></input>
	                <input type="text" required="required" placeholder="password" name="password"></input>
	                <input type="text" required="required" placeholder="fullname" name="fullname"></input>
	                <input type="text" required="required" placeholder="screenname" name="screenname"></input>
	                <input type="text" required="required" placeholder="phone_number" name="phone_number"></input>
                    
                    <input type="radio" name="gender" value="1"><font color="white">Male</font>
                    <input type="radio" name="gender" value="2"><font color="white">Female</font><br>
                    
	                
                    
	                <button class="but" type="submit">Sign up</button>
	            </div>
	</form>
	
     
</body>
</html>