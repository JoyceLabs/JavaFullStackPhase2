<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body>
	<h1 align="center">Welcome to Sporty Shoes</h1>
	<h1 align="center">Administration Menu</h1>
	<h1 align="left">Welcome <%= session.getAttribute("login") %>!  |  <a href="logout.jsp">logout</a></h1></br>
	
<form >
	<h1 align="left"><a href="ListShoes">Shoes</a>  |  <a href="ListPurchaseReport">Purchases Report</a></h1></br>
</form>

</body>
</html>