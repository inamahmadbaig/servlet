package com.pack1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/ms")
public class MainServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("choice");
		if(data.equals("GetFactorial")) {
			RequestDispatcher rs = request.getRequestDispatcher("/fact");
			rs.forward(request, response);
		}else{
			RequestDispatcher rs = request.getRequestDispatcher("/even");
			rs.forward(request, response);
		}
	}

}
