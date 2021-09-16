package QuanLi;

import Table.Gaming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.NullPointerException;

public class GameDao {
	 public List<Gaming> getAllGaming() 
	    {
	        List<Gaming> gaming = new ArrayList<Gaming>();
	        
	        Connection connection = JDBC.JDBCConnection.getJDBCConnection();
	        
	        String sql ="SELECT * FROM GAMING";
	        
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next())
	            {
	                
	                Gaming gaming1 = new Gaming();
	                
	                gaming1.setTENSANPHAM(rs.getString("TENSANPHAM"));
	                gaming1.setSOLUONG(rs.getString("SOLUONG"));
	                gaming1.setGIATIEN(rs.getString("GIATIEN"));
	                gaming1.setNGAYSANXUAT(rs.getString("NGAYSANXUAT"));
	                gaming1.setXUATXU(rs.getString("XUATXU"));
	                gaming1.setABOUT(rs.getString("ABOUT"));
	                
	                gaming.add(gaming1);
	            }
	           
	        } catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return gaming;
	    }
	    public Gaming getGamingByName(String TENSANPHAM) 
	    {
	        Connection connection = JDBC.JDBCConnection.getJDBCConnection();
	        
	        String sql2 ="SELECT * FROM GAMING WHERE TENSANPHAM=? ";
	        
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
	            preparedStatement.setString(1, TENSANPHAM);
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next())
	            {
	                Gaming gaming1 = new Gaming();
	                
	                gaming1.setTENSANPHAM(rs.getString("TENSANPHAM"));
	                gaming1.setSOLUONG(rs.getString("SOLUONG"));
	                gaming1.setGIATIEN(rs.getString("GIATIEN"));
	                gaming1.setNGAYSANXUAT(rs.getString("NGAYSANXUAT"));
	                gaming1.setXUATXU(rs.getString("XUATXU"));
	                gaming1.setABOUT(rs.getString("ABOUT"));
	                
	                gaming1 = new Gaming();
	            }
	           
	        } catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
			return null;
	       
	    }
	    
	    public void addGaming (Gaming gaming)
	    {
	        Connection connection = JDBC.JDBCConnection.getJDBCConnection();
	        
	        String sql1 =" INSERT INTO GAMING(TENSANPHAM, SOLUONG, GIATIEN, NGAYSANXUAT, XUATXU, ABOUT) VALUES (?,?,?,?,?,?) ";
	        
	        try{
	            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
	            preparedStatement.setString(1, gaming.getTENSANPHAM());
	            preparedStatement.setString(2, gaming.getSOLUONG());
	            preparedStatement.setString(3, gaming.getGIATIEN());
	            preparedStatement.setString(4, gaming.getNGAYSANXUAT());
	            preparedStatement.setString(5, gaming.getXUATXU());
	            preparedStatement.setString(6, gaming.getABOUT());
	            
	            int rs = preparedStatement.executeUpdate();
	            System.out.println(rs);
	            
	        }catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	    }
	    public void updateGaming(Gaming gaming)
	    {
	        Connection connection = JDBC.JDBCConnection.getJDBCConnection();
	        
	        String sql2 = "UPDATE GAMING SET SOLUONG=?, GIATIEN=?, NGAYSANXUAT=?, XUATXU=?, ABOUT=? WHERE TENSANPHAM=? ";
	        
	        try{
	            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
	            preparedStatement.setString(1, gaming.getSOLUONG());
	            preparedStatement.setString(2, gaming.getGIATIEN());
	            preparedStatement.setString(3, gaming.getNGAYSANXUAT());
	            preparedStatement.setString(4, gaming.getXUATXU());
	            preparedStatement.setString(5, gaming.getABOUT());
	            preparedStatement.setString(6, gaming.getTENSANPHAM());
	            int rs = preparedStatement.executeUpdate();
	        }catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	    }
	    public void deletaGaming(String TenSanPham)
	    {
	        Connection connection = JDBC.JDBCConnection.getJDBCConnection();
	        
	        String sql3 = "DELETE FROM GAMING WHERE TENSANPHAM = ?";
	        
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql3);
	            preparedStatement.setString(1, TenSanPham);
	            int rs = preparedStatement.executeUpdate();
	            System.out.println(rs);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
