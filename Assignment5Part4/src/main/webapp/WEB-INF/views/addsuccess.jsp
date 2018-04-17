<%-- 
    Document   : addsuccess
    Created on : Feb 21, 2018, 11:15:11 PM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Added</title>
    </head>
    <body style="background-color:lightgreen;">
        <h1>${requestScope.noOfBooks} books added successfully</h1><br>
        <a href="book.htm">Click here to go back to Main Page</a>
    </body>
</html>
