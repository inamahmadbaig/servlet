package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/view")
public class ViewProfileServlet  extends HttpServlet{

	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		
		Cookie arr[] = request.getCookies();
		
		String UserName =null;
		if(arr==null) {
			request.setAttribute("msg", "Session Expired!!!");
			request.getRequestDispatcher("Regiter.jsp").forward(request, response);
		}else {
			for(Cookie c:arr) {
				if("ck1".equals(c.getName())) {
					UserName = c.getValue();
				}
			}
			request.setAttribute("UserName", UserName);
			request.getRequestDispatcher("ViewProfile.jsp").forward(request, response);
		}
	}
}
