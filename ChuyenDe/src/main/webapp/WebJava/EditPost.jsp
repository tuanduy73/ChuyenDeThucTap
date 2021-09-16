<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Service.GamingService"%>
   <%@page import="Table.Gaming" %>
   <%@page import="QuanLi.GameDao" %>
   <%@page import="QuanLi.GameDao" %>
   <%@page import="java.util.List" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String TENSANPHAM = request.getParameter("TENSANPHAM");
	String SOLUONG = request.getParameter("SOLUONG");
	String GIATIEN = request.getParameter("GIATIEN");
	String NGAYSANXUAT = request.getParameter("NGAYSANXUAT");
	String XUATXU = request.getParameter("XUATXU");
	String ABOUT = request.getParameter("ABOUT");
	if(TENSANPHAM != null)
	{
		PreparedStatement pre = null;
		Connection con = null;
	
	String user ="sa";
	String password ="123456";
	String url="jdbc:sqlserver://localhost:1433;databaseName=SUPERMARKET;user=" + user + ";password=" + password;
	try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
	
	try{
		
		con = DriverManager.getConnection(url);
		String sql1 ="UPDATE GAMING SET SOLUONG=?, GIATIEN=?, NGAYSANXUAT=?, XUATXU=?, ABOUT=? WHERE TENSANPHAM='"+ TENSANPHAM + "'";

		pre = con.prepareStatement(sql1);
	
		pre.setString(1, SOLUONG);
		pre.setString(2, GIATIEN);
		pre.setString(3, NGAYSANXUAT);
		pre.setString(4, XUATXU);
		pre.setString(5, ABOUT);
		
	
		
		int i = pre.executeUpdate();
		if(i > 0)
		{
			System.out.println("Thanh Cong !");
			response.sendRedirect("/ChuyenDe/WebJava/ListGaming.jsp");
		}
	}
	
	catch(SQLException sql1)
	{
		request.setAttribute("error", sql1);
		out.println(sql1);
	}
	}
	
	%>
	
</body>
</html>