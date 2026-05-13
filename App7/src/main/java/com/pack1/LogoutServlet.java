package com.pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		Cookie arr[] = request.getCookies();
		if(arr == null ) {
			request.setAttribute("msg", "Session Expired");
		}else {
			ServletContext context = request.getServletContext();
			
			context.removeAttribute("userBean");
			arr[0].setMaxAge(0);
			response.addCookie(arr[0]);
			request.setAttribute("msg", "User LoggedOut Successfully!!");
			request.getRequestDispatcher("Regiter.jsp").forward(request, response);
			
		}
	}
}
