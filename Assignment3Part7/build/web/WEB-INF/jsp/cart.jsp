<%@page import="java.util.HashSet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
.vl {
	border-left: 1px solid;
	height: 100%;
	margin-left: 100px;
	float: none;
}

.vl {
	margin-left: 200px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<nav>
	<ul style="margin-top: 2%; list-style-type: none; float: left">
	<li><a href="home.htm?action=home">Home</a></li></br>
        <li><a href="books.htm?action=books">Books</a></li></br>
        <li><a href="music.htm?action=music">Music</a></li></br>
        <li><a href="computer.htm?action=computers">Computers</a></li></br>
	</ul>
	</nav>
	<div class="vl">&nbsp;&nbsp;
Cart Details
<hr>
<br>

<c:choose>
                <c:when test="${empty cartValues}">
                    <p> No items to Display</p></div>
                </c:when>
                <c:otherwise>
                    <form method="post" action="home.htm">
                    <c:forEach items="${cartValues}" var="crt">
                    <input type='checkbox' name='removedCart' value='${crt}'>${crt}<br><br>
                    </c:forEach>
                    <input type="hidden" name="add" value="remove">
                        <input type="submit" value="Remove From Cart">
                        </div>
                </form>
                </c:otherwise>
            </c:choose>
</body>
</html>