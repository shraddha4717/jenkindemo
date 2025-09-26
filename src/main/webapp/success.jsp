<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Page</title>
</head>
<body>
<form action="update">
</form>
<table border="3">
<tr>
	<th>ID</th>
	<th>BRAND</th>
	<th>Model</th>
	<th>Action</th>
</tr>



<c:forEach items="${data}" var="laptop">
            <tr>
                <td>${laptop.id}</td>       
                <td>${laptop.brand}</td>
                <td>${laptop.model}</td>
                <td><a href="delete?id=${laptop.id}">Delete</a></td>
                 <td><a href="edit?id=${laptop.id}">Edit</a></td>
                
                 <!-- Delete button that sends the laptop's ID to /delete -->
                
             
            </tr>
        </c:forEach>
        
       
</table>
</body>
</html>