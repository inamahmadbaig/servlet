package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/even")
public class EvenServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));

		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.println("<center><h1>");
		if(num%2==0) {
			pw.println(num+ " is Even Number");
		}else {
			pw.println(num+" is odd Number");
		}
		
		pw.println("</center></h1>");
		RequestDispatcher rs = request.getRequestDispatcher("index.html");
		rs.include(request, response);
	}

}
