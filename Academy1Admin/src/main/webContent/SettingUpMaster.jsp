<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Up Master List</title>
</head>
<body>
<h1>Set a master list, <%=session.getAttribute("uname") %>
</h1><br>
<a href="TeacherInsert.jsp">Set Teacher master list</a><br>
<a href="ClassInsert.jsp">Set Class master list</a><br>
<a href="SubjectInsert.jsp">Set Subject master list</a>
</body>
</html>