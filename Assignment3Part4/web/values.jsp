<%-- 
    Document   : values
    Created on : Feb 14, 2018, 5:51:47 PM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 4</title>
    </head>
    <body>        
        <c:set var = "noOfVal" scope = "session" value = "4"/>
        <p>Number of Values entered: <c:out value = "${noOfVal}"/></p>
        <h3>Values are:</h3>
        <c:forEach items="${requestScope.values}" var="val">
        <li>${val}</li>
        </c:forEach>
    <h3>Number of characters in each values</h3>
    <c:set var = "valLength" scope = "session" value = "1"/>
    <c:forEach items="${requestScope.values}" var="val">
        Length of Value ${valLength}<input type = "text" value="${fn:length(val)}"/><br>
        <c:set var = "valLength" scope = "session" value = "${valLength+1}"/>
    </c:forEach>
    <h3>Values in UpperCase</h3>
    <c:forEach items="${requestScope.values}" var="val">
        <li>${fn:toUpperCase(val)}</li>
        </c:forEach>
    <h3>Values in LowerCase</h3>
    <c:forEach items="${requestScope.values}" var="val">
        <li>${fn:toLowerCase(val)}</li>
        </c:forEach>
    <h3>Values Generated On</h3>
    <p>Formatted Date(dd-MM-yyyy) : 
        <fmt:formatDate pattern = "dd-MM-yyyy" value = "${requestScope.date}" var = "formattedDate"/>
    <c:out value="${formattedDate}" /></p>
        <fmt:parseDate value="${formattedDate}" var="parsedDate"  pattern="dd-MM-yyyy" />  
    <p>Parsed Date:<c:out value="${parsedDate}" /></p>  
    <h3>Example for format number</h3>
    <c:set var = "num" value = "120000.2309" />
    <p>Given Number: ${num}</p>
    <p>Formatted Number: <fmt:formatNumber type = "percent" 
         maxIntegerDigits = "3" value = "${num}" /></p>
</body>
</html>
