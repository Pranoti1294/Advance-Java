package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter printWriter = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dba","root","root");
			
			Statement statement = connection.createStatement();	
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String qryString = "select * from user where username='"+username+"' and password='"+password+"'";
			
			ResultSet resultset = statement.executeQuery(qryString);
			
			if(resultset.next()) {
				printWriter.print("<h1>Welcome "+username+"</h1>");
				HttpSession httpSession = request.getSession();
				
				 httpSession.setAttribute("usernameSession", username);
				response.sendRedirect("ProfileServlet");
				
			}else {
				printWriter.println("<script>alert('Invalid username and password')</script>");
				printWriter.println("<script>location.href='index.html'</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
