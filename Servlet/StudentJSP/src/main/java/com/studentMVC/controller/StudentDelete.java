package com.studentMVC.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.studentMVC.serviceImpl.StudentServiceImpl;

@WebServlet("/deleteStudent") // Add appropriate URL mapping
public class StudentDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    StudentServiceImpl studentServiceImpl;

    public StudentDelete() {
        super();
        studentServiceImpl = new StudentServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        try {
            String idStr = request.getParameter("id");

            // Check if the id parameter is null or empty
            if (idStr == null || idStr.isEmpty()) {
                throw new IllegalArgumentException("ID parameter is missing or empty");
            }

            int id = Integer.parseInt(idStr); // This might still throw NumberFormatException if the string is not a valid integer
            int result = studentServiceImpl.remove(id);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("student-list.jsp");
            request.setAttribute("res", result);
            requestDispatcher.forward(request, response);

        } catch (NumberFormatException e) {
            printWriter.println("<h2>Invalid ID format</h2>");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            printWriter.println("<h2>" + e.getMessage() + "</h2>");
            e.printStackTrace();
        } catch (Exception e) {
            printWriter.println("<h2>Something went wrong</h2>");
            e.printStackTrace();
        }
    }
}
