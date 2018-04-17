import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormInputServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Enumeration<String> user = request.getParameterNames();
		out.println("<html>");
		out.println("<style>table, th,td{border: 1px solid black;</style>");
		out.println("<h1>Part 4 - Petition Form using getParameterMap()</h1>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><th>Name</th><th>Value</th><th>Extra Values</th></tr>");
		while(user.hasMoreElements()) {
			String name = (String) user.nextElement();
			String[] value = request.getParameterValues(name);
			if(value[0]!="") {
				out.println("<tr>");
				out.println("<td>" + name + "</td>");
				for (int i = 0; i < value.length; i++) {
					out.println("<td>" + value[i] + "</td>");
				}
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
