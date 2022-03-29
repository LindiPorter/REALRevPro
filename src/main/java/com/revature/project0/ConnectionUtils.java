package com.revature.project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	public static Connection createConnection() {
		String url= System.getenv("My_Project");
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}