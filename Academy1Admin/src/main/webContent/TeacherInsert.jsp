<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set teacher list</title>
</head>
<body>
<h3>To add a teacher, complete below</h3><br>

<form action="SetTeacherList" method="post"> 
 
        <!-- Create an element with mandatory name attribute, 
        so that data can be transfer to the servlet using getParameter() -->
        
      Enter the Teacher ID:    <input type="text" name="TId"/><br> 
       
      Enter the first name:  <input type="text" name="Fstname"/><br>
      
      Enter the last name:  <input type="text" name="Lstname"/><br>
        <br/><br/><br/> 
        <input type=submit value=Add/> 
    </form>
<h3>All the teachers</h3>
</body>
</html>