<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Service.GamingService"%>
   <%@page import="Table.Gaming" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	GamingService gamingService = new GamingService();
	Gaming gaming = new Gaming();
	
	String TENSP = request.getParameter("TENSANPHAM");
	gamingService.deleteGaming(TENSP);
	response.sendRedirect("/ChuyenDe/WebJava/ListGaming.jsp");
	%>
</body>
</html>