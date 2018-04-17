<%-- 
    Document   : add
    Created on : Feb 20, 2018, 8:24:49 PM
    Author     : Sumanth
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie to Database</title>
    </head>
    <body style="background-color:lightgreen;">
        <h1>Please enter the details below:</h1>
        <form:form action="addmovie" commandName="movie" method="post">
            Movie Title:<form:input path="title" /><form:errors path="title"/><br><br>
            Lead Actor:<form:input path="actor" /><form:errors path="actor"/><br><br>
            Lead Actress:<form:input path="actress" /><form:errors path="actress"/><br><br>
            Genre:<form:input path="genre" /><form:errors path="genre"/><br><br>
            Year:<form:input path="year" /><form:errors path="year"/><br><br>
            <form:hidden path="addedBy"
						value="${sessionScope.user.personID}" />
            <input type="submit" value="Add Movie">
        </form:form>
    </body>
</html>
