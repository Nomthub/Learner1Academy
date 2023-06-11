<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Class List</title>
</head>
<body>
<h3>To add a class, complete below</h3><br>
<form action="SetClassList" method="post"> 
         
        <!-- Create an element with mandatory name attribute, 
        so that data can be transfer to the servlet using getParameter() -->
        
      Enter the Class ID:    <input type="text" name="CId"/><br> 
        
      Enter the Class name:  <input type="text" name="Subname"/><br>
      
        <br/><br/><br/> 
        <input type="submit" value="Add"/> 
    </form>
<h3>All the subjects for all classes</h3><br>
</body>
</html>