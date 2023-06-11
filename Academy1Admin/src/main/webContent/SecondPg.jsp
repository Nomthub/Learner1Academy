<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<h1>
Welcome to Learner's Academy, <%=session.getAttribute("uname") %>
<br> 
Login Successful!
</h1>
<h3>Choose what you would like to do</h3><br>

<a href="SettingUpMaster.jsp">Set up a master list</a><br>
<a href="AssignIt.jsp">Assign</a><br>
<a href="GetMasterList.jsp">Get Student List</a><br>
<a href="MakeReport.jsp">Class Report</a><br>
<br>
<form action=Logout>
<input type = submit value=Logout>
</form>
</body>
</html>