<%@page import="com.pack1.UserBean"%>
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
		<h2>
			<%
			 UserBean ub = (UserBean) application.getAttribute("userBean");
			
			out.println("Welcom - "+ub.getuName()+"<be><be>");

			%>
			<br><br>
			<a href="view">View Profile</a><br><br>
			<a href="logout">Logout</a><br><br>
		</h2>
	
	</center>
</body>
</html>