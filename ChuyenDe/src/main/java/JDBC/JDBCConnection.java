package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = {"/login1"})
public class JDBCConnection extends HttpServlet {
	 public static Connection getJDBCConnection() 
	    {
	        final String user ="sa";
	        final String password ="123456";
	        final String url="jdbc:sqlserver://localhost:1433;databaseName=SUPERMARKET;user=" + user + ";password=" + password;
	        
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            return DriverManager.getConnection(url);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        
	        return null;
	        
	    }
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	        Connection connection = getJDBCConnection();
	        
	        PrintWriter printWriter = resp.getWriter();
	        
	        resp.setContentType("text/html");
	        if (connection != null)
	        {
	        printWriter.print("Thanh Cong !");
	        }
	        else {
	        	printWriter.println("That Bai !");
	        }
	    }
}
