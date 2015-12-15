package by.gsu.epamlab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
	
	private static final String DRIVER_NAME = "org.gjt.mm.mysql.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/results"; 
	private static final String USER = "jse";
	private static final String PASSWORD = "jse";
		
	private static ConnectDB instance = new ConnectDB();
		
	private ConnectDB() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	private Connection createConnection () {
		Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
	}
	
	 public static Connection getConnection() {
	        return instance.createConnection();
	    }
	 
	 public static void closeResultSet(ResultSet resultSet) {
		 if(resultSet!=null) {
			 try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("Resource closing problem : " + e);
			}
		 }
	 }
	 
	 public static void closePreparedStatement (PreparedStatement preparedStatement) {
		 if(preparedStatement!=null) {
			 try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("Resource closing problem : " + e);
			}
		 }
	 }
	 
	 public static void closeConnection (Connection connection) {
		 if (connection!=null) {
			 try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("Resource closing problem : " + e);
			}
		 }
	 }
}
