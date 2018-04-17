<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--By default this is true-->
<!--Even if this line is removed, by default the session will continue.-->
<!--Session is an implicit object in JSP-->
<%@ page session="true" %>
<%@page import="com.java.Bean.Course"%>
<c:set var="check" value="false"/>
<c:forEach items="${cookie}" var="co">
    <c:if test = "${co.value.value == 'admin'}">
    <c:set var="check" value="true"/>
</c:if>
</c:forEach>
<c:if test = "${username == 'admin'}">
    <c:set var="check" value="true"/>
 </c:if>
 <c:choose>
     <c:when test = "${check == 'true'}">
         <p>in<p>
         <c:redirect url="searchCourse.jsp"/>
     </c:when>
     <c:otherwise>
<!DOCTYPE html>
<html>
    <head>
        <title>NEU Courses</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    <body>
        <div>
            <h1>Login</h1>
            <form name='myForm' method="post" action="login.do?action=login">
                <input type="text" name="username" placeholder="Username" /><br/><br/>
                <input type="password" name="password" placeholder="Password"  /><br/><br/>                
                <input type="checkbox" name="rememberMe" value="remember" /> Remember me  <br/><br/>
                <input type="submit" value="Log In" />
            </form>
        </div>
    </body>
</html>
</c:otherwise>
</c:choose>
