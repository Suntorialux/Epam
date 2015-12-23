import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import by.gsu.epamlab.ConnectDB;
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.ResultImplCsv;
import by.gsu.epamlab.ResultsLoader;
import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.exceptions.ConnectionException;
import by.gsu.epamlab.factories.ResultFactory;

public class RunnerLogic {

	final static String GET_AVG_MARK = "SELECT logins.name, ROUND(avg(results.mark),2)  AS mean " +
            "FROM results INNER JOIN logins ON logins.idLogin = results.loginId " +
            "GROUP BY name ORDER BY mean DESC";

    final static String GET_FIELD_FROM_TABLE_ON_MONTH ="SELECT logins.name , tests.name, results.dat, results.mark" +
            " FROM tests right JOIN" +
            " (logins right JOIN results ON logins.idLogin = results.loginId) ON tests.idTest = results.testId" +
            " WHERE Month(results.dat)=? AND YEAR(results.dat)=?" +
            " ORDER BY results.dat";

    final static String GET_FIELD_FROM_TABLE = "SELECT logins.name , tests.name, results.dat, results.mark from logins, tests, results "+
            "WHERE logins.idLogin = results.loginId AND tests.idTest = results.testId";
    
    final static int LOGIN_IND = 1;
    final static int TEST_IND = 2;
    final static int DATE_IND = 3;
    final static int MARK_IND = 4;
    final static String MONTH = "MM";
    final static String YEAR = "yyyy";
	
	
	
	public static void logic(ResultFactory resultFactory, String fileName) {
		        
        try{
			try {
				IResultDAO reader = resultFactory.getResultDaoFromFactory(fileName);
				ResultsLoader.loadResults(reader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("file is not found and the base has not been updated");
			}
			printResults(resultFactory);
			printAverageMarks(resultFactory);
			
			try {
				List<Result> results = getCurrentMonthResults(resultFactory);
				System.out.println();
				printLastDayResults(results);
				
			} catch (SQLException e) {
				System.err.println("ERROR_AVERAGE_MARKS " + e.getMessage());
			}
			
		} catch (ConnectionException e ) {
			System.err.println("ERROR_DB_CONNECTION " + e);
		} finally {
			ConnectDB.closeConnection();
		}
	}		
			
	
	private static void printResults (ResultFactory resultFactory) throws ConnectionException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps=connection.prepareStatement(GET_FIELD_FROM_TABLE);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				String login = resultSet.getString(LOGIN_IND);
				String test = resultSet.getString(TEST_IND);
				Date date = resultSet.getDate(DATE_IND);
				int mark = resultSet.getInt(MARK_IND);
				Result result = resultFactory.getResultFromFactory(login, test, date, mark); 
				System.out.println(result);
			}
			System.out.println(); 
		} catch (SQLException e) { 
			System.err.println("ERROR_PRINT_RESULTS " + e.getMessage());
		} finally {
			ConnectDB.closeResultSet(resultSet);
			ConnectDB.closeStatement(ps);
		}
	}
				
//3. Print the mean value of marks (2 digits after decimal point) on every student in descending order by the mean value. 
			
	private static void printAverageMarks (ResultFactory resultFactory) throws ConnectionException { 
		Connection connection = ConnectDB.getConnection();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(GET_AVG_MARK);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String login = resultSet.getString(LOGIN_IND);
				double mean = resultSet.getDouble(2);
				System.out.println(login+" = "+ resultFactory.getAVG(mean));
			}
			System.out.println();
		} catch (SQLException e) {
			System.err.println("ERROR_AVERAGE_MARKS " + e.getMessage());
		} finally {
			ConnectDB.closeResultSet(resultSet);
			ConnectDB.closeStatement(ps);
		}
	}
				
//4. Create a LinkedList implementation of tests results for the current month sorting by the date ascending and print it.
			
	private static List<Result> getCurrentMonthResults(ResultFactory resultFactory) throws  ConnectionException, SQLException {
		
		Connection connection = ConnectDB.getConnection();
		PreparedStatement ps = null;
		ResultSet resultSet = null;			
		try {
			List<Result> currentMonthResults = new LinkedList<Result>();
			ps = connection.prepareStatement(GET_FIELD_FROM_TABLE_ON_MONTH);
		    java.util.Date now = new java.util.Date();
		    SimpleDateFormat month = new SimpleDateFormat(MONTH);
		    SimpleDateFormat year = new SimpleDateFormat(YEAR);
		    int intMonth=Integer.parseInt(month.format(now));
		    int intYear = Integer.parseInt(year.format(now));
		    ps.setInt(1, intMonth);
		    ps.setInt(2, intYear);
		    resultSet = ps.executeQuery();
		    while (resultSet.next())  {
		        String login=resultSet.getString(LOGIN_IND);
		        String test=resultSet.getString(TEST_IND);
		        Date date=resultSet.getDate(DATE_IND);
		        int mark=resultSet.getInt(MARK_IND);
		        Result result = resultFactory.getResultFromFactory(login, test, date, mark);
		        System.out.println(result);
		        currentMonthResults.add(result);
		    }
	
		    return currentMonthResults;
		}
		finally {
			ConnectDB.closeResultSet(resultSet);
			ConnectDB.closeStatement(ps);
		}
	}
		
//5. Print tests results in the latest day of the current month (without SQL request), when tests have been passed.		 
		
	private static void printLastDayResults(List<Result> currentMonthResults) {
	
		if(!currentMonthResults.isEmpty()) {
	    	
	    ListIterator<Result> it = currentMonthResults.listIterator(currentMonthResults.size());
		   	Date lastDate = it.previous().getDate();
		             	
		   	for(it = currentMonthResults.listIterator(currentMonthResults.size()) ;it.hasPrevious();) {
		   		Result result = it.previous();
		   		if (result.getDate().equals(lastDate)) {
		   			System.out.println(result);
		   		}
		   	} 
		} 
	}
}
	


