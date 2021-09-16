    <%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@page import="JDBC.JDBCConnection" %>
	<%@page import="java.sql.Connection" %>
    <%@page import="Service.GamingService" %>
    <%@page import="Table.Gaming" %>
    <%@page import="QuanLi.GameDao" %>
	<%@page import="java.util.List" %>
	<%@page import="java.sql.DriverManager"%>
	<%@page import="java.sql.ResultSet"%>
	<%@page import="java.sql.Statement"%>
	<%@page import="java.sql.Connection"%>
<%
	String TENSANPHAM = request.getParameter("TENSANPHAM");
	String user ="sa";
	String password ="123456";
	String url="jdbc:sqlserver://localhost:1433;databaseName=SUPERMARKET;user=" + user + ";password=" + password;
	try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
   	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
	<%
	try{
		
		connection = DriverManager.getConnection(url);
		statement = connection.createStatement();
		String sql ="SELECT * FROM GAMING WHERE TENSANPHAM= '"+ TENSANPHAM + "'";
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="EditPost.jsp" method="post">
	<p>Ten San Pham: </p>
	<input type="text" name="TENSANPHAM" value="<%=resultSet.getString("TENSANPHAM") %>" readonly="readonly"><br>
	<p>So Luong: </p>
	<input type="text" name="SOLUONG" value="<%=resultSet.getString("SOLUONG")  %>"><br>
	<p>Gia Tien: </p>
	<input type="text" name="GIATIEN" value="<%=resultSet.getString("GIATIEN") %>"><br>
	<p>Ngay San Xuat: </p>
	<input type="text" name="NGAYSANXUAT" value="<%=resultSet.getString("NGAYSANXUAT") %>"><br>
	<p>Xuat Xu: </p>
	<input type="text" name="XUATXU" value="<%=resultSet.getString("XUATXU") %>"><br>
	<p>About: </p>
	<input type="text" name="ABOUT" value="<%=resultSet.getString("ABOUT") %>"><br>	
	<input type="submit" value="submit">
	 </form> 
	<%
	}
	connection.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>   
</body>
</html>