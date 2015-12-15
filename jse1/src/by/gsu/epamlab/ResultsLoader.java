package by.gsu.epamlab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ResultsLoader {
	
	private final static String SELECT_LOGIN_ID="SELECT idLogin FROM logins WHERE name = (?)" ;
	private final static String INSERT_LOGIN_ID="INSERT INTO logins (name) VALUES (?)" ;
	private final static String SELECT_TEST_ID="SELECT idTest FROM tests WHERE name = (?)" ;
	private final static String INSERT_TEST_ID="INSERT INTO tests (name) VALUES (?)" ;
	private final static String INSERT_RESULT = "INSERT INTO results(loginId, testId, dat, mark) VALUES (?,?,?,?)";
	private final static String DELETE_RESULTS = "DELETE FROM results";
	
	
	
	private static int getId (String name, PreparedStatement psSelect, PreparedStatement psInsert) throws SQLException {
		int id;
		ResultSet resultSet =null;
		psSelect.setString(1, name);
		resultSet=psSelect.executeQuery();
		if(resultSet.first()) {
			id = resultSet.getInt(1);
		} else {
			id = insert(name, psInsert);
		}
		return id;
	}
	
	private static int insert (String name, PreparedStatement psInsert) throws SQLException {
		psInsert.setString(1, name);	
		int idInsert = psInsert.executeUpdate();
		if(idInsert==0) {
			 throw new SQLException("Creating user failed, no rows affected.");
		}
		int generatedId;
		ResultSet generatedKeys = psInsert.getGeneratedKeys();
		if(generatedKeys.next()) {
			generatedId=generatedKeys.getInt(1);
		} else {
			throw new SQLException("Creating user failed, no ID obtained.");
		}
		
		
		return generatedId;
	}
	
	
	public static void loadResults(IResultDAO reader) {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement psInsertResult = null;
		PreparedStatement psSelectLogin = null;
		PreparedStatement psInsertLogin = null;
		PreparedStatement psSelectTest = null;
		PreparedStatement psInsertTest = null;
		PreparedStatement psDeleteResults = null;
		try {
			psDeleteResults = connection.prepareStatement(DELETE_RESULTS);
			psDeleteResults.executeUpdate();
			psInsertResult = connection.prepareStatement(INSERT_RESULT);
			psSelectLogin = connection.prepareStatement(SELECT_LOGIN_ID);
			psSelectTest = connection.prepareStatement(SELECT_TEST_ID);
			psInsertLogin = connection.prepareStatement(INSERT_LOGIN_ID, Statement.RETURN_GENERATED_KEYS);
			psInsertTest = connection.prepareStatement(INSERT_TEST_ID, Statement.RETURN_GENERATED_KEYS);
			while(reader.hasResult()) {
				Result result = reader.nextResult();
				String login = result.getLogin();
				String test = result.getTest();
				int idLogin = getId(login, psSelectLogin, psInsertLogin);
				int idTest = getId(test, psSelectTest, psInsertTest);
				psInsertResult.setInt(1, idLogin);
				psInsertResult.setInt(2, idTest);
				psInsertResult.setDate(3, result.getDate());
				psInsertResult.setInt(4, result.getMark());
				psInsertResult.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			reader.closeReader();
			ConnectDB.closeStatement(psDeleteResults);
			ConnectDB.closeStatement(psInsertLogin);
			ConnectDB.closeStatement(psInsertResult);
			ConnectDB.closeStatement(psInsertTest);
			ConnectDB.closeStatement(psSelectLogin);
			ConnectDB.closeStatement(psSelectTest);
			ConnectDB.closeConnection(connection);
		}
	}
}
