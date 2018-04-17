<%-- 
    Document   : addbook
    Created on : Feb 21, 2018, 10:45:27 PM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Book Details</title>
    </head>
    <body style="background-color:yellow;">
        <h1>Enter Book Details</h1>
        <form action="addsuccess" method="post">
        <input type="hidden" name="addedBy"
						value="${sessionScope.user.personID}">
        <table name="booktable" border="1px solid">
            <tr>
                <th>ISBN</th>
                <th>Book Title</th>
                <th>Authors</th>
                <th>Price</th>
            </tr>
            <c:forEach begin="1" end="${requestScope.noOfBooks}" var="i">
                    <tr name="book${i}">
                        <td><input name="isbn${i}" type="text" required="true"></td>
                        <td><input name="title${i}" type="text" required="true"></td>
                        <td><input name="authors${i}" type="text" required="true"></td>
                        <td><input name="price${i}" type="number" step="0.0001" min="1" required="true"></td>
                    </tr> 
                </c:forEach>
        </table>
             <br> <br>
                    <input type="submit" value="Add Books">          
        </form>
    </body>
</html>
