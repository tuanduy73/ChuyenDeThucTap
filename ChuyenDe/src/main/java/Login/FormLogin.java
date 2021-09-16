package Login;

import java.io.IOException;
import java.io.*;
import java.util.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC.JDBCConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class FormLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<body class='text-center'>");
		printWriter.println("<link href='css/login.css' rel='stylesheet' type='text/css'>");
		printWriter.println("<div class='form-signin'>");
		printWriter.println("<form action='/ChuyenDe/login' method='post'>");
		printWriter.println("<h1 class= 'h3 mb-3 fw-normal'> Dang Nhap </h1>");
		
		printWriter.println("<div class='form-floating'>");
		printWriter.println("<input type='text' class='form-control' id='floatingInput' name = 'username' placeholder='Username'>");
		printWriter.println("<label class='label' for='floatingInput'></label>");
		printWriter.println("</div>");
	
		printWriter.println("<div class='form-floating'>");
		printWriter.println("<input type='password' class='form-control' id='floatingPassword'  name = 'password' placeholder='Password'>");
		printWriter.println("<label class='pass' for='floatingPassword'></label>");
		printWriter.println("</div>");
		printWriter.println("<br>");
		
		printWriter.println("<input type ='submit' value = 'LOGIN' class='w-100 btn btn-lg btn-primary'>");
		printWriter.println("<input type ='reset' value = 'RESET' class='w-100 btn btn-lg btn-primary'>");
		printWriter.println("</a>");
		printWriter.println("</form>");
		printWriter.println("<a href='WebJava/ForgotPass.jsp'> Forgot-Pass ");
		printWriter.println("</a>");
		printWriter.println("</div");
		printWriter.println("</body>");
		printWriter.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		try
		{
			
		String Username = req.getParameter("username");
		String Password = req.getParameter("password");
			JDBCConnection jdbc = new JDBCConnection();
			Connection connection = jdbc.getJDBCConnection();
			Statement stm = connection.createStatement();
			String sql="SELECT*FROM DANGNHAP WHERE TEN = '" + Username + "' AND MATKHAU = '" + Password + "'";
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next())
			{	
				resp.sendRedirect("/ChuyenDe/WebJava/ListGaming.jsp");
			}
			else
			{
				resp.sendError(500);	
			}
			connection.close();
			stm.close();
			rs.close();
			
	}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}

