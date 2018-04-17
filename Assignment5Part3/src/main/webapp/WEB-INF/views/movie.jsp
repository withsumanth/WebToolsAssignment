<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Store</title>
        <script>
            function myFunction() {
               var sel = document.getElementById("selection").value;
               if(sel==="browse"){
                   location.href = "browse.htm";
               }else{
                 location.href = "add.htm";
               }
            }
            </script>
    </head>

    <body style="background-color: pink;">
    <h1>Hi, ${user.firstName}</h1>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
        <h1>Welcome to our Movie Store</h1><br>
        <p>Please make your selection below</p>
        <select id ="selection" name="selection">
            <option value="browse">Browse Movies</option>
            <option value="add">Add New Movies to Database</option>
        </select>
            <button onclick="myFunction()">Send</button>
    </body>
</html>
