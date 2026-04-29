package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/fact")
public class FactorialServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		int fact =1;
		for(int i=1;i<=num;i++) {
			fact=fact*i;
		}
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.println("<center><h1>");
		pw.println("The Factorial for number : "+num+" and Factorial is -> "+fact+"<br><br>");
		pw.println("</center></h1>");
		RequestDispatcher rs = request.getRequestDispatcher("index.html");
		rs.include(request, response);
	}

}
