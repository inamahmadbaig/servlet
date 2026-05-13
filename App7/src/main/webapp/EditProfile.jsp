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
	
		<h1>
			<%
				UserBean ub = (UserBean) application.getAttribute("userBean");
				String uname= (String) request.getAttribute("UserName");

		 		out.println("This Session belongs to - "+ uname+" <br><br>");
		 		out.println("<u> Edit Profile</u> <br><br>");
		 	
			%>
			<form action="update" method="post"> 
				First Name<input type="text" name="firstname" value="<%=ub.getFirstName() %>"><br><br>
				last Name <input type="text" name="lastname" value="<%=ub.getLastName()%>"><br><br>			
				 MailID	<input type="text" name="mailid" value="<%=ub.getMailId()%>"><br><br>
				Phone Number <input type="text" name="phone" value="<%=ub.getPhoneNumber() %>"><br><br>
				<input type="submit" value="Update">
				
				
				
			</form>
		</h1>
	</center>
</body>
</html>