<%@page import="java.util.Iterator"%>
<%@page import="com.pack1.EmpBean"%>
<%@page import="java.util.ArrayList"%>
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
		<u>Employee Data </u>
		<%
			ArrayList<EmpBean> al = (ArrayList<EmpBean>) request.getAttribute("list");
			if(al.size()==0){
				out.println("Employee table is Emoty");
				
			}
			else{
				Iterator<EmpBean> i = al.iterator();
				
				while(i.hasNext()){
					EmpBean eb = i.next();
					out.println(eb.geteId()+" "+eb.geteFName()+" "+eb.geteLName()+" "+eb.geteSal()+" "+eb.geteAdd()+"<br><br>");
				}
				
			}
		
		%>
		</h1>
		<jsp:include page="index.html"/>
	</center>
</body>
</html>