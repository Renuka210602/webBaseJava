package practise.jdbc;
//This is a utility class used for obtaining a connection

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcUtil {
	public static Connection buildConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String connectionUrl="jdbc:mysql://localhost:3306/cdac";
		String userName="root";
		String password="password";
		Connection dbConnection = 
				DriverManager.getConnection(connectionUrl,userName,password);
		return dbConnection;
	}
}