package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



//import java.sql.Connection;
public class DBconnection {
	
	
	public Connection getConnection() {
		Connection con=null;
		
		try {
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee\", \"root\", \"root\"");
			return con;
		}
		catch(Exception e){
			e.getStackTrace();
			
		}
		return con;
		
	}
	
	public boolean validateUser(String name,String pass)
	{
		try {
		String query = "select * from user where name = '"+name+"' and password='"+pass+"'";
		Statement st=this.getConnection().createStatement();
		
		ResultSet rs=st.executeQuery(query);
		if(rs.next())
		{
			return true;
		}
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}
		return false;
	}

}
