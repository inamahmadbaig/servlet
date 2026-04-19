package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fs")

public class FirstServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("uname");
		String mail = req.getParameter("umail");
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
//		System.out.println("User Name : "+name);
//		System.out.println("User Mail : "+mail);
		pw.println("<center><h1>");
//		pw.println("Users Data<b><b>\n");
		pw.println("User Name: "+name+"<b><b>");
		pw.println("User Mail_Id: "+mail+"<b><b>");
		pw.println("</h1></center>");
	}

}
