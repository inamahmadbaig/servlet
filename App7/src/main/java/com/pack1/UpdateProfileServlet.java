package com.pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		Cookie arr[] = request.getCookies();
		String userName =null;
		
		if(arr == null) {
			request.setAttribute("msg", "Session Expired!!");
			request.getRequestDispatcher("Regiter.jsp").forward(request, response);
		}else {
			ServletContext context = request.getServletContext() ;
			UserBean ub = (UserBean) context.getAttribute("userBean");
			
			ub.setFirstName(request.getParameter("firstname"));
			ub.setLastName(request.getParameter("lastname"));
			ub.setMailId(request.getParameter("mailid"));
			ub.setPhoneNumber(request.getParameter("phone"));
			
			int rowCount = new UpdateProfileDAO().updateProfile(ub);
			if(rowCount>0) {
				request.setAttribute("msg", "Profile Updated");
				for(Cookie c:arr) {
					if("ck1".equals(c.getName())) {
						userName = c.getValue();
					}
				}
				request.setAttribute("UserName", userName);
				request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response);
			
			}
			else {
				throw new RuntimeException("profile not updeted");
			}
			
		}
	}
}
