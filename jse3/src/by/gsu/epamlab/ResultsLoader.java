package by.gsu.epamlab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.exceptions.ConnectionException;



public class ResultsLoader {
	
	private static final int LOGIN_IND = 1;
	private static final int TEST_IND = 2;
	private static final int DATE_IND = 3;
	private static final int MARK_IND = 4;
	
	private final static String SELECT_LOGIN_ID="SELECT idLogin FROM logins WHERE name = (?)" ;
	private final static String INSERT_LOGIN_ID="INSERT INTO logins (name) VALUES (?)" ;
	private final static String SELECT_TEST_ID="SELECT idTest FROM tests WHERE name = (?)" ;
	private final static String INSERT_TEST_ID="INSERT INTO tests (name) VALUES (?)" ;
	private final static String INSERT_RESULT = "INSERT INTO results(loginId, testId, dat, mark) VALUES (?,?,?,?)";
	private final static String DELETE_RESULTS = "DELETE FROM results";
	
	
	
	private static int getId (String name, PreparedStatement psSelect, PreparedStatement psInsert) throws SQLException {
		int id;
		ResultSet resultSet =null;
		psSelect.setString(LOGIN_IND, name);
		resultSet=psSelect.executeQuery();
		if(resultSet.first()) {
			id = resultSet.getInt(LOGIN_IND);
		} else {
			id = insert(name, psInsert);
		}
		return id;
	}
	
	private static int insert (String name, PreparedStatement psInsert) throws SQLException {
		psInsert.setString(LOGIN_IND, name);	
		int idInsert = psInsert.executeUpdate();
		if(idInsert==0) {
			 throw new SQLException("Creating user failed, no rows affected.");
		}
		int generatedId;
		ResultSet generatedKeys = psInsert.getGeneratedKeys();
		if(generatedKeys.next()) {
			generatedId=generatedKeys.getInt(LOGIN_IND);
		} else {
			throw new SQLException("Creating user failed, no ID obtained.");
		}
		
		return generatedId;
	}
	
	
	public static void loadResults(IResultDAO reader) throws ConnectionException {
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
				psInsertResult.setInt(LOGIN_IND, idLogin);
				psInsertResult.setInt(TEST_IND, idTest);
				psInsertResult.setDate(DATE_IND, result.getDate());
				psInsertResult.setInt(MARK_IND, result.getMark());
				psInsertResult.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ConnectionException("ERROR: Connection to database is failed " + e);
		}   finally {
			reader.closeReader();
			ConnectDB.closeStatement(psDeleteResults,psInsertTest,psInsertResult,psInsertLogin,psSelectLogin,psSelectTest);
			
			
		}
	}
}
