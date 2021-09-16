<%@page import="QuanLi.GameDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="Service.GamingService"%>
   <%@page import="Table.Gaming" %>
   <%@page import="java.util.List" %>
   <%@page import="java.sql.ResultSet" %>
   <%@page import="java.sql.Statement" %>
   <%@page import="java.sql.Connection" %>
   <%@page import="JDBC.JDBCConnection" %>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
	<table border="2">
		<tr>
			<td>Ten San Pham</td>
			<td>So Luong</td>
			<td>Gia Tien</td>
			<td>Ngay San Xuat</td>
			<td>Xuat Xu</td>
			<td>About</td>
		</tr>
	<%

	List<Gaming> gamings = new GameDao().getAllGaming();
	
	for (Gaming gaming : gamings) {
		String editURL = "EditGame.jsp?masp=" + gaming.getTENSANPHAM();
        String deleteURL = "DeleteServlet?masp=" + gaming.getTENSANPHAM();
	%>
		<tr>
			<td><%=gaming.getTENSANPHAM() %></td>
			<td><%=gaming.getSOLUONG() %></td>
			<td><%=gaming.getGIATIEN() %></td>
			<td><%=gaming.getNGAYSANXUAT() %></td>
			<td><%=gaming.getXUATXU() %></td>
			<td><%=gaming.getABOUT() %></td>
			<th><a href="AddGaming.jsp">Add</a></th>
			<th><a href="EditGame.jsp?TENSANPHAM=<%=gaming.getTENSANPHAM()%>">Edit</a></th>
			<th><a href="DeletePost.jsp?TENSANPHAM=<%=gaming.getTENSANPHAM()%>">Delete</a></th>
		</tr>
	<%
	}
	%>
	
	</table>

</form>
</body>
</html>