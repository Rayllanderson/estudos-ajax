<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">

*{
text-align: center;
}

input[type=text], input[type=password], input[type=submit] {
	margin-bottom: 5px;
	border-radius: 1px;
}



</style>
</head>
<body>

	<h1>Autenticar user</h1>
	<form action="LoginServlet" method="post">
		<input  id="login" name="login" type="text" placeholder="Login">
		<br>
		<input id="password" name="password" type="password" placeholder="Password" >
		<br>
		<input type="submit" value="Login">
	</form>
	
	<script type="text/javascript">
	
	const error = "${error}";
	if(!error == ''){
		alert(error);
	}
	</script>
</body>
</html>