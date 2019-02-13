<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<form action="delete" >
	Enter valid profileId to delete the account:<input name="profileId"/><br><br>
	<input type="submit"/>
</form>
</body>
</html>