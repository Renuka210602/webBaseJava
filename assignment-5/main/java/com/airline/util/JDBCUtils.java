package com.airline.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	private static Connection con;
	public static Connection getDbConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String connectionUrl="jdbc:mysql://localhost:3306/airline_reservation_system";
		String userName="root";
		String password="password";
		Connection dbConnection = 
				DriverManager.getConnection(connectionUrl,userName,password);
		return dbConnection;
	}

}
