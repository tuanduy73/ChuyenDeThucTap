package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC.JDBCConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/ForgotPass"})
public class ForgotPassWord extends HttpServlet{	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		try {
			JDBCConnection jdbc = new JDBCConnection();
			Connection connection = jdbc.getJDBCConnection();
			Statement stm = connection.createStatement();
			String ID = req.getParameter("username");
			String sql="SELECT MATKHAU FROM DANGNHAP WHERE TEN ='"+ID+"'";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
			printWriter.println(rs.getString("MATKHAU"));
			}
			printWriter.println("<a href='login' type='text/html'> Back");
			printWriter.println("</a>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
