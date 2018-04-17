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
         <c:redirect url="index.jsp"/>
     </c:when>
     <c:otherwise>
<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<html>
<head>
<title>Select Courses</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<!--This is html4 to disable cache-->
<!--add those line later-->
</head>
<body>
	<div>
		<h2>Search Courses</h2>
		<form id="form" action="course.do" method="get">
			<c:import url="menu.jsp" />
			<br /> <br /> Search Query <input type="text" name="query" /> <br />
			<br /> <input type="radio" name="searchType" value="crn" checked="" />
			Search By CRN <input type="radio" name="searchType" value="title" />
			Search By Instructor or Title <input type="hidden" name="action"
				value="search" /> <br />
			<input type="submit" value="SEARCH" />
		</form>
	</div>
</body>
</html>
</c:otherwise>
</c:choose>