import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormSingleServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		  out.println("<script language='JavaScript'>");
		  out.println("display = function(){");
		    out.println("var children = document.getElementById('noOfChildren').value;");
		    out.println("var form1Id = document.getElementById('form1');");
		    out.println("form1Id.parentNode.removeChild(form1Id);");
		    out.println("var text='';");
		    out.println("for(var i=0;i<children;i++){");
		    out.println("text=text+'Please enter the name of child number'+(i+1)+\"<br> <input type='text' name='noOfChild\"+(i+1)+\"'><br><br>\";");
		    out.println("}");
		    out.println("text = text+\"<input type='hidden' name='numberOfChild' value=\"+children+\">\";");
		    out.println("text = text+\"<input type='submit' value='Submit'>\";");
		    out.println("document.getElementById('form2').innerHTML= text;");
		  out.println("};");
		  out.println("</script>");
		  out.println("<form id=\"form1\">");
		    out.println("How many children do you have? <input type='number'  id='noOfChildren' name='noOfChildren' min='1' name='noOfChild'><br>");
		    out.println("<input type='button'  value='submit' id = 'changeForm' onClick='display()'><br>");
		    out.println("</form>");
		    out.println("<form id='form2' action='formSingleServlet' method='post'>");
		    out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		int val = Integer.parseInt(request.getParameter("numberOfChild"));
			out.println("<html>");
			out.println("<body>");
			out.println("<p>Your children's names are:</p>");
			for(int i=0;i<val;i++) {
				out.println("<p>"+request.getParameter("noOfChild"+(i+1))+"</p>");
			}
			out.println("<body>");
			out.println("</html>");
	}
}
