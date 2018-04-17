import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;


public class ShowRequestHeaders extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<style>table, th,td{border: 1px solid black;</style>");
		out.println("<h1>Part 2 - Display Request Headers using getHeaderNames and getHeaders</h1>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");
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
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}