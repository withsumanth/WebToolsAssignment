<%@page import="java.util.HashSet"%>
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
	<li><a href="index.html">Home</a></li>
		</br>
		<li><a href="books.html">Books</a></li>
		</br>
		<li><a href="music.html">Music</a></li>
		</br>
		<li><a href="computer.html">Computers</a></li>
		</br>
	</ul>
	</nav>
	<div class="vl">&nbsp;&nbsp;
Cart Details
<hr>
<br>
<%
		HashSet<String> cart = new HashSet();
		cart = (HashSet) session.getAttribute("cartValues");
		if(cart==null){
			out.println("No items to Display");
		}else{
%>
	<form method="post" action="index.htm">
  <%
		for (String v : cart) {
			out.println("<input type='checkbox' name='removedCart' value='"+v+"'>"+v+"<br><br>");
		}
	%>
	<input type="hidden" name="add" value="remove">
  <input type="submit" value="Remove From Cart">
  <% }%>
  </div>
</form>
</body>
</html>