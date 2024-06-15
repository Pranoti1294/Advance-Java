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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernamString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		PrintWriter printWriter = response.getWriter();
		if(usernamString.equals("admin") && passwordString.equals("admin123")){
			 Cookie cookie = new Cookie("usernameCookie", usernamString);
			 cookie.setMaxAge(200);
			 response.addCookie(cookie);
			 response.sendRedirect("ProfileServlet");
		}else {
			printWriter.print("<script>alert('Invalid Username and Password'); location.href='index.html';</script>");

		}
	}

}
