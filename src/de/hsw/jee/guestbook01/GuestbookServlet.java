package de.hsw.jee.guestbook01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestbookServlet
 */
@WebServlet("/guestbook")
public class GuestbookServlet extends HttpServlet {
       
	private GuestbookService guestbookService = new GuestbookServiceMock();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		guestbookService.insert(
			req.getParameter("username"),
			req.getParameter("title"),
			req.getParameter("message")
		);
		resp.sendRedirect(req.getContextPath() + "/guestbook");
	}
	
	protected void doGet(
		HttpServletRequest request, 
		HttpServletResponse response
	) throws ServletException, IOException {
		
		response.getWriter().print("<html><body><h1>Guestbook</h1><ul>");
		
		for(GuestbookEntry entry : guestbookService.getAll()) {
			
			String toPrint = "<li>Von: " + entry.getMessage() + "</li>";
			response.getWriter().println(toPrint);
		}
	
		response.getWriter().print("</ul></body></html>");
		
		final String action = request.getContextPath() + "/guestbook";
		
		final StringBuffer sb = new StringBuffer()
			.append("<form method=\"POST\" action=\"")
					.append(action).append("\" >")
				.append("<input type=\"text\" name=\"username\" >")
				.append("<input type=\"text\" name=\"title\" >")
				.append("<textarea name=\"message\" ></textarea>")
				.append("<input type=\"submit\" name=\"Senden\" >")
			.append("</form>");
		
		
		response.getWriter().println(sb.toString());
		
			
	}


}
