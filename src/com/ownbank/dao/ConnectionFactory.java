package com.ownbank.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found: "+e.getMessage());
		}
	}
	public static Connection getConnection()throws SQLException
	{
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String userName="project";
		String password="project";
		Connection connection=DriverManager.getConnection(url,userName,password);
		return connection;
	}
	
}
