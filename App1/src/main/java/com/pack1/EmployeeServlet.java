package com.pack1;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/emp")
public class EmployeeServlet extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {

       

        // Get parameters
        String empName = request.getParameter("uname");
        String empId = request.getParameter("Id");
        String salStr = request.getParameter("sal");
        String expStr = request.getParameter("exp");
        
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        // Validation
        if (empName == null || empId == null || salStr == null || expStr == null ||
            empName.trim().isEmpty() || empId.trim().isEmpty() ||
            salStr.trim().isEmpty() || expStr.trim().isEmpty()) {

            pw.println("<h2 style='color:red;'>Please fill all fields!</h2>");
            return;
        }

        double empSal;
        int empExp;

        // Convert safely
        try {
            empSal = Double.parseDouble(salStr);
            empExp = Integer.parseInt(expStr);
        } catch (NumberFormatException e) {
            pw.println("<h2 style='color:red;'>Invalid salary or experience format!</h2>");
            return;
        }

        // Bonus logic
        if (empExp >= 5) {
            empSal *= 1.10; // 10% bonus
        }

        // Output
        pw.println("<center><h1>");
        pw.println("***** Employee Details *****<br><br>");
        pw.println("EmpName: " + empName + "<br>");
        pw.println("EmpID: " + empId + "<br>");
        pw.println("EmpSal: " + empSal + "<br>");
        pw.println("EmpExp: " + empExp + "<br>");
        pw.println("</h1></center>");
    }
}
