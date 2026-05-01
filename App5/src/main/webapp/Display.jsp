<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>
			<%
				String pName = request.getParameter("pname");
				String pId = request.getParameter("pid");
				String Quantity = request.getParameter("pqty");
				String price = request.getParameter("price");
				
				out.println("Product Name : "+pName+"<br><be>");
				out.println("Product id : "+pId+"<br><be>");
				out.println("Product Quantity : "+Quantity+"<br><be>");
				out.println("Product Price : "+price+"<br><be>");
			
			%>
		</h1>
	</center>
</body>
</html>