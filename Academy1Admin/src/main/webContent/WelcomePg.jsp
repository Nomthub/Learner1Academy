<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
	if(session.getAttribute("uname")==null){
		response.sendRedirect("LoginPg.jsp");
	}
	else{
		response.sendRedirect("SecondPg.jsp");
	}
%>
</body>
</html>