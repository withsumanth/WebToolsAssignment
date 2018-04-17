import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SavingCartServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("add").equals("add")) {
			HashSet<String> cart;
			if (null != session.getAttribute("cartValues")) {
				cart = (HashSet<String>) session.getAttribute("cartValues");
			} else {
				cart = new HashSet();
			}
			String[] val = request.getParameterValues("cartVal");
			if(val!=null) {
				for (String v : val) {
					cart.add(v);
				}
				session.setAttribute("cartValues", cart);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		} else if (request.getParameter("add").equals("remove")) {
			HashSet<String> cartRemove = new HashSet();
			cartRemove = (HashSet) session.getAttribute("cartValues");
			String[] val = request.getParameterValues("removedCart");
			if(val!=null) {
				for (String v : val) {
					for (String cart : cartRemove) {
						if (cart.equals(v)) {
							cartRemove.remove(cart);
							break;
						}
					}
				}
				session.setAttribute("cartValues", cartRemove);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		}
	}
}
