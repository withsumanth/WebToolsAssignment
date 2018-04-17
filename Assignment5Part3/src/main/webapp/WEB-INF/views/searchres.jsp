<%-- 
    Document   : searchres
    Created on : Feb 21, 2018, 2:03:58 AM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body style="background-color:lightgreen;">
        <p>You searched for "${requestScope.map.keyword}"</p>
        <h3><u>Here are the search Results</u></h3>
        <table border="1px solid">
            <tr>
                <th>Movie title</th>
                <th>Lead Actor</th>
                <th>Lead Actress</th>
                <th>Genre</th>
                <th>Year</th>
            </tr>
            <c:forEach items="${requestScope.map.movList}" var="mov">
                    <tr>
                        <td>${mov.title}</td>
                        <td>${mov.actor}</td>
                        <td>${mov.actress}</td>
                        <td>${mov.genre}</td>
                        <td>${mov.year}</td>
                    </tr> 
                </c:forEach>
        </table>
        <a href="movie.htm">Click here to go back to the main page</a>
    </body>
</html>
