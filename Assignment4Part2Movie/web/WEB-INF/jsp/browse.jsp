<%-- 
    Document   : browse.jsp
    Created on : Feb 20, 2018, 8:24:16 PM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Movies</title>
    </head>
    <body style="background-color:lightgoldenrodyellow;">
        <h1>Searching Movies</h1>
        <form action="search.htm" method="post">
            Keyword: &nbsp;&nbsp;&nbsp;<input type="text" name="keyword"><br><br>
            <input type="radio" name="searchVal" value="Search By Title">Search By Title<br><br>
            <input type="radio" name="searchVal" value="Search By Actor" checked=true>Search By Actor<br><br>
            <input type="radio" name="searchVal" value="Search By Actress">Search By Actress<br><br>
            <input type="submit" value="Search Movies">
        </form>
    </body>
</html>
