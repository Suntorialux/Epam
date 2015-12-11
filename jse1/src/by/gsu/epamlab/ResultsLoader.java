package by.gsu.epamlab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ResultsLoader {
	
	private final static String SELECT_LOGIN_ID="SELECT idLogin FROM logins WHERE name = (?)" ;
	private final static String INSERT_LOGIN_ID="INSERT INTO logins (name) VALUES (?)" ;
	private final static String SELECT_TEST_ID="SELECT idTest FROM tests WHERE name = (?)" ;
	private final static String INSERT_TEST_ID="INSERT INTO tests (name) VALUES (?)" ;
	private final static String INSERT_RESULT = "INSERT INTO results(loginId, testId, dat, mark) VALUES (?,?,?,?)";
	
	
	
	private static int getId (String name, String selectLogin, String insert) {
		int loginId=0;
		
		
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement=null;
		PreparedStatement preparedStatement2=null;
		ResultSet resultSet =null;
		
		try {
			preparedStatement = connection.prepareStatement(selectLogin);
			preparedStatement.setString(1, name);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				loginId = resultSet.getInt(1);
			}
			resultSet.close();
			if(loginId==0) {
				preparedStatement2=connection.prepareStatement(insert);
				preparedStatement2.setString(1, name);
				preparedStatement2.executeUpdate();
				loginId=getId(name, selectLogin, insert);		
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeResultSet(resultSet);
			ConnectDB.closeStatement(preparedStatement);
			ConnectDB.closeStatement(preparedStatement2);
			ConnectDB.closeConnection(connection);	
		}
		return loginId;
	}
	
	
	public static void loadResults(IResultDAO reader) {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement =null;
		try {
			preparedStatement = connection.prepareStatement(INSERT_RESULT);
			while(reader.hasResult()) {
				Result result = reader.nextResult();
				String login = result.getLogin();
				String test = result.getTest();
				int idLogin = getId(login, SELECT_LOGIN_ID, INSERT_LOGIN_ID);
				int idTest = getId(test, SELECT_TEST_ID, INSERT_TEST_ID);
				preparedStatement.setInt(1, idLogin);
				preparedStatement.setInt(2, idTest);
				preparedStatement.setDate(3, result.getDate());
				preparedStatement.setInt(4, result.getMark());
				preparedStatement.executeUpdate();
			}
			reader.closeReader();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeStatement(preparedStatement);
			ConnectDB.closeConnection(connection);
		}
				
			
		
		
	}

}
