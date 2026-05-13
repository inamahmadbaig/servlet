package com.pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	   UserBean	bean = new UserLoginDAO().login(request.getParameter("uname"), request.getParameter("upwd"));
	   
	   if(bean == null) {
		   request.setAttribute("msg", "invaild Login Credentals!!");
		   request.getRequestDispatcher("Regiter.jsp").forward(request, response);
		  
	   }else {
		   ServletContext context = request.getServletContext();
		   context.setAttribute("userBean", bean);
		   
		   Cookie ck = new Cookie("ck1", bean.getuName());
		   response.addCookie(ck);
		   request.getRequestDispatcher("Home.jsp").forward(request, response);

		   
	   }
	}
}
