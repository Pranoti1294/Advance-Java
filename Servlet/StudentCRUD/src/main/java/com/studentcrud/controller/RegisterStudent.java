package com.studentcrud.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.studentcrud.daoimpl.StudentDaoImpl;
import com.studentdrud.module.Student;
 
/**
 * Servlet implementation class RegisterStudent
 */
//@WebServlet("/RegisterStudent")
public class RegisterStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    StudentDaoImpl studentDaoImpl;
    
    public RegisterStudent() {
        studentDaoImpl = new StudentDaoImpl();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try {
			
			List<Student> studentList = studentDaoImpl.getAll();
			
			printWriter.println("<table border='1', cellspecing='0' cellpadding='10'>");
			
			printWriter.println("<tr>");
			printWriter.println("<th>ID</th>");
			printWriter.println("<th>Name</th>");
			printWriter.println("<th>Phone</th>");
			printWriter.println("<th>Marks</th>");
			printWriter.println("<th>City</th>");
			printWriter.println("<th>Gender</th>");
			printWriter.println("<th>Actions</th>");
			printWriter.println("</tr>");
			
			Iterator<Student> studentIterator = studentList.iterator();
			while(studentIterator.hasNext()) {
				Student student = studentIterator.next();
				printWriter.println("<tr>");
				
				printWriter.println("<td>"+student.getId()+"</td>");
				printWriter.println("<td>"+student.getName()+"</td>");
				printWriter.println("<td>"+student.getPhone()+"</td>");
				printWriter.println("<td>"+student.getMarks()+"</td>");
				printWriter.println("<td>"+student.getCity()+"</td>");
				printWriter.println("<td>"+student.getGender()+"</td>");
				printWriter.println("<td> <a href='StudentDeleteController?id="+student.getId()+"'>Delete</a> </td>");
				printWriter.println("<tr>");
				
			}
			printWriter.println("</table>");
			
		} catch (Exception e) {
			printWriter.println("<h2>something went wrong</h2>");
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try {
			Student student = new Student();
			student.setId(Integer.parseInt(request.getParameter("id")));
			student.setName(request.getParameter("name"));
			student.setCity(request.getParameter("city"));
			student.setGender(request.getParameter("gender"));
			student.setPhone(request.getParameter("phone"));
			student.setMarks(Float.parseFloat(request.getParameter("marks")));
			
			
			int result = studentDaoImpl.save(student);
			
			if (result>0) {
				printWriter.println("<h3>Student registred</h3>");
			}
			else {
				printWriter.println("<h3>Student registration failed</h3>");
			}
		} catch (Exception e) {
			printWriter.println("<h2>something went wrong</h2>");
			e.printStackTrace();
		}
		
	}

}
