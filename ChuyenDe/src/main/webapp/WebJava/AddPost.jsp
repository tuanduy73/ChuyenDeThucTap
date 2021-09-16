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
	
	gaming.setTENSANPHAM(request.getParameter("TenSanPham"));
	gaming.setSOLUONG(request.getParameter("SoLuong"));
	gaming.setGIATIEN(request.getParameter("GiaTien"));
	gaming.setNGAYSANXUAT(request.getParameter("NgaySanXuat"));
	gaming.setXUATXU(request.getParameter("XuatXu"));
	gaming.setABOUT(request.getParameter("About"));
		
	gamingService.addGaming(gaming);
	response.sendRedirect("/ChuyenDe/WebJava/ListGaming.jsp");
	
	%>>
</body>
</html>