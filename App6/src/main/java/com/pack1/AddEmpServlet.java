package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aes")
public class AddEmpServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpBean b = new EmpBean();
		b.seteId(request.getParameter("eid"));
		b.seteFName(request.getParameter("efname"));
		b.seteLName(request.getParameter("elname"));
		b.seteSal(Integer.parseInt(request.getParameter("esal")));
		b.seteAdd(request.getParameter("eadd"));
		
		AddEmpDAO addEmpDAO = new AddEmpDAO();
		
		int rowCount =addEmpDAO.insertEmpData(b);
		
		if(rowCount>0) {
			request.setAttribute("msg", "Employee Inserted Succesfuly!!!");
		}else {
			throw new RuntimeException("Employee Record Not inserted!!!");
		}
		
		request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
	}
}
