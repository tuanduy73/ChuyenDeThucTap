<%@page import="JDBC.JDBCConnection"%>
<%@page import="java.sql.Connection"%>
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

	<form action="AddPost.jsp" method='post'>
	
	<p>Ten San Pham Moi: </p>
	<input type="text" name="TenSanPham"><br>
	<p>So Luong: </p>
	<input type="text" name="SoLuong"><br>
	<p>Gia Tien: </p>
	<input type="text" name="GiaTien"><br>
	<p>Ngay San Xuat: </p>
	<input type="text" name="NgaySanXuat"><br>
	<p>Xuat Xu: </p>
	<input type="text" name="XuatXu"><br>
	<p>About: </p>
	<input type="text" name="About"><br>
	
	<input type="submit" value="Add"><br>

	</form>

		

</body>
</html>