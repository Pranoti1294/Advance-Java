package com.studentMVC.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.studentMVC.model.Student;
import com.studentMVC.serviceImpl.StudentServiceImpl;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	StudentServiceImpl studentServiceImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        studentServiceImpl = new StudentServiceImpl(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			List<Student> studentList = studentServiceImpl.getAll();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("student-list.jsp");
			request.setAttribute("studentlist", studentList);
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			float marks = Float.parseFloat(request.getParameter("marks"));
			
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String city = request.getParameter("city");
			String gender = request.getParameter("gender");
			
			Student student =new Student(id, name, phone, marks, city, gender);
			int result = studentServiceImpl.save(student);
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
			
			if (result>0) {
				request.setAttribute("msg", "Student Register successfully.. :)");
			}else {
				request.setAttribute("msgError", "Something went occur... :(");
			}
			requestDispatcher.forward(request, response);
			
 		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
