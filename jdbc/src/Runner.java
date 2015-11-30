import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Constants;
import beans.LenNum;

public class Runner {
	
	public static void main(String[] args) {
		
		final String QUERRY_MAIN = "SELECT ROUND(ABS(X1 - X2)+0.001) AS len, COUNT(*)"
				+ " AS num FROM coordinates GROUP BY len ORDER BY len ";
		final String QUERRY_DELETE_LINE = "DELETE FROM frequencies";
		final String QUERRY_INSERT = "INSERT INTO frequencies(Len, Num) VALUES(?, ?)";
		final String QUERRY_SELECT = "SELECT * FROM frequencies WHERE len>num";
		
		
		String driverName = "org.gjt.mm.mysql.Driver";
		String dbUrl = "jdbc:mysql://localhost/segments"; 
		String user = "use";
		String password = "111";
		
		List<LenNum> lenNums = new ArrayList<LenNum>();
	
		try {
			
			Class.forName(driverName);
			
			Connection connection = null;
			Statement statement = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;	
			
			try {
				connection = DriverManager.getConnection(dbUrl, user, password);
				statement = connection.createStatement();
				resultSet = statement.executeQuery(QUERRY_MAIN);
					while (resultSet.next()) {
						LenNum numLen = new LenNum(resultSet.getInt(Constants.INDEX_ONE), resultSet.getInt(Constants.INDEX_TWO));
						lenNums.add(numLen);			
					}
				resultSet.close();
				
				print(lenNums);
				
				statement.executeUpdate(QUERRY_DELETE_LINE);
				preparedStatement = connection.prepareStatement(QUERRY_INSERT);
					
				for(LenNum numLen : lenNums) {
					preparedStatement.setInt(Constants.INDEX_ONE, numLen.getLen());
					preparedStatement.setInt(Constants.INDEX_TWO, numLen.getNum());
					preparedStatement.executeUpdate();
				}
								
				resultSet = statement.executeQuery(QUERRY_SELECT);
				while(resultSet.next()) {
					System.out.println(resultSet.getString(Constants.INDEX_ONE)+";"+resultSet.getString(Constants.INDEX_TWO));
				}
			} finally {
								
				if(resultSet!=null) {
					resultSet.close();
				} else {
					throw new SQLException(Constants.ERROR_READING);
				} 
				if(preparedStatement!=null) {
					preparedStatement.close();
				} else {
					throw new SQLException(Constants.ERROR_STATEMENT);
				}
				if(statement!=null) {
					statement.close();
				} else {
					throw new SQLException(Constants.ERROR_STATEMENT);
				}
				if(connection!=null) {
					connection.close();
				} else {
					throw new SQLException(Constants.ERROR_CONNECTION);
				}
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private static void print(List<LenNum> lenNums) {
		for(LenNum numLen :lenNums) {
			System.out.println(numLen);
		}
		System.out.println();
	}
}