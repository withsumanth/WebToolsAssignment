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
		Map<String, String[]> user = new HashMap();
		user = request.getParameterMap();
		out.println("<html>");
		out.println("<style>table, th,td{border: 1px solid black;</style>");
		out.println("<h1>Part 4 - Petition Form using getParameterMap()</h1>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><th>Name</th><th>Value</th><th>Extra Values</th></tr>");
		for (Entry<String, String[]> e : user.entrySet()) {
			if (e.getValue()[0]!="") {
				out.println("<tr>");
				out.println("<td>" + e.getKey() + "</td>");
				for (int i = 0; i < e.getValue().length; i++) {
					out.println("<td>" + e.getValue()[i] + "</td>");
				}
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
