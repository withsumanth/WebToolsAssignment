<%@page import="java.util.HashSet"%>
<%@page import="com.java.Bean.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course View</title>
</head>
<body>
	<c:import url="menu.jsp" />
	<h3>Courses Added:</h3>
            
	<c:choose>
                <c:when test="${empty myCourseSet}">
                    <div><p> No Course Added for you.</p></div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${myCourseSet}" var="cou">
                        CRN: ${cou.crn} - Course Name: ${cou.name} [<a href='mycourses.htm?action=remove&crn=${cou.crn}'>Remove Course</a>]<br/>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
</body>
</html>
</c:otherwise>
</c:choose>