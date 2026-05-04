package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/view")
public class ViewEmployeeServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ViewEmoDAO view = new ViewEmoDAO();
		ArrayList<EmpBean> al = view.reterive_empData();
		request.setAttribute("list", al);
		request.getRequestDispatcher("ViewEmployee.jsp").forward(request, response);
	}
}
