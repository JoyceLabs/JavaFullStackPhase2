<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login access page</title>
</head>
<body>
logout jsp welcome<% session.invalidate(); %> 

<% response.sendRedirect("Login.html"); %> 


</body>
</html>