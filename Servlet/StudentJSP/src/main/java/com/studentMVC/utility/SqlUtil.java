package com.studentMVC.utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {
	final static String DB_USER = "root";
	final static String DB_PASS = "root";
	final static String DB_NAME = "dba";
	final static String DB_URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	public static PreparedStatement statement;
	 public static Connection connection;
	
	static public void connectDB() throws ClassNotFoundException, SQLException {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
					
	}
	
	static public int insert() throws SQLException {
		int result = -1;
		result = statement.executeUpdate();
		return result;
	}
	
	static public int update() throws SQLException {
		int result = -1;
		result = statement.executeUpdate();
		return result;
	}
	
	static public int delete() throws SQLException {
		int result = -1;
		result = statement.executeUpdate();
		return result;
	}
	
	static public ResultSet fetch() throws SQLException {
		ResultSet resultSet = null;		
		resultSet = statement.executeQuery();
		return resultSet;
	}
	
	static public void close() throws SQLException {
		if(connection!=null && statement!=null) {
			statement.close();
			connection.close();
		}
	}
	
}
