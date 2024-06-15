package com.studentcrud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.studentcrud.daoimpl.StudentDaoImpl;


public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    StudentDaoImpl studentDaoImpl;
    public StudentDeleteController() {
        super();
        studentDaoImpl = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
    	try {
    		int id = Integer.parseInt(request.getParameter("id"));
    		int result = studentDaoImpl.remove(id);
			if(result>0)
			{
				printWriter.println("<h3>Student deleted</h3>");
				response.sendRedirect("/RegisterStudent");
			}
			else {
				printWriter.println("<h3>Problem in deletion</h3>");
			}
		} catch (Exception e) {
			printWriter.println("<h2>something went wrong</h2>");
			e.printStackTrace();
		}
    	super.service(request, response);
    }
	

}
