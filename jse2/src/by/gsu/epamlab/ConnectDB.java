package by.gsu.epamlab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.gsu.epamlab.exceptions.ConnectionException;

public class ConnectDB {
	
	private static final String DRIVER_NAME = "org.gjt.mm.mysql.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/results"; 
	private static final String USER = "jse";
	private static final String PASSWORD = "jse";
	
	private static final String ERROR_MESSAGE_RS = "ResultSet closing problem : "; 
	private static final String ERROR_MESSAGE_PS = "PreparedStatement closing problem : "; 
	private static final String ERROR_MESSAGE_CON = "Connection closing problem : "; 
		
	private static Connection connection ;
		
	private ConnectDB () {}
	
	public static synchronized Connection getConnection() throws ConnectionException {

		try {
			if (connection==null||connection.isClosed()) {
				Class.forName(DRIVER_NAME);
				connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new ConnectionException("ERROR: Connection to database is failed ");
		}
			
		return connection;
	}

	public static void closeResultSet(ResultSet resultSet) {
		 if(resultSet!=null) {
			 try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(ERROR_MESSAGE_RS + e);
			}
		 }
	 }
	
	 public static void closeStatement (Statement... statements) {
		 for(Statement statement : statements) {
			 try {
				 if(statement!=null) {
					 statement.close();
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(ERROR_MESSAGE_PS + e);
			}
		 }
	 }
	 
	 public static void closeConnection () {
		 if (connection!=null) {
			 try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(ERROR_MESSAGE_CON + e);
			}
		 }
	 }
}
