<%@page import="com.java.Bean.Course"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
     <c:when test = "${check == 'false'}">
         <c:redirect url="searchCourse.htm?action=loggedin"/>
     </c:when>
     <c:otherwise>
<!DOCTYPE html>
<html>
<head>
<title>Available Courses are:</title>
</head>
<body>
	<form method='post' action='course.htm'>
		<h2>Results found</h2>
		<c:import url="menu.jsp" /><br>
		<br>
                <c:forEach items="${searchResults}" var="res">
                  <input type="checkbox" name="crn" value="${res.crn}"/>${res.crn}-${res.name}[<a href = "mycourses.htm?action=add&crn=${res.crn}">Add Course</a>]<br/> 
                </c:forEach>
		<input type='hidden' name='action' value='add' /> <input type='submit'
			value='Add selected courses'>
	</form>
</body>
</html>
</c:otherwise>
</c:choose>