<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Part 3</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
<h1>Part 3 - Display Request Headers using getHeaderNames and getHeaders using JSP</h1>
</head>
<body>
<table>
<tr>
<th>Header Name</th>
<th>Header Value</th>
</tr>
<%
Enumeration headerNames = request.getHeaderNames();
while (headerNames.hasMoreElements()) {
	String name = (String) headerNames.nextElement();
	Enumeration values = request.getHeaders(name); // support multiple values
	if (values != null) {
		while (values.hasMoreElements()) {
			String value = (String) values.nextElement();
			out.println("<tr>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");
		}
	}
}

%>
</table>
</body>
</html>