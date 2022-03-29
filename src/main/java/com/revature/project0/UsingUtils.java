package com.revature.project0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingUtils {

	public static void main(String[] args) {
		
		Statement stmt;
		ResultSet rs;
		
		Connection conn = ConnectionUtils.createConnection();
		
		String sql= "select * from clients";
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
		while(rs.next())
			
			
		System.out.println(rs.getInt(1)+"rs.getString(client_name)"); }
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
