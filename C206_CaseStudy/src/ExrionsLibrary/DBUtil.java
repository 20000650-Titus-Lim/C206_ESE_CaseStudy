package ExrionsLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private  static String dbURL;
	private  static String dbUsername;
	private  static String dbPassword;
	
	private static Connection conn;
	private static Statement statement;
	private static ResultSet resultSet;

	/**
	* Stores database login data and path/URL 
	* @param url : URL or path of database
	* @param user : Username of database
	* @param pw : Password of database
	*/
	public static void init(String url, String user, String pw)
	{
		dbURL = url;
		dbUsername = user;
		dbPassword = pw;
	}

	/**
	* Attempts to connect to a database based on stored data created by init(String, String, String)
	*/
	private static void connect() {
		try {

			conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		} catch (SQLException se) {
			System.out.println("SQL Connection Error: " + se.getMessage());
		} 
	}

	/**
	* Executes an SQL query statement, then returns the result set
	* @param sqlStr : SQL query statement
	* @return Returns a resultset based on the SQL statement entered in the argument
	*/
	public static ResultSet getTable(String sqlStr) {
		try {
			connect();
	
			statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery(sqlStr);
	
		} catch (SQLException se) {
			System.out.println("SQL Error: " + se.getMessage());
		} 
	
		return resultSet;
	}

	/**
	* Executes an SQL update statement, then returns the affected rows
	* @param sqlStr : SQL update statement
	* @return Returns the affected rows from the update
	*/
	public static int execSQL(String sqlStr) {
		int affectedRows = 0;
		try {
			connect();
			statement = conn.createStatement();
			affectedRows = statement.executeUpdate(sqlStr);

		} catch (SQLException se) {
			System.out.println("SQL Error: " + se.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return affectedRows;
	}

	/**
	* Closes the database connection
	*/
	public static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {

		}
	}
}
