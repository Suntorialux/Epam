import java.sql.SQLException;
import java.sql.Statement;

import by.gsu.epamlab.ConnectDB;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ConnectDB connect = ConnectDB.getConnectDB();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
