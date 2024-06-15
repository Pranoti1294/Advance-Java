package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter printWriter = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			String name = cookies[0].getName();
			if(name.equals("usernameCookie")) {
				String namevalue =  cookies[0].getValue();
				printWriter.println("<h4>Welcome"+namevalue+"</h4>");
				printWriter.println("<a href='LogoutServlet'>Logout</a>");
			}
			else {
				response.sendRedirect("index.html");
			}
		}else {
			response.sendRedirect("index.html");
		}
	}

	
}
