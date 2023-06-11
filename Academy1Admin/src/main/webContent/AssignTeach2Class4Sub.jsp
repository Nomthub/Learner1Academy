<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign teacher to class for subject</title>
</head>
<body>
<form action="UpdateClassTeach" method="post">
Enter your subject id:<input type="text" name="Subid"/><br/>

Enter your class id:<input type="text" name="Clsid"/><br/>

Enter your teacher id:<input type="text" name="Teachid"/><br/>
<input type="submit" value="Update"/>
</form>
</body>
</html>