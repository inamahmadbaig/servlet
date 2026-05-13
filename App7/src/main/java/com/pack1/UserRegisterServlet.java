package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegisterServlet")
public class UserRegisterServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean u = new UserBean();
		u.setuName(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setFirstName(request.getParameter("firstname"));
		u.setLastName(request.getParameter("lastname"));
		u.setMailId(request.getParameter("mailid"));
		u.setPhoneNumber(request.getParameter("phone"));
		
		UserRegisterDAO dao = new UserRegisterDAO();
		int rowCount = dao.insert_UserData(u);
		
		if(rowCount>0) {
			request.setAttribute("msg", "user Register Succesfuly!!!");
			request.getRequestDispatcher("Regiter.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "user Register Failed??");
			request.getRequestDispatcher("Regiter.jsp").forward(request, response);
		}
		
//		request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
	}
}
