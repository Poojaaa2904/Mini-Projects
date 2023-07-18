package ATM;
import java.sql.*;


import java.sql.ResultSet;
import java.sql.Connection;



public class Conn 
 	{
		Connection c;
		Statement st;
		ResultSet rs;
		PreparedStatement pstmt;
		
		
		public Conn()
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bnk","root","12345");
				st=c.createStatement();
//
					
			}
			catch(Exception e){
				System.out.println(e);
			}
}}
