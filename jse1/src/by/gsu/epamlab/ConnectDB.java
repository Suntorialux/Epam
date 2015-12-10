package by.gsu.epamlab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	private static final String driverName = "org.gjt.mm.mysql.Driver";
	private static final String dbUrl = "jdbc:mysql://localhost/segments"; 
	private static final String user = "use";
	private static final String password = "111";
	
	
	private static ConnectDB connectDB;
	private static Connection cn;
	
	
	private ConnectDB () throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		this.cn=DriverManager.getConnection(dbUrl, user, password);		
	}
	
	public static synchronized Connection getConnect () throws ClassNotFoundException, SQLException {
		if(connectDB==null) {
			connectDB=new ConnectDB();
		}
		return cn;
	}
	

}
