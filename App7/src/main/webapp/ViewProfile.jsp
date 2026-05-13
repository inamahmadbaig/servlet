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
	 		String uname= (String) request.getAttribute("UserName");
	 		
	 		UserBean ub = (UserBean) application.getAttribute("userBean");
	 		
	 		out.println("This Session belongs to - "+ uname+" <br><br>");
	 		String pwd = ub.getPassword();
	 		String encryptPassword = pwd.substring(0, 1)+"*****"+pwd.substring( pwd.length()-1);
	 		out.println(ub.getuName()+"-"+encryptPassword+"-"+ub.getFirstName()+"-"+ub.getLastName()+"-"+ub.getMailId()+" "+ub.getPhoneNumber());
	 	%>
	 	<br><br>
	 	<a href="edit">Edit Profile</a><br><br>
	 	<a href="logout">logout</a>
	 </h2>
	 
	
	
	</center>
</body>
</html>