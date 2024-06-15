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

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProfileServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//request.getSession(false);
    	response.setContentType("text/html");
		
		PrintWriter printWriter = response.getWriter();
    	
    	try {
			HttpSession session = request.getSession(false);
			
			if(session!=null) {
				String usernameString =(String) session.getAttribute("usernameSession");
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dba","root","root");
				
				Statement statement = connection.createStatement();
				
				String qryString = "select * from user where username='"+usernameString+"'";
				
				ResultSet resultset = statement.executeQuery(qryString);
				
				if (resultset.next()) {
					int id = resultset.getInt("id");
					String phone = resultset.getString("phone");
					String email = resultset.getString("email");
					printWriter.println("<h2>Welcome "+usernameString+"</h2>");
					printWriter.println("<h5>Phone number "+phone+"</h5>");
					printWriter.println("<h5>Email id  "+email+"</h5>");
					printWriter.println("<h5>ID  "+id+"</h5>");
					printWriter.println("<a href='LogoutServlet'>Logout</a>");
				}
			}else {
				response.sendRedirect("index.html");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
	
}
