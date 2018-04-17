<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books</title>
    </head>
    <body>
        <h1>How many books do you want to add</h1>
        <form action="books" method="post">
            <input type="number" name="noOfBooks" min="1" required="true">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
